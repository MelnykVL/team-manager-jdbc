package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.TeamRepository;
import com.melnyk.teammanager.service.TeamService;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRep;

    public TeamServiceImpl(TeamRepository tr) {
        this.teamRep = tr;
    }

    @Override
    public Team getTeam(Integer id) {
        return teamRep.getById(id);
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRep.add(team);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRep.update(team);
    }

    @Override
    public boolean removeTeam(Integer id) {
        return teamRep.removeById(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRep.getAll();
    }
}
