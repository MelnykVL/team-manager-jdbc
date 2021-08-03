package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.service.SkillService;
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
    @InjectMocks
    private SkillServiceImpl skillSer;

    @Test
    public void ifSkillNotExists() {
        Skill skill = new Skill();
        skill.setId(1);

        given(skillSer.getSkill(1)).willReturn(skill);

        skill = skillSer.getSkill(1);

        assertNotNull(skill);

        verify(skillSer).getSkill(1);
    }

    @Test
    public void ifSkillExists() {
        given(skillSer.getSkill(1)).willReturn(null);

        Skill skill = skillSer.getSkill(1);

        assertNull(skill);

        verify(skillSer).getSkill(1);
    }

    @Test
    public void saveSkill() {
        Skill skill = new Skill();

        given(skillSer.saveSkill(skill)).willReturn(skill);

        skill = skillSer.saveSkill(skill);

        assertNotNull(skill);

        verify(skillSer).saveSkill(skill);
    }

    @Test
    public void updateSkill() {
        Skill skill = new Skill();

        given(skillSer.updateSkill(skill)).willReturn(skill);

        skill = skillSer.updateSkill(skill);

        assertNotNull(skill);

        verify(skillSer).updateSkill(skill);
    }

    @Test
    public void removeById() {
        given(skillSer.removeSkill(1)).willReturn(true);

        boolean isSkillRemoved = skillSer.removeSkill(1);

        assertTrue(isSkillRemoved);

        verify(skillSer).removeSkill(1);
    }

    @Test
    public void ifGetFulledList() {
        List<Skill> skills = Arrays.asList(
                new Skill("Java"),
                new Skill("Hiber")
        );

        given(skillSer.getAllSkills()).willReturn(skills);

        List<Skill> returnedList = skillSer.getAllSkills();

        assertEquals(returnedList, skills);
    }

    @Test
    public void ifGetEmptyList() {
        given(skillSer.getAllSkills()).willReturn(new ArrayList<>());

        List<Skill> skillList = skillSer.getAllSkills();

        assertEquals(skillList, new ArrayList<>());
    }
}