package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.service.SkillService;

import java.util.List;

public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRep;

    public SkillServiceImpl(SkillRepository sr) {
        this.skillRep = sr;
    }

    @Override
    public Skill getSkill(Integer id) {
        return skillRep.getById(id);
    }

    @Override
    public Skill saveSkill(Skill skill) {
        return skillRep.add(skill);
    }

    @Override
    public Skill updateSkill(Skill skill) {
        return skillRep.update(skill);
    }

    @Override
    public boolean removeSkill(Integer id) {
        return skillRep.removeById(id);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRep.getAll();
    }
}
