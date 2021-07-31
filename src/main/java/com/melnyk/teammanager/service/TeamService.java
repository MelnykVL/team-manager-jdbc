package com.melnyk.teammanager.service;

import com.melnyk.teammanager.model.Team;

import java.util.List;

public interface TeamService {
    Team getTeam(Integer id);
    void saveTeam(Team team);
    void updateTeam(Team team);
    List<Team> getAllTeams();
}
