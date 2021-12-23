package com.league.interfaces;

import com.league.entity.Player;
import com.league.entity.Team;

import java.util.List;
import java.util.Objects;

public interface TeamService {


    public void addTeam(Team newTeam);
    //To Add a New Team in DB


    public void updateTeam(Team oldTeam);
    //Load Team By ID From DB
    //Then Update Team By oldTeam Then Save Changes


    public Team getTeamById(int teamId);
    //Return Team By ID


    public Team getTeamByName(String teamName);
    //Return Team By Name


    public List<Player> displayTeamPlayers(int teamID);
    //Return Team Players

    public void deleteTeam(String teamName);
    //NOT Important Funcation
}