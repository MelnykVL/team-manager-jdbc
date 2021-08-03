package com.melnyk.teammanager.view;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.implementation.DeveloperRepositoryImpl;
import com.melnyk.teammanager.service.DeveloperService;
import com.melnyk.teammanager.service.implementation.DeveloperServiceImpl;

import java.util.List;

public class DeveloperView {
    private DeveloperService developerService = new DeveloperServiceImpl(new DeveloperRepositoryImpl());

    public void showListOfCommands() {
        System.out.println("\n|----Робота со списком разработчиков----|".toUpperCase());
        System.out.println("\t1. show (показать список разработчиков)");
        System.out.println("\t2. get (перейти к разработчику по идентификатору)");
        System.out.println("\t3. create (создать разработчика)");
        System.out.println("\t4. remove (удалить разработчика по идентефикатору)");
        System.out.println("\t5. return (вернуться в главное меню)");
    }

    public void show() {
        System.out.println("Список всех разработчиков");
        List<Developer> list = developerService.getAllDevelopers();
        for (Developer dev : list)
            System.out.println(dev);
    }

    public void show(Integer id) {

        Developer dev = developerService.getDeveloper(id);

        if (dev != null) {
            System.out.println("Разработчик с идентификатором " + id);
            System.out.println(dev);
        } else {
            System.out.println("Разработчика с таким id не существует");
        }

    }

    public void showObjectActions() {
        System.out.println("Действия над объектом:");
        System.out.println("\tadd skill (добавить навык)");
        System.out.println("\tdelete skill (удалить навык)");
        System.out.println("\tchange fn (изменить имя)");
        System.out.println("\tchange ln (изменить фамилию)");
        System.out.println("\tremove (удалить объект)");
    }
}
