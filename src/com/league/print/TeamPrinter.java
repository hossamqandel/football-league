package com.league.print;

import com.league.entity.Match;
import com.league.entity.Player;
import com.league.entity.Team;

import java.util.List;

import static com.league.service.TeamServiceImpl.teamName;

public class TeamPrinter {

    //By Using this function, We achieve the Principle of Single Responsibility
    // + We print the desired values according to needs
    public static void teamPlayersPrint(Player player){

        System.out.print("Team Name: " + teamName);
        System.out.print(" | Player Name: " + player.getName());
        System.out.print(" | Player Age: " + player.getAge());
        System.out.print(" | Player Number: " + player.getNumber());
        System.out.print(" | Player Position: " + player.getPosition());
        System.out.print(" | Team_ID: " + player.getTeamId());
        System.out.print(" | Player Role With Description: " + player.getRoleWithDescription());
        System.out.print(" | Player Total Goals: " + player.getTotalGoals());
        System.out.print(" | Is Captain: " + player.isCaptain());
        System.out.print(" | Player Rank: " + player.getRank());
    }
}
