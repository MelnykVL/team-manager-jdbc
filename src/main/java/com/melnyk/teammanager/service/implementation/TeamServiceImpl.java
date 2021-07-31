package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.TeamRepository;
import com.melnyk.teammanager.repository.implementation.TeamRepositoryImpl;
import com.melnyk.teammanager.service.TeamService;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRep = new TeamRepositoryImpl();

    @Override
    public Team getTeam(Integer id) {
        return teamRep.getById(id).get();
    }

    @Override
    public void saveTeam(Team team) {
        teamRep.add(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamRep.update(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRep.getAll();
    }
}
