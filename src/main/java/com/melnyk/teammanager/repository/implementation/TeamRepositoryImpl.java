package com.melnyk.teammanager.repository.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.model.TeamStatus;
import com.melnyk.teammanager.repository.TeamRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamRepositoryImpl implements TeamRepository {

    private static final String SQL_SELECT_TEAM_BY_ID =
            "SELECT * FROM teams" +
                    " LEFT JOIN developers ON developers.team_id = teams.team_id" +
                    " WHERE teams.team_id = ?;";
    private static final String SQL_SAVE_TEAM =
            "INSERT INTO teams(name, team_status) VALUES(?,?);";
    private static final String SQL_UPDATE_TEAM =
            "UPDATE teams SET name=?, team_status=? WHERE team_id=?;";
    private static final String SQL_DELETE_TEAM =
            "DELETE FROM teams WHERE team_id=?;";
    private static final String SQL_SELECT_ALL_TEAMS =
            "SELECT * FROM teams" +
            " LEFT JOIN developers" +
            " ON developers.team_id = teams.team_id;";

    @Override
    public Team getById(Integer integer) {
        Team team = new Team();
        Developer developer;

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT_TEAM_BY_ID)) {

            statement.setInt(1, integer);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                team.setId(result.getInt("team_id"));
                team.setName(result.getString("name"));
                team.setTeamStatus(TeamStatus.valueOf(result.getString("team_status")));

                while (!result.isAfterLast() && result.getInt("developers.developer_id") != 0) {
                    developer = new Developer();

                    developer.setId(result.getInt("developers.developer_id"));
                    developer.setFirstName(result.getString("developers.first_name"));
                    developer.setLastName(result.getString("developers.last_name"));

                    developer.setTeam(team);
                    team.addDeveloper(developer);

                    result.next();
                }
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return team;
    }

    @Override
    public boolean add(Team team) {
        boolean status = false;

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SAVE_TEAM)) {

            statement.setString(1, team.getName());
            statement.setString(2, team.getTeamStatus().toString());

            status = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean update(Team team) {
        boolean status = false;

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_UPDATE_TEAM)) {

            statement.setString(1, team.getName());
            statement.setString(2, team.getTeamStatus().toString());
            statement.setInt(3, team.getId());

            status = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean removeById(Integer integer) {
        boolean status = false;

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_DELETE_TEAM)){

            statement.setInt(1, integer);

            status = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<Team> getAll() {
        List<Team> teams = new ArrayList<>();

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT_ALL_TEAMS,
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            Team team;
            Developer dev;

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                team = new Team();

                team.setId(result.getInt("team_id"));
                team.setName(result.getString("name"));
                team.setTeamStatus(TeamStatus.valueOf(result.getString("team_status")));

                if (result.getObject("developer_id") != null) {
                    while (!result.isAfterLast() && team.getId() == result.getInt("developers.team_id")) {
                        dev = new Developer();

                        dev.setId(result.getInt("developer_id"));
                        dev.setFirstName(result.getString("first_name"));
                        dev.setLastName(result.getString("last_name"));

                        team.addDeveloper(dev);

                        result.next();
                    }
                    result.previous();
                }

                teams.add(team);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teams;
    }
}
