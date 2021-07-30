package com.melnyk.teammanager;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.DeveloperRepository;
import com.melnyk.teammanager.repository.TeamRepository;
import com.melnyk.teammanager.repository.implementation.ConnectionDB;
import com.melnyk.teammanager.repository.implementation.DeveloperRepositoryImpl;
import com.melnyk.teammanager.repository.implementation.TeamRepositoryImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        TeamRepository teamRep = new TeamRepositoryImpl();
        DeveloperRepository devRep = new DeveloperRepositoryImpl();

//        List<Developer> teams = devRep.getAll();
        Developer dev = devRep.getById(2).get();
        System.out.println(dev);
//        for (Developer t : teams)
//            System.out.println(t);

    }
}
