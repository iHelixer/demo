package org.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    static final  String URL = "jdbc:mysql://localhost:3306/demo";
    static final String USER = "root";
    static final String PASSWORD = "Root2025";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }



}
