package com.melnyk.teammanager.repository.implementation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionDBTest {
    Connection connection;

    @Before
    public void setUp() {
        connection = ConnectionDB.getConnection();
    }

    @Test
    public void shouldGetConnectionInstance() {
        assertNotNull("Connection failed!", connection);
    }

    @After
    public void tearDown() throws SQLException {
        connection.close();
    }
}