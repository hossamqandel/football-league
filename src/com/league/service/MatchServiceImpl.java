package com.league.service;

import com.league.db.DBConnect;
import com.league.entity.Match;
import com.league.interfaces.MatchService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MatchServiceImpl implements MatchService {

    @Override
    public Match addMatch(Match newMatch) {

        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO MATCH(DATE, REFEREE, STADIUM_NAME, FIRST_TEAM_ID, Second_TEAM_ID, FIRST_TEAM_SCORE, SECOND_TEAM_SCORE) VALUES(?,?,?,?,?,?,?) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, newMatch.getMatchDate().toString());
            ps.setString(2, newMatch.getReferee());
            ps.setString(3, newMatch.getStadiumName());
            ps.setInt(4, newMatch.getFirstTeamId());
            ps.setInt(5, newMatch.getSecondTeamId());
            ps.setInt(6, newMatch.getFirstTeamScore());
            ps.setInt(7, newMatch.getSecondTeamScore());
            ps.execute();

            System.out.println("MATCH Data has been inserted!");
            return newMatch;
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
        return null;
    }



    @Override
    public List<Match> displayMatches() {
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Match> matchesList = new ArrayList();

        try {
            String sql = "SELECT * FROM MATCH";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("ALL Matches\n=================");

            while (rs.next()) {
                int matchID = rs.getInt(1);
                String date = rs.getString(2);
                String referee = rs.getString(3);
                String stadiumName = rs.getString(4);
                int firstTeamId = rs.getInt(5);
                int secondTeamId = rs.getInt(6);
                int firstTeamScore = rs.getInt(7);
                int secondTeamScore = rs.getInt(8);

                matchesList.add(new Match(matchID, LocalDate.parse(date), referee, stadiumName, firstTeamId, secondTeamId, firstTeamScore, secondTeamScore));

            }
        } catch (SQLException e) {
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
        return matchesList;
    }


    @Override
    public List<Match> displayHeldMatches() {
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Match> matchesList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM MATCH WHERE FIRST_TEAM_SCORE AND SECOND_TEAM_SCORE NOT NULL ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("ALL Held Matches\n=================");
            while (rs.next()) {
                int matchId = rs.getInt(1);
                String date = rs.getString(2);
                String referee = rs.getString(3);
                String stadiumName = rs.getString(4);
                int firstTeamId = rs.getInt(5);
                int secondTeamId = rs.getInt(6);
                int firstTeamScore = rs.getInt(7);
                int secondTeamScore = rs.getInt(8);

                matchesList.add(new Match(matchId, LocalDate.parse(date), referee, stadiumName, firstTeamId, secondTeamId, firstTeamScore, secondTeamScore));


            }
        } catch (SQLException e) {
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
        return matchesList;
    }


    @Override
    public List<Match> displayToBeHeldMatches() {
        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Match> matchesList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MATCH WHERE FIRST_TEAM_SCORE IS NULL AND SECOND_TEAM_SCORE IS NULL ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("ALL To Be Held Matches\n=================");
            while (rs.next()) {
                int matchId = rs.getInt(1);
                String date = rs.getString(2);
                String referee = rs.getString(3);
                String stadiumName = rs.getString(4);
                int firstTeamId = rs.getInt(5);
                int secondTeamId = rs.getInt(6);
                int firstTeamScore = rs.getInt(7);
                int secondTeamScore = rs.getInt(8);

                matchesList.add(new Match(matchId, LocalDate.parse(date), referee, stadiumName, firstTeamId, secondTeamId, firstTeamScore, secondTeamScore));
            }
        } catch (SQLException e) {
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
        return matchesList;
    }


    @Override
    public void updateMatchById(Match oldMatch) {
    }


    @Override
    public void play(Match match) {
        Random random = new Random();
        int firstTeamGoals = random.nextInt(8);
        int secondTeamGoals = random.nextInt(8);
        int firstTeamPoints = 0;
        int secondTeamPoints = 0;

        if (firstTeamGoals > secondTeamGoals) { //First Team Won
            firstTeamPoints = 3;

        } else if (firstTeamGoals == secondTeamGoals) { // The game is drawn
            firstTeamPoints = 1;
            secondTeamPoints = 1;

        } else { // Second Team Won
            secondTeamPoints = 3;
        }

        updateResultsTable(match.getFirstTeamId(), firstTeamPoints, firstTeamGoals, secondTeamGoals);
        updateResultsTable(match.getSecondTeamId(), secondTeamPoints, secondTeamGoals, firstTeamGoals);
    }


    private void updateResultsTable(int teamId, int matchPoints, int scoredGoals, int concededGoals) {
        // 1- Write select statement to get current result for a team
        int gfFromDB = 0;
        int gaFromDB = 0;
        int totalPointsFromDB = 0;

        Connection con = DBConnect.connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM STANDINGS WHERE TEAM_ID = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, teamId);
            rs = ps.executeQuery();

            while (rs.next()) {
                teamId = rs.getInt(1);
                gfFromDB = rs.getInt(2);
                gaFromDB = rs.getInt(3);
                totalPointsFromDB = rs.getInt(4);
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


        //2- Calculate new values by ( grab Old Values from DB then Sum Them With The new Values )
        int newPoints = matchPoints + totalPointsFromDB;
        int newGoals = scoredGoals + gfFromDB;
        int newConcededGoals = concededGoals + gaFromDB;


        //3- Write update statement to edit the team result
        // Concept: update table set team_Points = newPoints, team_Goals = newGoals, conceded_Goals = newConcededGoals where team_id = ?
        Connection myCon = DBConnect.connectDatabase();
        PreparedStatement myPS = null;
        try {
            String sql = "UPDATE STANDINGS SET POINTS = ? , GA = ? , GF = ? WHERE TEAM_ID = ? ";
            myPS = myCon.prepareStatement(sql);
            myPS.setInt(1, newPoints);
            myPS.setInt(2, newConcededGoals);
            myPS.setInt(3, newGoals);
            myPS.setInt(4, teamId);
            myPS.executeUpdate();
            System.out.println("Data has been updated");
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.toString());
        }
    }
}