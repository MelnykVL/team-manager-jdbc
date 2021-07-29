package com.melnyk.teammanager.repository.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkillRepositoryImpl implements SkillRepository {

    private static final String SQL_SELECT_BY_ID =
            "SELECT * FROM skills WHERE skill_id=?;";
    private static final String SQL_SAVE_SKILL =
            "INSERT INTO skills(name) VALUES(?);";
    private static final String SQL_UPDATE_SKILL =
            "UPDATE skills SET name=? WHERE skill_id=?;";
    private static final String SQL_DELETE_SKILL =
            "DELETE FROM skills WHERE skill_id=?;";
    private static final String SQL_SELECT_ALL_SKILLS =
            "SELECT * FROM skills ORDER BY skill_id;";

    @Override
    public Optional getById(Integer integer) {
        Skill skill = new Skill();

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_ID)) {

            statement.setInt(1, integer);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                skill.setId(result.getInt("skill_id"));
                skill.setName(result.getString("name"));
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(skill);
    }

    @Override
    public Skill add(Skill skill) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SAVE_SKILL)){

            statement.setString(1, skill.getName());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skill;
    }

    @Override
    public Skill update(Skill skill) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_UPDATE_SKILL)){

            statement.setString(1, skill.getName());
            statement.setInt(2, skill.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skill;
    }

    @Override
    public void removeById(Integer integer) {

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_DELETE_SKILL)) {

            statement.setInt(1, integer);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT_ALL_SKILLS)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Skill skill = new Skill();

                skill.setId(result.getInt("skill_id"));
                skill.setName(result.getString("name"));

                skills.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skills;
    }
}
