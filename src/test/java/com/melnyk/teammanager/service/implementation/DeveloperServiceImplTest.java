package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.implementation.DeveloperRepositoryImpl;
import com.melnyk.teammanager.service.DeveloperService;
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
public class DeveloperServiceImplTest {

    @Mock
    private DeveloperRepositoryImpl devRep;
    @InjectMocks
    private DeveloperServiceImpl devSer;

    @Test
    public void ifDevExists() {
        Developer dev = new Developer();
        dev.setId(1);

        given(devSer.getDeveloper(1)).willReturn(dev);

        dev = devSer.getDeveloper(1);

        assertNotNull(dev);
    }

    @Test
    public void ifDevNotExists() {
        given(devSer.getDeveloper(1)).willReturn(null);

        Developer dev = devSer.getDeveloper(1);

        assertNull(dev);
    }

    @Test
    public void saveDeveloper() {
        Developer dev = new Developer();

        given(devSer.saveDeveloper(dev)).willReturn(dev);

        dev = devSer.saveDeveloper(dev);

        assertNotNull(dev);
    }

    @Test
    public void updateDeveloper() {
        Developer dev = new Developer();

        given(devSer.updateDeveloper(dev)).willReturn(dev);

        dev = devSer.updateDeveloper(dev);

        assertNotNull(dev);
    }

    @Test
    public void removeDeveloper() {
        given(devSer.removeDeveloper(1)).willReturn(true);

        boolean isDevRemoved = devSer.removeDeveloper(1);

        assertTrue(isDevRemoved);
    }

    @Test
    public void ifGetFulledList() {
        List<Developer> developers = Arrays.asList(
                new Developer("Fn-1", "Sn-1"),
                new Developer("Fn-2", "Sn-2"),
                new Developer("Fn-3", "Sn-3")
        );

        given(devSer.getAllDevelopers()).willReturn(developers);

        List<Developer> devList = devSer.getAllDevelopers();

        assertEquals(devList, developers);
    }

    @Test
    public void ifGetEmptyList() {
        given(devSer.getAllDevelopers()).willReturn(new ArrayList<>());

        List<Developer> devList = devSer.getAllDevelopers();

        assertEquals(devList, new ArrayList<>());
    }
}