package com.melnyk.teammanager.repository.implementation;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

public class TeamRepositoryImpl implements TeamRepository {

    @Override
    public Optional getById(Integer integer) {
        Team team = new Team();

        return Optional.ofNullable(team);
    }

    @Override
    public Team add(Team team) {
        return null;
    }

    @Override
    public Team update(Team team) {
        return null;
    }

    @Override
    public void removeById(Integer integer) {

    }

    @Override
    public List<Team> getAll() {
        return null;
    }
}
