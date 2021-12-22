package com.league;

// DB Package

import com.league.db.DBConnect;

// CLASSES Packages
import com.league.entity.Match;
import com.league.entity.Player;
import com.league.entity.Team;
import com.league.interfaces.MatchService;
import com.league.interfaces.PlayerService;
import com.league.interfaces.TeamService;
import com.league.service.MatchServiceImpl;
import com.league.service.PlayerServiceImpl;
import com.league.service.TeamServiceImpl;

// SQL Package
import java.sql.*;

// TOOLS Package
import java.text.ParseException;
import java.time.LocalDate;


public class Main {

    static final MatchService matchService = new MatchServiceImpl();
    static final PlayerService playerService = new PlayerServiceImpl();
    static final TeamService teamService = new TeamServiceImpl();

    public static void main(String[] args) throws ParseException {

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t=====================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   " + "Egyptian League");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t=====================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  " + "By George,Samy And Hossam");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t=====================");

        Player mohamedSalah = new Player("Mohamed Salah", 29, 11, 1, "FWD", "RW - Egyption King", 15, false, 9.4);
        Player sadioMane = new Player("Sadio Mane", 29, 10, 1, "FWD", "LW - Superstar", 7, false, 9.1);
        Player virgilVanDijk = new Player("Virgil van Dijk", 30, 4, 1, "Def", "CB - Gladiator", 1, true, 8.4);


        LocalDate date = LocalDate.of(2021, 10, 6);

        matchService.displayHeldMatches();


    }

}