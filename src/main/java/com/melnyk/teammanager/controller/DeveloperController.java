package com.melnyk.teammanager.controller;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.implementation.DeveloperRepositoryImpl;
import com.melnyk.teammanager.repository.implementation.SkillRepositoryImpl;
import com.melnyk.teammanager.service.DeveloperService;
import com.melnyk.teammanager.service.SkillService;
import com.melnyk.teammanager.service.implementation.DeveloperServiceImpl;
import com.melnyk.teammanager.service.implementation.SkillServiceImpl;
import com.melnyk.teammanager.view.DeveloperView;
import com.melnyk.teammanager.view.SkillView;

import java.util.Scanner;

public class DeveloperController {
    private DeveloperView developerView = new DeveloperView();
    private SkillView skillView = new SkillView();
    private DeveloperService developerService = new DeveloperServiceImpl(new DeveloperRepositoryImpl());
    private SkillService skillService = new SkillServiceImpl(new SkillRepositoryImpl());


    public void execute() {

        Scanner scan = new Scanner(System.in);
        String command = "";

        developerView.showListOfCommands();

        System.out.print("Введите команду: ");
        command = scan.nextLine();

        menu(command);

    }

    private void menu(String command) {

        if (command.equalsIgnoreCase("show")) {
            developerView.show();
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

        developerService.removeDeveloper(id);
    }

    private void removeObj(Developer dev) {
        developerService.removeDeveloper(dev.getId());
    }

    private void addDev() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Имя: ");
        String firstName = scan.nextLine();
        System.out.print("Фамилия: ");
        String lastName = scan.nextLine();

        developerService.saveDeveloper(new Developer(firstName, lastName));

    }

    private void get() {

        Scanner scan = new Scanner(System.in);

        Developer dev;
        String command = "";
        int id;

        System.out.print("Введите id: ");
        id = scan.nextInt();
        dev = developerService.getDeveloper(id);

        developerView.show(id);

        if (dev == null) return;

        developerView.showObjectActions();

        System.out.print("Введите действия: ");
        scan = new Scanner(System.in);
        command = scan.nextLine();

        menuForObj(dev, command);

    }

    private void menuForObj(Developer dev, String command) {
        if (command.equalsIgnoreCase("add skill"))
            addSkill(dev);
        else if (command.equalsIgnoreCase("delete skill"))
            removeSkill(dev);
        else if (command.equalsIgnoreCase("change fn"))
            changeFirstName(dev);
        else if (command.equalsIgnoreCase("change ln"))
            changeLastName(dev);
        else if (command.equalsIgnoreCase("remove"))
            removeObj(dev);
        else
            System.out.println("Команда не найдена!");
    }

    private void changeLastName(Developer dev) {

        Scanner scan = new Scanner(System.in);
        String lastName = "";

        System.out.print("Введите новую фамилию разработчика: ");
        lastName = scan.nextLine();

        dev.setLastName(lastName);

        developerService.updateDeveloper(dev);

    }

    private void changeFirstName(Developer dev) {

        Scanner scan = new Scanner(System.in);
        String firstName = "";

        System.out.print("Введите новое имя разработчика: ");
        firstName = scan.nextLine();

        dev.setFirstName(firstName);

        developerService.updateDeveloper(dev);

    }

    private void addSkill(Developer dev) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Выберите id добавляемого навыка из списка ниже".toUpperCase());

        skillView.show();

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        dev.addSkill(skillService.getSkill(id));

        developerService.updateDeveloper(dev);

    }

    private void removeSkill(Developer dev) {

        if (dev.getSkills().size() != 0) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Выберите id удаляемого навыка из списка ниже".toUpperCase());

            System.out.println(dev.getSkills());

            System.out.print("Введите id: ");
            int id = scan.nextInt();

            dev.removeSkill(id);

            developerService.updateDeveloper(dev);

        } else {
            System.out.println("Нечего удалять!");
        }

    }
}
