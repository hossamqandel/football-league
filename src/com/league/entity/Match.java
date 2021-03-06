package com.league.entity;

import java.time.LocalDate;

public class Match {

    private int matchId;
    private LocalDate matchDate;
    private String referee;
    private String stadiumName;
    private int firstTeamId;
    private int secondTeamId;
    private int firstTeamScore;
    private int secondTeamScore;


    //Empty Constructor
    public Match() {
    }

    public Match(LocalDate matchDate, String referee, String stadiumName, int firstTeamId, int secondTeamId) {
        this.matchDate = matchDate;
        this.referee = referee;
        this.stadiumName = stadiumName;
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
    }

    //Constructor
    public Match(LocalDate matchDate, String referee, String stadiumName, int firstTeamId, int secondTeamId, int firstTeamScore, int secondTeamScore) {
        this.matchDate = matchDate;
        this.referee = referee;
        this.stadiumName = stadiumName;
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
    }

    public Match(int firstTeamId, int secondTeamId, int firstTeamScore, int secondTeamScore) {
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
    }

    //Constructor
    public Match(int matchId, LocalDate matchDate, String referee, String stadiumName, int firstTeamId, int secondTeamId, int firstTeamScore, int secondTeamScore) {
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.referee = referee;
        this.stadiumName = stadiumName;
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
    }


    //Getters,Setters
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getFirstTeamId() {
        return firstTeamId;
    }

    public void setFirstTeamId(int firstTeamId) {
        this.firstTeamId = firstTeamId;
    }

    public int getSecondTeamId() {
        return secondTeamId;
    }

    public void setSecondTeamId(int secondTeamId) {
        this.secondTeamId = secondTeamId;
    }

    public int getFirstTeamScore() {
        return firstTeamScore;
    }

    public void setFirstTeamScore(int firstTeamScore) {
        this.firstTeamScore = firstTeamScore;
    }

    public int getSecondTeamScore() {
        return secondTeamScore;
    }

    public void setSecondTeamScore(int secondTeamScore) {
        this.secondTeamScore = secondTeamScore;
    }
}
