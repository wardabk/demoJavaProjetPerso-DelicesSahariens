package com.wardacorp.delicesahariens.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/delicesahariens";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
