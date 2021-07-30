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

        List<Developer> developers = devRep.getAll();
        for (Developer dev : developers)
            System.out.println(dev);

    }
}
