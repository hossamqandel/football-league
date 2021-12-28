package com.league.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {


    public static Connection connectDatabase() {

        final String jdbcURL = "jdbc:sqlite:C:\\Users\\hossam\\Desktop\\DataBase\\Egyption_League.db";
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(jdbcURL);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "");
        }
        return con;
    }
}
