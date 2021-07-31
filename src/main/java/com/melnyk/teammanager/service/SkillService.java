package com.melnyk.teammanager.service;

import com.melnyk.teammanager.model.Skill;

import java.util.List;

public interface SkillService {
    Skill getSkill(Integer id);
    void saveSkill(Skill skill);
    void updateSkill(Skill skill);
    List<Skill> getAllSkills();
}
