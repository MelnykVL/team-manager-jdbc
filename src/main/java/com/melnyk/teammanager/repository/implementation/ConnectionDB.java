package com.melnyk.teammanager.repository.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

    public static Connection getConnection() {
        Connection connection = null;
        Properties prop = loadPropertiesFile();

        final String DB_DRIVER = prop.getProperty("driver");
        final String DB_URL = prop.getProperty("url");
        final String DB_USERNAME = prop.getProperty("username");
        final String DB_PASSWORD = prop.getProperty("password");

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("!====Connection successful====!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static Properties loadPropertiesFile() {
        Properties prop = new Properties();
        try (InputStream in = new FileInputStream("src/main/resources/liquibase.properties")) {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
