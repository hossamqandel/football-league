package com.league.entity;

import java.util.List;

public class Team {

    private String name;


    //Empty Constructor
    public Team() {
    }


    //Constructor


    public Team(String name) {
        this.name = name;
    }

    //Getters,Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
