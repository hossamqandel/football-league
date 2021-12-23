package com.league.service;

import com.league.db.DBConnect;
import com.league.entity.Player;
import com.league.interfaces.PlayerService;

import java.sql.*;

public class PlayerServiceImpl implements PlayerService {

    @Override
    public void addPlayer(Player newPlayer) {
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        try {
            final String sql = "INSERT INTO PLAYER(NAME, AGE, NUMBER, POSITION, TEAM_ID, ROLE_WITH_DESCRIPTION, TOTAL_GOALS, IS_CAPTAIN, RANK) VALUES(?,?,?,?,?,?,?,?,?) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, newPlayer.getName());
            ps.setInt(2, newPlayer.getAge());
            ps.setInt(3, newPlayer.getNumber());
            ps.setString(4, newPlayer.getPosition());
            ps.setInt(5, newPlayer.getTeamId());
            ps.setString(6, newPlayer.getRoleWithDescription());
            ps.setInt(7, newPlayer.getTotalGoals());
            ps.setBoolean(8, newPlayer.isCaptain());
            ps.setDouble(9, newPlayer.getRank());
            ps.execute();
            System.out.println("PLAYER Data has been inserted!");
        } catch (SQLException e) {
            System.out.println(e.toString());
            // always remember to close database connections
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }


    @Override
    public void displayPlayerInfo(String playerName) {
        System.out.println();
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("=====================");
        try {
            final String sql = "SELECT * FROM PLAYER WHERE NAME = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, playerName);
            rs = ps.executeQuery();

            while (rs.next()) {

                final int id = rs.getInt(1);
                final String name = rs.getString(2);
                final int age = rs.getInt(3);
                final int number = rs.getInt(4);
                final String position = rs.getString(5);
                final int teamId = rs.getInt(6);
                final String roleWithDescrition = rs.getString(7);
                final int totalGoals = rs.getInt(8);
                final boolean isCaptain = rs.getBoolean(9);
                final double rank = rs.getDouble(10);

                System.out.println("Player ID: " + id);
                System.out.println("Player Name: " + name);
                System.out.println("Player Age: " + age);
                System.out.println("Player T-Shirt Number: " + number);
                System.out.println("Payer Position: " + position);
                System.out.println("Player TeamID: " + teamId);
                System.out.println("Player Role With Descrition: " + roleWithDescrition);
                System.out.println("Player Total Goals: " + totalGoals);
                System.out.println("is Captain: " + isCaptain);
                System.out.println("Player Rank: " + rank);
            }
            System.out.println("=====================");
        } catch (SQLException e) {
            System.out.println(e.toString());

        } finally {
            // close connections
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                // TODO: handle exception
                System.out.println(e.toString());
            }
        }
    }


    @Override
    public void displayPlayerPosition(String playerName) {
        System.out.println();
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            final String sql = "SELECT POSITION FROM PLAYER WHERE NAME = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, playerName);
            rs = ps.executeQuery();

            // we are reading one row, so no need to loop
            String position = rs.getString(1);
            System.out.println("Player Name: " + playerName + " | Position: " + position);// it should give us ROLE

        } catch (SQLException e) {
            System.out.println(e.toString());

        } finally {
            // close connections
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                // TODO: handle exception
                System.out.println(e.toString());
            }
        }
    }


    @Override
    public void displayPlayerRoleWithDescription(String playerName) {
        // lets read specific row on the database
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            final String sql = "SELECT ROLE_WITH_DESCRIPTION FROM PLAYER WHERE NAME = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, playerName);
            rs = ps.executeQuery();

            // we are reading one row, so no need to loop
            String role = rs.getString(1);
            System.out.println("\nPlayer Role With Description: " + role);// it should give us ROLE

        } catch (SQLException e) {
            System.out.println(e.toString());

        } finally {
            // close connections
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                // TODO: handle exception
                System.out.println(e.toString());
            }
        }
    }


    // Update fun not working yet
    @Override
    public void updatePlayer(Player oldPlayer, int playerID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement("UPDATE PLAYER SET " +
                    "NAME = ?, AGE = ?, NUMBER = ?, POSITION = ?, TEAM_ID = ?, ROLE_WITH_DESCRIPTION = ?, TOTAL_GOALS = ?, IS_CAPTAIN = ?, RANK = ? WHERE ID = ?");
            connection.setAutoCommit(false);

            preparedStatement.setString(1, oldPlayer.getName());
            preparedStatement.setInt(2, oldPlayer.getAge());
            preparedStatement.setInt(3, oldPlayer.getNumber());
            preparedStatement.setInt(4, oldPlayer.getTeamId());
            preparedStatement.setString(5, oldPlayer.getRoleWithDescription());
            preparedStatement.setInt(6, oldPlayer.getTotalGoals());
            preparedStatement.setBoolean(7, oldPlayer.isCaptain());
            preparedStatement.setDouble(8, oldPlayer.getRank());
            preparedStatement.setInt(9, playerID);
            preparedStatement.executeUpdate();


//            System.out.println("UPDATE person SET " +
//                    "first_name = ?, last_name = ? WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    @Override
    public Player searchPlayer(int playerNumber, String playerName, int teamId) {
        return null;
    }


    //Not Needed For Now
    public void deletePlayer(String playerName) {
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM PLAYER WHERE NAME = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, playerName);
            ps.execute();
            System.out.println("Data has been deleted!");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.toString());
        } finally {
            //always remember to close, am forgetting because this is teaching purposes
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

} //Class END