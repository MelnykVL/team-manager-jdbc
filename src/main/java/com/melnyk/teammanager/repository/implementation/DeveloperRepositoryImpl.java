package com.melnyk.teammanager.repository.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.DeveloperRepository;

import java.util.List;
import java.util.Optional;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    @Override
    public Optional getById(Integer integer) {
        Developer developer = new Developer();

        return Optional.ofNullable(developer);
    }

    @Override
    public Developer add(Developer developer) {
        return null;
    }

    @Override
    public Developer update(Developer developer) {
        return null;
    }

    @Override
    public void removeById(Integer integer) {

    }

    @Override
    public List<Developer> getAll() {
        return null;
    }
}
