package com.league.interfaces;

import com.league.entity.Match;

public interface MatchService {

    public Match addMatch(Match newMatch);
    //To Save a Match in DB

    public void displayMatches();

    public void displayHeldMatches();


    public void displayToBeHeldMatches();


    public void updateMatchById(Match oldMatch);
    //Load Match By ID From DB
    //Update Match By oldMatch Then Save Changes

    public void play(Match match);

}
