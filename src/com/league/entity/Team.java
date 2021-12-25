package com.league.entity;

public class Team {

    private int teamID;
    private String name;


    //Empty Constructor
    public Team() {
    }


    //Constructors
    public Team(String name) {
        this.name = name;
    }

    public Team(int teamID, String name) {
        this.teamID = teamID;
        this.name = name;
    }


    //Getters,Setters
    public int getTeamID() {
        return teamID;
    }
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
