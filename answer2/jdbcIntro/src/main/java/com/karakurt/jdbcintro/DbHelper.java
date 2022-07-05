package com.karakurt.jdbcintro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String username = "root";
    private String password = "example";
    private String dbUrl = "jdbc:mysql://localhost:3307/world";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,username,password);
    }

    public void showErrorMessage(SQLException sqlException){
        System.out.println("Error: " + sqlException.getMessage());
        System.out.println("Error Code: " + sqlException.getErrorCode());
    }
}
