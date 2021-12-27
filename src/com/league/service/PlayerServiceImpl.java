package com.league.service;

import com.league.db.DBConnect;
import com.league.entity.Player;
import com.league.interfaces.PlayerService;

import java.sql.*;

public class PlayerServiceImpl implements PlayerService {

    //A GLOBAL OBJECT OF PLAYER CLASS TO USE INSIDE MULTIPLE FUNCTIONS
    Player player = new Player();


    //FINISHED
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

    //FINISHED
    @Override
    public Player displayPlayerInfo(String playerName) {
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

                player.setPlayerID(id);
                player.setName(name);
                player.setAge(age);
                player.setNumber(number);
                player.setPosition(position);
                player.setTeamId(teamId);
                player.setRoleWithDescription(roleWithDescrition);
                player.setTotalGoals(totalGoals);
                player.setCaptain(isCaptain);
                player.setRank(rank);

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
        return player;
    }

    //FINISHED
    @Override
    public Player displayPlayerPosition(String playerName) {
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
            player.setName(playerName);
            player.setPosition(position);


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
        return player;
    }

    //FINISHED
    @Override
    public Player displayPlayerRoleWithDescription(String playerName) {
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
            player.setName(playerName);
            player.setRoleWithDescription(role);

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
        return player;
    }


    //FINISHED
    @Override
    public void updatePlayerByName(Player oldPlayer) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnect.connectDatabase();
            ps = con.prepareStatement("UPDATE PLAYER SET AGE = ?, NUMBER = ?, POSITION = ?, TEAM_ID = ?, ROLE_WITH_DESCRIPTION = ?,TOTAL_GOALS = ?, IS_CAPTAIN = ?, RANK = ? WHERE NAME = ?");

            ps.setInt(1, oldPlayer.getAge());
            ps.setInt(2, oldPlayer.getNumber());
            ps.setString(3, oldPlayer.getPosition());
            ps.setInt(4, oldPlayer.getTeamId());
            ps.setString(5, oldPlayer.getRoleWithDescription());
            ps.setInt(6, oldPlayer.getTotalGoals());
            ps.setBoolean(7, oldPlayer.isCaptain());
            ps.setDouble(8, oldPlayer.getRank());
            ps.setString(9, oldPlayer.getName());
            ps.executeUpdate();

            System.out.println("Player Data Updated");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //NOT FINISHED YET
    @Override
    public Player searchPlayer(int playerNumber, String playerName, int teamId) {
        return null;
    }



    //Not Needed
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