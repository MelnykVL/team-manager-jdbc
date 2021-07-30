package com.melnyk.teammanager.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Developer {

    private Integer id;
    private String firstName;
    private String lastName;
    private Team team;
    private List<Skill> skills;

    public Developer() {
        this.team = null;
        this.skills = new ArrayList<>();
    }

    public Developer(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Developer(String firstName, String lastName, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }



    public Developer(String firstName, String lastName, List<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public void removeSkill(Integer id) {
        for (Skill s : this.skills)
            if (s.getId() == id)
                this.skills.remove(s);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", team=" + team +
                ", skills=" + skills +
                '}';
    }
}
