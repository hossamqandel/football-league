package com.league.interfaces;

import com.league.entity.Match;
import com.league.entity.Team;

import java.util.List;

public interface MatchService {

    public Match addMatch(Match newMatch);
    //To Save a Match in DB

    public List<Match> displayAllMatches();
    //To Display All Matches Without filter

    public List<Match>  displayHeldMatches();
    //To Display Played Matches


    public List<Match> displayToBeHeldMatches();
    //To Display Unplayed Matches

    public void updateMatchById(Match oldMatch, int matchID);
    //Load Match By ID From DB
    //Update Match By oldMatch Then Save Changes

    public void play(Match match);
    //1- To Set And then Update STANDINGS TABLE With New Values for (Points,GF,GA)
}
