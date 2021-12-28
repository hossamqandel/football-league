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

        System.out.print("\n=================== " + teamName + " ===================");
        System.out.print("\nPlayer Name: " + player.getName());
        System.out.print(" | Age: " + player.getAge());
        System.out.print(" | Number: " + player.getNumber());
        System.out.print(" | Position: " + player.getPosition());
        System.out.print(" | Team_ID: " + player.getTeamId());
        System.out.print(" | Role With Description: " + player.getRoleWithDescription());
        System.out.print(" | Total Goals: " + player.getTotalGoals());
        System.out.print(" | Is Captain: " + player.isCaptain());
        System.out.print(" | Rank: " + player.getRank());
    }
}