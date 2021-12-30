package com.league.interfaces;

import com.league.entity.Player;
import com.league.entity.Team;

import java.util.List;

public interface TeamService {


    public void addTeam(Team newTeam);
    //To Add a New Team in DB


    public void updateTeam(Team oldTeam);
    //Load Team By ID From DB
    //Then Update Team By oldTeam Then Save Changes


    public void getTeamById(int teamId);
    //Return Team By ID

    public void displayTeamGoals(String teamName);

    public Team getTeamByName(String teamName);
    //Return Team By Name


    public List<Player> displayTeamPlayers(int teamID);
    //Return Team Players

}