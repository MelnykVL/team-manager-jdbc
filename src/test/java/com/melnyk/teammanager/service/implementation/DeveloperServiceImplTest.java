package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.DeveloperRepository;
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
public class DeveloperServiceImplTest {

    @Mock
    private DeveloperRepository devRep;

    @Test
    public void ifDevExists() {
        Developer dev = new Developer();
        dev.setId(1);

        given(devRep.getById(1)).willReturn(dev);

        dev = devRep.getById(1);

        assertNotNull(dev);
    }

    @Test
    public void ifDevNotExists() {
        given(devRep.getById(1)).willReturn(null);

        Developer dev = devRep.getById(1);

        assertNull(dev);
    }

    @Test
    public void saveDeveloper() {
        Developer dev = new Developer();

        given(devRep.add(dev)).willReturn(true);

        boolean isDevAdded = devRep.add(dev);

        assertTrue(isDevAdded);
    }

    @Test
    public void updateDeveloper() {
        Developer dev = new Developer();

        given(devRep.update(dev)).willReturn(true);

        boolean isDevUpdated = devRep.update(dev);

        assertTrue(isDevUpdated);
    }

    @Test
    public void removeDeveloper() {
        given(devRep.removeById(1)).willReturn(true);

        boolean isDevRemoved = devRep.removeById(1);

        assertTrue(isDevRemoved);
    }

    @Test
    public void ifGetFulledList() {
        List<Developer> developers = Arrays.asList(
                new Developer("Fn-1", "Sn-1"),
                new Developer("Fn-2", "Sn-2"),
                new Developer("Fn-3", "Sn-3")
        );

        given(devRep.getAll()).willReturn(developers);

        List<Developer> devList = devRep.getAll();

        assertEquals(devList, developers);
    }

    @Test
    public void ifGetEmptyList() {
        given(devRep.getAll()).willReturn(new ArrayList<>());

        List<Developer> devList = devRep.getAll();

        assertEquals(devList, new ArrayList<>());
    }
}