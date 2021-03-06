package com.league.print;


import com.league.entity.Match;

import java.util.List;

public class MatchPrinter {


    //By Using this function, We achieve the Principle of Single Responsibility
    // + we print the desired values from several different functions [All Matches, Held, To Be Held]
    public static void printMatches (Match match){
        System.out.println("Match Id: " + match.getMatchId());
        System.out.println("Match Date: " + match.getMatchDate());
        System.out.println("Match Referee: " + match.getReferee());
        System.out.println("Match Stadium: " + match.getStadiumName());
        System.out.println("Match First Team ID: " + match.getFirstTeamId());
        System.out.println("Match Second Team ID: " + match.getSecondTeamId());
        System.out.println("Match First Team Score: " + match.getFirstTeamScore());
        System.out.println("Match Second Team Score: " + match.getSecondTeamScore());
        System.out.println("=======================");
    }




}
