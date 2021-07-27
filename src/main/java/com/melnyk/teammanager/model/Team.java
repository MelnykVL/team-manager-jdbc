package com.melnyk.teammanager.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Integer id;
    private String name;
    private List<Developer> developers;

    public Team(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.developers = new ArrayList<>();
    }

    public Team(Integer id, String name, List<Developer> developers) {
        this.id = id;
        this.name = name;
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
                ", developers=" + developers +
                '}';
    }
}
