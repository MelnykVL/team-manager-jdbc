package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.repository.implementation.SkillRepositoryImpl;
import com.melnyk.teammanager.service.SkillService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SkillServiceImplTest {

    @Mock
    private SkillRepository skillRep;

    @Test
    public void ifSkillNotExists() {
        Skill skill = new Skill();
        skill.setId(1);

        given(skillRep.getById(1)).willReturn(skill);

        skill = skillRep.getById(1);

        assertNotNull(skill);

        verify(skillRep).getById(1);
    }

    @Test
    public void ifSkillExists() {
        given(skillRep.getById(1)).willReturn(null);

        Skill skill = skillRep.getById(1);

        assertNull(skill);

        verify(skillRep).getById(1);
    }

    @Test
    public void saveSkill() {
        Skill skill = new Skill();

        given(skillRep.add(skill)).willReturn(true);

        boolean isSkillAdded = skillRep.add(skill);

        assertTrue(isSkillAdded);

        verify(skillRep).add(skill);
    }

    @Test
    public void updateSkill() {
        Skill skill = new Skill();

        given(skillRep.update(skill)).willReturn(true);

        boolean isSkillUpdated = skillRep.update(skill);

        assertTrue(isSkillUpdated);

        verify(skillRep).update(skill);
    }

    @Test
    public void removeById() {
        given(skillRep.removeById(1)).willReturn(true);

        boolean isSkillRemoved = skillRep.removeById(1);

        assertTrue(isSkillRemoved);

        verify(skillRep).removeById(1);
    }

    @Test
    public void ifGetFulledList() {
        List<Skill> skills = Arrays.asList(
                new Skill("Java"),
                new Skill("Hiber")
        );

        given(skillRep.getAll()).willReturn(skills);

        List<Skill> returnedList = skillRep.getAll();

        assertEquals(returnedList, skills);
    }

    @Test
    public void ifGetEmptyList() {
        given(skillRep.getAll()).willReturn(new ArrayList<>());

        List<Skill> skillList = skillRep.getAll();

        assertEquals(skillList, new ArrayList<>());
    }
}