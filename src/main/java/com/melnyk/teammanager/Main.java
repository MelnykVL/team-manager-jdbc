package com.melnyk.teammanager;

import com.melnyk.teammanager.controller.DeveloperController;
import com.melnyk.teammanager.controller.SkillController;
import com.melnyk.teammanager.controller.TeamController;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        TeamController tc = new TeamController();
        DeveloperController dc = new DeveloperController();
        SkillController sc = new SkillController();

        String command = "";
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 - перейти к командам разработчиков");
            System.out.println("2 - перейти к разработчикам");
            System.out.println("3 - перейти к умениям");
            System.out.println("exit - завершение программы");

            System.out.print("Введите команду: ");
            command = scan.nextLine();

            if (command.equals("1"))
                tc.execute();
            else if (command.equals("2"))
                dc.execute();
            else if (command.equals("3"))
                sc.execute();
            else if (command.equalsIgnoreCase("exit"))
                return;
            else
                System.out.println("Команда не найдена");
        }

    }
}
