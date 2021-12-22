package com.league.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {


    public static Connection connectDatabase() {

        final String jdbcURL = "jdbc:sqlite:C:\\Users\\hossam\\Desktop\\DataBase\\Egyption_League.db";
        Connection con = null;

        try {
            System.out.println("Connecting...");
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(jdbcURL);
            System.out.println("DB Status: Connected to 'Egyption_League' ");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "");
        }
        return con;
    }
}
