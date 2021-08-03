package com.melnyk.teammanager.service;

import com.melnyk.teammanager.model.Skill;

import java.util.List;

public interface SkillService {
    Skill getSkill(Integer id);
    Skill saveSkill(Skill skill);
    Skill updateSkill(Skill skill);
    boolean removeSkill(Integer id);
    List<Skill> getAllSkills();
}
