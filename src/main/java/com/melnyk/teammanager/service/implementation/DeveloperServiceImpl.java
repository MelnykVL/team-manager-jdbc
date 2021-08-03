package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.DeveloperRepository;
import com.melnyk.teammanager.service.DeveloperService;

import java.util.List;

public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository devRep;

    public DeveloperServiceImpl(DeveloperRepository dr) {
        this.devRep = dr;
    }

    @Override
    public Developer getDeveloper(Integer id) {
        return devRep.getById(id);
    }

    @Override
    public Developer saveDeveloper(Developer dev) {
        return devRep.add(dev);
    }

    @Override
    public Developer updateDeveloper(Developer dev) {
        return devRep.update(dev);
    }

    @Override
    public boolean removeDeveloper(Integer id) {
        return devRep.removeById(id);
    }

    @Override
    public List<Developer> getAllDevelopers() {
        return devRep.getAll();
    }
}
