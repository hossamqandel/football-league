package com.league.service;

import com.league.db.DBConnect;
import com.league.entity.Player;
import com.league.entity.Team;
import com.league.interfaces.TeamService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamServiceImpl implements TeamService {


    //WE CREATE THIS AS A STATIC VARIABLE FOR 2 REASONS
    //HE WILL RETURN ONLY ONE VALUE + WE WILL CALL HIM IN ANOTHER CLASS
    public static String teamName;

    //FINISHED
    @Override
    public void addTeam(Team newTeam) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DBConnect.connectDatabase();
            final String sql = "INSERT INTO TEAM (NAME) VALUES (?)";
            ps = connection.prepareStatement(sql);

            ps.setString(1, newTeam.getName());

            ps.executeUpdate();
            System.out.println("Team Data INSERTED");

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

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //FINISHED
    @Override
    public List<Player> displayTeamPlayers(int teamID) {
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Player> players = new ArrayList<>();
        try {
            final String sql = "SELECT TEAM.NAME, PLAYER.NAME, PLAYER.AGE, PLAYER.NUMBER, PLAYER.POSITION, PLAYER.TEAM_ID, PLAYER.ROLE_WITH_DESCRIPTION, PLAYER.TOTAL_GOALS, PLAYER.IS_CAPTAIN, PLAYER.RANK FROM TEAM INNER JOIN PLAYER ON TEAM.ID = PLAYER.TEAM_ID WHERE TEAM.ID =  ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, teamID);
            rs = ps.executeQuery();

            while (rs.next()) {

                final String teamName = rs.getString(1);
                final String playerName = rs.getString(2);
                final int playerAge = rs.getInt(3);
                final int playerNumber = rs.getInt(4);
                final String playerPosition = rs.getString(5);
                final int playerTeamId = rs.getInt(6);
                final String playerRoleWithDescription = rs.getString(7);
                final int playerTotalGoals = rs.getInt(8);
                final boolean playerIsCaptain = rs.getBoolean(9);
                final double playerRank = rs.getDouble(10);

                this.teamName = teamName;

                //In this case we will display only one team NAME for Many players of The same TEAM
                //So instead of Create a List Of Many Objects.. i created a list of PLAYER TYPE
                //and then we can call this.teamName inside TeamPrinter Class Inside [teamPlayersPrint Funcation]
                players.add(new Player(playerName, playerAge, playerNumber, playerTeamId, playerPosition, playerRoleWithDescription, playerTotalGoals, playerIsCaptain, playerRank));
            }
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
        return players;
    }


    //FINISHED - Spaghetti Code - Two Try Catch
    @Override
    public void getTeamById(int teamId) {
        Connection con = DBConnect.connectDatabase();
        System.out.println();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            final String sql = "SELECT TEAM.NAME, PLAYER.NAME, PLAYER.NUMBER, PLAYER.POSITION \n" +
                    "FROM TEAM\n" +
                    "INNER JOIN PLAYER ON TEAM.ID = PLAYER.TEAM_ID\n" +
                    "WHERE TEAM.ID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, teamId);
            rs = ps.executeQuery();

            System.out.println("==================== TEAM PLAYERS ====================");
            while (rs.next()) {
                final String teamName = rs.getString(1);
                final String playersName = rs.getString(2);
                final int playerNumber = rs.getInt(3);
                final String playerPosition = rs.getString(4);

                System.out.println("Team: " + teamName);
                System.out.println("Player Name: " + playersName);
                System.out.println("Player Number: " + playerNumber);
                System.out.println("Player Position: " + playerPosition);
                System.out.println();
            }

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

        /**************************************************/
        con = DBConnect.connectDatabase();
        ps = null;
        rs = null;
        try {
            final String sql = "SELECT MATCH.DATE, MATCH.REFEREE, MATCH.STADIUM_NAME, MATCH.FIRST_TEAM_ID, MATCH.SECOND_TEAM_ID, MATCH.FIRST_TEAM_SCORE, MATCH.SECOND_TEAM_SCORE\n" +
                    "FROM MATCH\n" +
                    "INNER JOIN TEAM ON TEAM.ID = MATCH.FIRST_TEAM_ID OR TEAM.ID = MATCH.SECOND_TEAM_ID\n" +
                    "WHERE TEAM.ID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, teamId);
            rs = ps.executeQuery();

            System.out.println("==================== TEAM MATCHES ====================");
            while (rs.next()) {
                String date = rs.getString(1);
                String referee = rs.getString(2);
                String stadiumName  = rs.getString(3);
                int firstTeamID = rs.getInt(4);
                int secondTeamID = rs.getInt(5);

                Integer firstTeamScore = rs.getInt(6);
                if (rs.wasNull()){
                    firstTeamScore = null;
                }
                Integer secondTeamScore = rs.getInt(7);
                if (rs.wasNull()){
                    secondTeamScore = null;
                }

                System.out.println("Match Date: " + date);
                System.out.println("Match Referee: " + referee);
                System.out.println("Match Stadium: " + stadiumName);
                System.out.println("First Team ID: " + firstTeamID);
                System.out.println("Second Team ID: " + secondTeamID);
                System.out.println("First Team Score: " + firstTeamScore);
                System.out.println("Second Team Score: " + secondTeamScore);
                System.out.println();
            }

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
    public void displayTeamGoals(String teamName){
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            final String sql = "SELECT GF, GA FROM STANDINGS WHERE TEAM_NAME =  ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, teamName);
            rs = ps.executeQuery();

            while (rs.next()) {

                 int gf = rs.getInt(1);
                 int ga = rs.getInt(2);

                System.out.println();
                System.out.println("Team Name: " +teamName);
                System.out.println("TEAM GF: " + gf);
                System.out.println("TEAM GA: " + ga);
            }
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


    //NOT FINISHED
    @Override
    public Team getTeamByName(String teamName) {
        Team team = new Team();
        System.out.println();
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            final String sql = "SELECT * FROM TEAM WHERE NAME = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, teamName);
            rs = ps.executeQuery();

            while (rs.next()) {
                final int id = rs.getInt(1);
                final String name = rs.getString(2);
                final int playersId = rs.getInt(3);
                final int matchesId = rs.getInt(4);
                final int totalScore = rs.getInt(5);

                System.out.println("Team ID: " + id);
                System.out.println("Team Name: " + name);
                System.out.println("Team Players ID: " + playersId);
                System.out.println("Team Matches ID: " + matchesId);
                System.out.println("Team Total Score: " + totalScore);

            }

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
        return team;
    }


    //NOT FINISHED
    @Override
    public void updateTeam(Team oldTeam) {
    }

}