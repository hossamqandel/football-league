package com.league.interfaces;

import com.league.entity.Player;

public interface PlayerService {


    public void addPlayer(Player newPlayer);
    //To Save a Player in DB

    public void displayPlayerInfo(String playerName);
    //Load All Player Info


    public void displayPlayerPosition(String playerName);
    //Return Player Position

    public void displayPlayerRoleWithDescription(String playerName);
    //Return Player RoleWithDescription


    public void updatePlayer(Player oldPlayer, int playerID);
    //Load Player By Name From DB
    //Update Player By oldPlayer Then Save Changes


    public Player searchPlayer(int playerNumber, String playerName, int teamId);
    //Return Player Number,Name,TeamId


    public void deletePlayer(String playerName);
}
