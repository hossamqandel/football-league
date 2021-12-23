package com.league.print;

import com.league.entity.Player;

public class PlayerPrinter {

    public static void printPlayerInfo(Player player){
                System.out.println("Player ID: " + player.getPlayerID());
                System.out.println("Player Name: " + player.getName());
                System.out.println("Player Age: " + player.getAge());
                System.out.println("Player T-Shirt Number: " + player.getNumber());
                System.out.println("Payer Position: " + player.getPosition());
                System.out.println("Player TeamID: " + player.getTeamId());
                System.out.println("Player Role With Descrition: " + player.getRoleWithDescription());
                System.out.println("Player Total Goals: " + player.getTotalGoals());
                System.out.println("is Captain: " + player.isCaptain());
                System.out.println("Player Rank: " + player.getRank());
    }


}
