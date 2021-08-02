package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.repository.implementation.SkillRepositoryImpl;
import com.melnyk.teammanager.service.SkillService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SkillServiceImplTest {

//    SkillRepository skillRep = new SkillRepositoryImpl();
    SkillRepositoryImpl skillRep = Mockito.mock(SkillRepositoryImpl.class);
//    SkillRepositoryImpl skillRep = Mockito.spy(SkillRepositoryImpl.class);

    @Test
    public void getSkill() {
        Skill skill = skillRep.getById(2).get();
        assertNotNull(skill.getId());
    }

    @Test
    public void ifSkillDoesNotExists() {
        Skill skill = skillRep.getAll().get(0);
        assertNull(skill.getId());
    }

    @Test
    public void saveSkill() {
    }

    @Test
    public void updateSkill() {
    }

    @Test
    public void getAllSkills() {
    }
}