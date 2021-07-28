package com.melnyk.teammanager.repository.implementation;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

public class ConnectionDBTest {

    final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/team_manager?serverTimezone=UTC";
    final String DB_USERNAME = "root";
    final String DB_PASSWORD = "Vl_5860633";

    @Test
    public void getConnection() {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }

        assertNotNull("Connection failed!", connection);
    }
}