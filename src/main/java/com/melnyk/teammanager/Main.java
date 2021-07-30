package com.melnyk.teammanager;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.model.TeamStatus;
import com.melnyk.teammanager.repository.DeveloperRepository;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.repository.TeamRepository;
import com.melnyk.teammanager.repository.implementation.DeveloperRepositoryImpl;
import com.melnyk.teammanager.repository.implementation.SkillRepositoryImpl;
import com.melnyk.teammanager.repository.implementation.TeamRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        SkillRepository skillRep = new SkillRepositoryImpl();
        DeveloperRepository devRep = new DeveloperRepositoryImpl();
        TeamRepository teamRep = new TeamRepositoryImpl();

//        System.out.println(teamRep.getById(3).get());
//
//        Team team = teamRep.getById(3).get();
//        team.setName("Dream Team");
//        teamRep.update(team);
//
//        System.out.println(teamRep.getById(3).get());

        List<Team> teams = teamRep.getAll();
        for (Team team : teams)
            System.out.println(team);
    }
}
