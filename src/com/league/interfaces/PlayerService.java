package com.league.interfaces;

import com.league.entity.Player;

public interface PlayerService {


    public void addPlayer(Player newPlayer);
    //To Add a New Player in DB

    public Player displayPlayerInfo(String playerName);
    //To Display The Data of A Specific Player


    public Player displayPlayerPosition(String playerName);
    //Display Player Position

    public Player displayPlayerRoleWithDescription(String playerName);
    //Display Player RoleWithDescription


    public void updatePlayerByName(Player oldPlayer);
    //Load Player By Name From DB
    //Then Update Player By oldPlayer Then Save Changes


    public Player searchPlayer(int playerNumber, String playerName, int teamId);
    //Return Player Number,Name,TeamId

}
