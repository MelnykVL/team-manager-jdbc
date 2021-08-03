package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.TeamRepository;
import com.melnyk.teammanager.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
    @InjectMocks
    private TeamServiceImpl teamSer;

    @Test
    public void ifTeamExists() {
        Team team = new Team();
        team.setId(1);

        given(teamSer.getTeam(1)).willReturn(team);

        team = teamSer.getTeam(1);

        assertNotNull(team);
    }

    @Test
    public void ifTeamNotExists() {
        given(teamSer.getTeam(1)).willReturn(null);

        Team team = teamSer.getTeam(1);

        assertNull(team);
    }

    @Test
    public void saveTeam() {
        Team team = new Team();

        given(teamSer.saveTeam(team)).willReturn(team);

        team = teamSer.saveTeam(team);

        assertNotNull(team);
    }

    @Test
    public void updateTeam() {
        Team team = new Team();

        given(teamSer.updateTeam(team)).willReturn(team);

        team = teamSer.updateTeam(team);

        assertNotNull(team);
    }

    @Test
    public void removeTeam() {
        given(teamSer.removeTeam(1)).willReturn(true);

        boolean isTeamRemoved = teamSer.removeTeam(1);

        assertTrue(isTeamRemoved);
    }

    @Test
    public void ifGetFulledList() {
        List<Team> teams = Arrays.asList(
                new Team(),
                new Team(),
                new Team()
        );

        given(teamSer.getAllTeams()).willReturn(teams);

        List<Team> teamList = teamSer.getAllTeams();

        assertEquals(teamList, teams);
    }
    @Test
    public void ifGetEmptyList() {
        given(teamSer.getAllTeams()).willReturn(new ArrayList<>());

        List<Team> teamList = teamSer.getAllTeams();

        assertEquals(teamList, new ArrayList<>());
    }

}