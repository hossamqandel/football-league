package com.league.interfaces;

import com.league.entity.Player;

public interface PlayerService {


    public void addPlayer(Player newPlayer);
    //To Add a New Player in DB

    public void displayPlayerInfo(String playerName);
    //To Display The Data of A Specific Player


    public void displayPlayerPosition(String playerName);
    //Display Player Position

    public void displayPlayerRoleWithDescription(String playerName);
    //Display Player RoleWithDescription


    public void updatePlayer(Player oldPlayer, int playerID);
    //Load Player By Name From DB
    //Then Update Player By oldPlayer Then Save Changes


    public Player searchPlayer(int playerNumber, String playerName, int teamId);
    //Return Player Number,Name,TeamId


    public void deletePlayer(String playerName);
    //NOT Important Funcation
}
