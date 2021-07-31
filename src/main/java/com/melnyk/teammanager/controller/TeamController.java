package com.melnyk.teammanager.controller;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.model.TeamStatus;
import com.melnyk.teammanager.service.DeveloperService;
import com.melnyk.teammanager.service.TeamService;
import com.melnyk.teammanager.service.implementation.DeveloperServiceImpl;
import com.melnyk.teammanager.service.implementation.TeamServiceImpl;
import com.melnyk.teammanager.view.DeveloperView;
import com.melnyk.teammanager.view.TeamView;

import java.util.Scanner;

public class TeamController {
    private TeamView teamView = new TeamView();
    private DeveloperView developerView = new DeveloperView();
    private TeamService teamService = new TeamServiceImpl();
    private DeveloperService developerService = new DeveloperServiceImpl();

    public void execute() {

        Scanner scan = new Scanner(System.in);
        String command = "";

        teamView.showListOfCommands();

        System.out.print("Введите команду:");
        command = scan.nextLine();

        menu(command);

    }

    private void menu(String command) {

        if (command.equalsIgnoreCase("show")) {
            teamView.show();
            execute();
        } else if (command.equalsIgnoreCase("get")) {
            get();
            execute();
        } else if (command.equalsIgnoreCase("create")) {
            addDev();
            execute();
        } else if (command.equalsIgnoreCase("remove")) {
            removeObj();
            execute();
        } else if (command.equalsIgnoreCase("return")) {
            return;
        } else {
            System.out.println("Команда не найдена!");
            execute();
        }

    }

    private void removeObj() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        teamService.removeTeam(id);
    }

    private void removeObj(Team team) {
        teamService.removeTeam(team.getId());
    }

    private void addDev() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Имя: ");
        String name = scan.nextLine();
        TeamStatus status;

        status = inputStatus();
        if (status == null) return;

        teamService.saveTeam(new Team(name, status));

    }

    private TeamStatus inputStatus() {

        Scanner scan = new Scanner(System.in);
        String str = "";
        TeamStatus status;

        System.out.print("Введите новый статус (1 - active, 2 - deleted): ");
        str = scan.nextLine();

        if (str.equalsIgnoreCase("1"))
            status = TeamStatus.ACTIVE;
        else if (str.equalsIgnoreCase("2"))
            status = TeamStatus.DELETED;
        else {
            System.out.println("Введеного статуса не существует");
            return null;
        }
        return status;

    }

    private void get() {

        Scanner scan = new Scanner(System.in);

        Team team;
        String command = "";
        int id;

        System.out.print("Введите id: ");
        id = scan.nextInt();
        team = teamService.getTeam(id);

        teamView.show(id);

        if (team == null) return;

        teamView.showObjectActions();

        System.out.print("Введите действия: ");
        scan = new Scanner(System.in);
        command = scan.nextLine();

        menuForObj(team, command);

    }

    private void menuForObj(Team team, String command) {
        if (command.equalsIgnoreCase("add dev"))
            addDev(team);
        else if (command.equalsIgnoreCase("delete dev"))
            deleteDev(team);
        else if (command.equalsIgnoreCase("change name"))
            changeName(team);
        else if (command.equalsIgnoreCase("change status"))
            changeStatus(team);
        else if (command.equalsIgnoreCase("remove"))
            removeObj(team);
        else
            System.out.println("Команда не найдена!");
    }

    private void changeStatus(Team team) {

        team.setTeamStatus(inputStatus());

        teamService.updateTeam(team);

    }

    private void changeName(Team team) {

        Scanner scan = new Scanner(System.in);
        String name = "";

        System.out.print("Введите новое название для команды: ");
        name = scan.nextLine();

        team.setName(name);

        teamService.updateTeam(team);

    }

    private void addDev(Team team) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Выберите id добавляемого разработчика из списка ниже".toUpperCase());

        developerView.show();

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        team.addDeveloper(developerService.getDeveloper(id));

        teamService.updateTeam(team);

    }

    private void deleteDev(Team team) {

        if (team.getDevelopers().size() != 0) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Выберите id удаляемого разработчика из списка ниже".toUpperCase());

            System.out.println(team.getDevelopers());

            System.out.print("Введите id: ");
            int id = scan.nextInt();

            team.removeDeveloper(id);

            teamService.updateTeam(team);

        } else {
            System.out.println("Нечего удалять!");
        }

    }
}
