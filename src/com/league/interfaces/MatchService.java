package com.league.interfaces;

import com.league.entity.Match;

public interface MatchService {

    public Match addMatch(Match newMatch);
    //To Save a Match in DB

    public void displayMatches();
    //To Display All Matches Without filter

    public void displayHeldMatches();
    //To Display Played Matches


    public void displayToBeHeldMatches();
    //To Display Unplayed Matches

    public void updateMatchById(Match oldMatch);
    //Load Match By ID From DB
    //Update Match By oldMatch Then Save Changes

    public void play(Match match);
    //1- To Set And then Update STANDINGS TABLE With New Values for (Points,GF,GA)
}
