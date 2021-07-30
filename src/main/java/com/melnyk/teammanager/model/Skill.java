package com.melnyk.teammanager.model;

import java.util.ArrayList;
import java.util.List;

public class Skill {

    private Integer id;
    private String name;
//    private List<Developer> developers;

//    public Skill() {
//        this.developers = new ArrayList<>();
//    }

    public Skill() {}

    public Skill(String name) {
//        this();
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
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

//    public List<Developer> getDevelopers() {
//        return developers;
//    }
//
//    public void setDevelopers(List<Developer> developers) {
//        this.developers = developers;
//    }
//
//    public void addDeveloper(Developer dev) {
//        this.developers.add(dev);
//    }
//
//    public void removeDeveloper(Integer id) {
//        for (Developer dev : this.developers)
//            if (dev.getId() == id)
//                this.developers.remove(dev);
//    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", developers=" + developers +
                '}';
    }
}
