package com.melnyk.teammanager.service;

import com.melnyk.teammanager.model.Developer;

import java.util.List;

public interface DeveloperService {
    Developer getDeveloper(Integer id);
    Developer saveDeveloper(Developer developer);
    Developer updateDeveloper(Developer developer);
    boolean removeDeveloper(Integer id);
    List<Developer> getAllDevelopers();
}
