package com.league.entity;

import java.util.List;

public class Team {

    private String name;
    private List<Player> players;
    private List<Match> matches;
    private int totalScore;


    //Empty Constructor
    public Team() {
    }


    //Constructor
    public Team(String name, List<Player> players, List<Match> matches, int totalScore) {
        this.name = name;
        this.players = players;
        this.matches = matches;
        this.totalScore = totalScore;
    }

    public Team(String name, int totalScore) {
        this.name = name;
        this.totalScore = totalScore;
    }

    //Getters,Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
