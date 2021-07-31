package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.DeveloperRepository;
import com.melnyk.teammanager.repository.implementation.DeveloperRepositoryImpl;
import com.melnyk.teammanager.service.DeveloperService;

import java.util.List;

public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository devRep = new DeveloperRepositoryImpl();

    @Override
    public Developer getDeveloper(Integer id) {
        return devRep.getById(id).get();
    }

    @Override
    public void saveDeveloper(Developer dev) {
        devRep.add(dev);
    }

    @Override
    public void updateDeveloper(Developer dev) {
        devRep.update(dev);
    }

    @Override
    public void removeDeveloper(Integer id) {
        devRep.removeById(id);
    }

    @Override
    public List<Developer> getAllDevelopers() {
        return devRep.getAll();
    }
}
