package com.melnyk.teammanager.repository.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.model.TeamStatus;
import com.melnyk.teammanager.repository.DeveloperRepository;

import java.sql.*;
import java.util.*;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    private static final String SQL_SELECT_DEVELOPER_BY_ID =
            "SELECT * FROM developers" +
                    " LEFT JOIN teams ON developers.team_id = teams.team_id" +
                    " LEFT JOIN developers_skills ON developers.developer_id = developers_skills.developer_id" +
                    " LEFT JOIN skills ON skills.skill_id = developers_skills.skill_id" +
                    " WHERE developers.developer_id = ?;";
    private static final String SQL_SAVE_DEVELOPER =
            "INSERT INTO developers(first_name, last_name, team_id) VALUES(?,?,?);";
    private static final String SQL_UPDATE_DEVELOPER =
            "UPDATE developers SET first_name=?, last_name=?, team_id=? WHERE developer_id=?;";
    private static final String SQL_DELETE_DEVELOPER =
            "DELETE FROM developers WHERE developer_id=?;";
    private static final String SQL_SELECT_ALL_DEVELOPERS =
            "SELECT * FROM developers" +
                    " LEFT JOIN developers_skills ON developers.developer_id = developers_skills.developer_id" +
                    " LEFT JOIN skills ON skills.skill_id = developers_skills.skill_id" +
                    " LEFT JOIN teams ON developers.team_id = teams.team_id;";
    private static final String SQL_ADD_SKILL_FOR_DEV =
            "INSERT INTO developers_skills(developer_id, skill_id) VALUES(?,?);";

    @Override
    public Optional getById(Integer integer) {
        Team team = new Team();
        Developer developer = new Developer();
        Skill skill;

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT_DEVELOPER_BY_ID)) {

            statement.setInt(1, integer);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                developer.setId(result.getInt("developer_id"));
                developer.setFirstName(result.getString("first_name"));
                developer.setLastName(result.getString("last_name"));

                if (result.getObject("team_id") != null) {
                    team.setId((result.getInt("teams.team_id")));
                    team.setName(result.getString("teams.name"));
                    team.setTeamStatus(TeamStatus.valueOf((String) result.getObject("team_status")));

                    developer.setTeam(team);
                    team.addDeveloper(developer);
                }

                while (!result.isAfterLast() && result.getInt("skills.skill_id") != 0) {
                    skill = new Skill();

                    skill.setId(result.getInt("skills.skill_id"));
                    skill.setName(result.getString("skills.name"));
                    developer.addSkill(skill);
//                    skill.addDeveloper(developer);

                    result.next();
                }
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(developer);
    }

    @Override
    public Developer add(Developer developer) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SAVE_DEVELOPER)) {

            statement.setString(1, developer.getFirstName());
            statement.setString(2, developer.getLastName());
            if (developer.getTeam() != null)
                statement.setInt(3, developer.getTeam().getId());
            else
                statement.setNull(3, Types.NULL);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return developer;
    }

    @Override
    public Developer update(Developer developer) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_UPDATE_DEVELOPER)) {

            statement.setString(1, developer.getFirstName());
            statement.setString(2, developer.getLastName());
            if (developer.getTeam() != null)
                statement.setInt(3, developer.getTeam().getId());
            else
                statement.setNull(3, Types.NULL);
            statement.setInt(4, developer.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return developer;
    }

    @Override
    public void removeById(Integer integer) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_DELETE_DEVELOPER)) {

            statement.setInt(1, integer);

            statement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT_ALL_DEVELOPERS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet result = statement.executeQuery();
            Team team;
            Developer dev;
            Skill skill;

            while (result.next()) {
                team = new Team();
                dev = new Developer();

                dev.setId(result.getInt("developer_id"));
                dev.setFirstName(result.getString("first_name"));
                dev.setLastName(result.getString("last_name"));

                if (result.getObject("teams.team_id") != null) {
                    team.setId((result.getInt("teams.team_id")));
                    team.setName(result.getString("teams.name"));
                    team.setTeamStatus(TeamStatus.valueOf((String) result.getObject("team_status")));

                    dev.setTeam(team);
                    team.addDeveloper(dev);
                }

                while (result.getObject("skills.skill_id") != null &&
                        !result.isAfterLast() &&
                        result.getInt("developers_skills.developer_id") == dev.getId()) {
                    skill = new Skill();

                    skill.setId(result.getInt("skills.skill_id"));
                    skill.setName(result.getString("skills.name"));

                    dev.addSkill(skill);
//                    skill.addDeveloper(dev);

                    result.next();
                }

                developers.add(dev);
//                result.previous();
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return developers;
    }

    @Override
    public void linkSkillToDev(Developer dev) {
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_ADD_SKILL_FOR_DEV)) {
            con.setAutoCommit(false);

            Integer id = dev.getId();

            for (Skill s : dev.getSkills()) {
                statement.setInt(1, id);
                statement.setInt(2, s.getId());

                statement.addBatch();
            }

            statement.executeBatch();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
