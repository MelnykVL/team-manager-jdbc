package com.melnyk.teammanager;

import com.melnyk.teammanager.repository.implementation.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection con = ConnectionDB.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM skills;");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(ConnectionDB.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println(ConnectionDB.getConnection());
        }

    }
}
