package com.melnyk.teammanager;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.model.TeamStatus;
import com.melnyk.teammanager.repository.TeamRepository;
import com.melnyk.teammanager.repository.implementation.TeamRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TeamRepository teamRep = new TeamRepositoryImpl();

        List<Team> teams = teamRep.getAll();

        for (Team t : teams)
            System.out.println(t);

    }
}
