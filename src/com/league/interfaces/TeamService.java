package com.league.interfaces;

import com.league.entity.Team;

public interface TeamService {


    public void addTeam(Team newTeam);
    //To Save a Team in DB


    public void updateTeam(Team oldTeam);
    //Load Team By ID From DB
    //Update Team By oldTeam Then Save Changes


    public Team getTeamById(int teamId);
    //Return Team By ID


    public Team getTeamByName(String teamName);
    //Return Team By Name


    public void displayTeamPlayers(int teamID);
    //Return Team Players

    public void deleteTeam(String teamName);

}