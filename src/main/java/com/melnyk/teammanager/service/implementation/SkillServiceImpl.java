package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.repository.implementation.SkillRepositoryImpl;
import com.melnyk.teammanager.service.SkillService;

import java.util.List;

public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRep = new SkillRepositoryImpl();

    @Override
    public Skill getSkill(Integer id) {
        return skillRep.getById(id);
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRep.add(skill);
    }

    @Override
    public void updateSkill(Skill skill) {
        skillRep.update(skill);
    }

    @Override
    public void removeSkill(Integer id) {
        skillRep.removeById(id);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRep.getAll();
    }
}
