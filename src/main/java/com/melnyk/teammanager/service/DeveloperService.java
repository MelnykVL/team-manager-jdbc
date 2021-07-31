package com.melnyk.teammanager.service;

import com.melnyk.teammanager.model.Developer;

import java.util.List;

public interface DeveloperService {
    Developer getDeveloper(Integer id);
    void saveDeveloper(Developer developer);
    void updateDeveloper(Developer developer);
    List<Developer> getAllDevelopers();
}
