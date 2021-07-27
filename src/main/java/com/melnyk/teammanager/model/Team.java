package com.melnyk.teammanager.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Integer id;
    private String name;
    private TeamStatus teamStatus;
    private List<Developer> developers;

    public Team() {
        this.teamStatus = TeamStatus.ACTIVE;
        this.developers = new ArrayList<>();
    }

    public Team(String name) {
        this();
        this.name = name;
    }

    public Team(String name, TeamStatus teamStatus) {
        this.name = name;
        this.teamStatus = teamStatus;
        this.developers = new ArrayList<>();
    }

    public Team(String name, TeamStatus teamStatus, List<Developer> developers) {
        this.name = name;
        this.teamStatus = teamStatus;
        this.developers = developers;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public void addDeveloper(Developer dev) {
        this.developers.add(dev);
    }

    public  void removeDeveloper(Integer id) {
        for (Developer dev : this.developers)
            if (dev.getId() == id)
                this.developers.remove(dev);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamStatus=" + teamStatus +
                ", developers=" + developers +
                '}';
    }

}
