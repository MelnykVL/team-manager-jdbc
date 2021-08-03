package com.melnyk.teammanager.service;

import com.melnyk.teammanager.model.Team;

import java.util.List;

public interface TeamService {
    Team getTeam(Integer id);
    Team saveTeam(Team team);
    Team updateTeam(Team team);
    boolean removeTeam(Integer id);
    List<Team> getAllTeams();
}
