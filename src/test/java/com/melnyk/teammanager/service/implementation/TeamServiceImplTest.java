package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceImplTest {

    @Mock
    private TeamRepository teamRep;

    @Test
    public void ifTeamExists() {
        Team team = new Team();
        team.setId(1);

        given(teamRep.getById(1)).willReturn(team);

        team = teamRep.getById(1);

        assertNotNull(team);
    }

    @Test
    public void ifTeamNotExists() {
        given(teamRep.getById(1)).willReturn(null);

        Team team = teamRep.getById(1);

        assertNull(team);
    }

    @Test
    public void saveTeam() {
        Team team = new Team();

        given(teamRep.add(team)).willReturn(true);

        boolean isTeamAdded = teamRep.add(team);

        assertTrue(isTeamAdded);
    }

    @Test
    public void updateTeam() {
        Team team = new Team();

        given(teamRep.update(team)).willReturn(true);

        boolean isTeamUpdated = teamRep.update(team);

        assertTrue(isTeamUpdated);
    }

    @Test
    public void removeTeam() {
        given(teamRep.removeById(1)).willReturn(true);

        boolean isTeamRemoved = teamRep.removeById(1);

        assertTrue(isTeamRemoved);
    }

    @Test
    public void ifGetFulledList() {
        List<Team> teams = Arrays.asList(
                new Team(),
                new Team(),
                new Team()
        );

        given(teamRep.getAll()).willReturn(teams);

        List<Team> teamList = teamRep.getAll();

        assertEquals(teamList, teams);
    }
    @Test
    public void ifGetEmptyList() {
        given(teamRep.getAll()).willReturn(new ArrayList<>());

        List<Team> teamList = teamRep.getAll();

        assertEquals(teamList, new ArrayList<>());
    }

}