package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.service.SkillService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SkillServiceImplTest {

    SkillService skillRep = new SkillServiceImpl();
//    SkillServiceImpl skillRep = Mockito.mock(SkillServiceImpl.class);
//    SkillServiceImpl skillRep = Mockito.spy(SkillServiceImpl.class);

    @Test
    public void getSkill() {
        Skill skill = skillRep.getSkill(2);
        assertNotNull(skill.getId());
    }

    @Test
    public void ifSkillDoesNotExists() {
        Skill skill = skillRep.getSkill(0);
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