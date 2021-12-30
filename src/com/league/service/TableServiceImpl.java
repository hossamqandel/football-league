package com.league.service;

import com.league.db.DBConnect;
import com.league.entity.Match;
import com.league.interfaces.TableService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Formatter;

public class TableServiceImpl implements TableService {


    @Override
    public void displayTeamsOrderdByPoints() {
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Formatter fmt = new Formatter();
        try{
        String sql = "SELECT TEAM_NAME, POINTS, GF, GA FROM STANDINGS ORDER BY POINTS DESC";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
            System.out.println();
            fmt.format("%15s %15s %13s %16s\n", "TEAM NAME", "POINTS", "GF", "GA");
        while (rs.next()) {
            String teamName = rs.getString(1);
            int points = rs.getInt(2);
            int gf = rs.getInt(3);
            int ga = rs.getInt(4);

            fmt.format("%14s %14s %14S %17s\n", teamName, points, gf, ga);
        }
            System.out.println(fmt);
    } catch (
    SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}

    @Override
    public void displayTeamsOrderdByGoals() {
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Formatter fmt = new Formatter();
        try{
            String sql = "SELECT TEAM_NAME, POINTS, GF, GA FROM STANDINGS ORDER BY GF DESC";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println();
            fmt.format("%15s %15s %13s %16s\n", "TEAM NAME", "POINTS", "GF", "GA");
            while (rs.next()) {
                String teamName = rs.getString(1);
                int points = rs.getInt(2);
                int gf = rs.getInt(3);
                int ga = rs.getInt(4);

                fmt.format("%14s %14s %14S %17s\n", teamName, points, gf, ga);
            }
            System.out.println(fmt);
        } catch (
                SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
