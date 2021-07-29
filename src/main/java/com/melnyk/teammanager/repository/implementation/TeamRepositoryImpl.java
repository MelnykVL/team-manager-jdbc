package com.melnyk.teammanager.repository.implementation;

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
            "SELECT * FROM teams WHERE team_id=?;";
    private static final String SQL_SAVE_TEAM =
            "INSERT INTO teams(name, team_status) VALUES(?,?);";
    private static final String SQL_UPDATE_TEAM =
            "UPDATE teams SET name=?, team_status=? WHERE team_id=?;";
    private static final String SQL_DELETE_TEAM =
            "DELETE FROM teams WHERE team_id=?;";
    private static final String SQL_SELECT_ALL_TEAMS =
            "SELECT * FROM teams ORDER BY team_id;";

    @Override
    public Optional getById(Integer integer) {
        Team team = new Team();

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT_TEAM_BY_ID)) {

            statement.setInt(1, integer);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                team.setId(result.getInt("team_id"));
                team.setName(result.getString("name"));
                team.setTeamStatus(TeamStatus.valueOf(result.getString("team_status")));
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(team);
    }

    @Override
    public Team add(Team team) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SAVE_TEAM)) {

            statement.setString(1, team.getName());
            statement.setString(2, team.getTeamStatus().toString());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return team;
    }

    @Override
    public Team update(Team team) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_UPDATE_TEAM)) {

            statement.setString(1, team.getName());
            statement.setString(2, team.getTeamStatus().toString());
            statement.setInt(3, team.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void removeById(Integer integer) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_DELETE_TEAM)){

            statement.setInt(1, integer);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Team> getAll() {
        List<Team> teams = new ArrayList<>();

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT_ALL_TEAMS)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Team team = new Team();

                team.setId(result.getInt("team_id"));
                team.setName(result.getString("name"));
                team.setTeamStatus(TeamStatus.valueOf(result.getString("team_status")));

                teams.add(team);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teams;
    }
}
