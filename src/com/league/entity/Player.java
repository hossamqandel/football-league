package com.league.entity;

public class Player {

    private int playerID;
    private String name;
    private int age;
    private int number;
    private int teamId;
    private String position;
    private String roleWithDescription;
    private int totalGoals;
    private boolean isCaptain;
    private double rank;


    //Empty Constructor
    public Player() {

    }

    //Constructor
    //This One is to create a new player data.. so no need to enter The player id because player id Dynamiclly created by DB as PRIMARY KEY
    public Player(String name, int age, int number, int teamId, String position, String roleWithDescription, int totalGoals, boolean isCaptain, double rank) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.teamId = teamId;
        this.position = position;
        this.roleWithDescription = roleWithDescription;
        this.totalGoals = totalGoals;
        this.isCaptain = isCaptain;
        this.rank = rank;
    }

    //This One is to use when you need to get DATA from Some DB And DB Player TABLE Have An INTEGER ID Column (simple to DEA With Setting values Then Get It)
    public Player(int playerID, String name, int age, int number, int teamId, String position, String roleWithDescription, int totalGoals, boolean isCaptain, double rank) {
        this.playerID = playerID;
        this.name = name;
        this.age = age;
        this.number = number;
        this.teamId = teamId;
        this.position = position;
        this.roleWithDescription = roleWithDescription;
        this.totalGoals = totalGoals;
        this.isCaptain = isCaptain;
        this.rank = rank;
    }

    //Getters,Setters
    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRoleWithDescription() {
        return roleWithDescription;
    }

    public void setRoleWithDescription(String roleWithDescription) {
        this.roleWithDescription = roleWithDescription;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
