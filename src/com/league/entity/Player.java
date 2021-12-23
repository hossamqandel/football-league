package com.league.entity;

public class Player {

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

    //Getters,Setters
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
