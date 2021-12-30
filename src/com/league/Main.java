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
import com.league.print.MatchPrinter;
import com.league.print.PlayerPrinter;
import com.league.print.TeamPrinter;
import com.league.service.MatchServiceImpl;
import com.league.service.PlayerServiceImpl;
import com.league.service.TeamServiceImpl;


// SQL Package
import javax.lang.model.type.NullType;
import java.sql.*;
import java.sql.SQLException.*;


// TOOLS Package
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static void intro(){
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t=====================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   " + "Egyptian League");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t=====================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  " + "By George,Samy And Hossam");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t=====================");
    }


    static final MatchService matchService = new MatchServiceImpl();
    static final PlayerService playerService = new PlayerServiceImpl();
    static final TeamService teamService = new TeamServiceImpl();


    public static void main(String[] args) throws ParseException, SQLException {
        LocalDate date = LocalDate.of(2021, 8, 21);

        //Liverpool Players
        Player mohamedSalah = new Player("Mohamed Salah", 29, 11, 1, "FWD", "RW - Egyption King", 22, false, 9.4);
        Player sadioMane = new Player("Sadio Mane", 29, 10, 1, "FWD", "LW - Superstar", 16, false, 9.1);
        Player virgilVanDijk = new Player("Virgil van Dijk", 30, 4, 1, "DEF", "CB - Gladiator", 1, true, 8.4);

        //Real Madrid Players
        Player benzema = new Player("Karim Benzema", 33, 9, 2, "FWD", "ST - Goleden Foot", 8, false, 9.1);
        Player asensio = new Player("Marco Asensio", 26, 11, 2, "FWD", "RW - SuperStar", 12, false, 6.4);
        Player modric = new Player("Luka Modric", 34, 10, 2, "MID", "CM - Maestro", 3, true, 8.6);

        //FC Barcelona Players
        Player gavi = new Player("Gavi", 18, 30, 3, "MID", "CM - Artist", 1, false, 5.7);
        Player piqu = new Player("Gerrard Piqu", 34, 3, 3, "DEF", "CB - Engine", 0, true, 7.4);
        Player pedri = new Player("Pedri", 19, 17, 3, "MID", "CM - Architect", 1, false, 4.1);


        //Matches
        Match barcelona_RealMadrid = new Match(date, "Mike Dean", "Bernabue", 3, 2, 3, 1);
        Match liverpool_Barcelona = new Match(date, "Hernandez", "Camp Nou", 1, 3, -1, -1);
        Match realMadrid_Liverpool = new Match(date, "Micheal Oliver", "Anield", 2, 1, -1, -1);
        Match realMadrid_Barcelona = new Match(date, "Andres", "Camp Nou", 2, 3, -1, -1);
        //Not Added
        Match barcelona_liverpool = new Match(date, "Adam", "Anield", 3, 1, -1, -1);
        Match liverpool_RealMadrid = new Match(date, "Luis", "Bernabue", 3, 2, -1, -1);
//        matchService.updateMatchById(barcelona_RealMadrid, 1);
//        matchService.play(barcelona_RealMadrid);




        //Test Matches
//        List<Match> matchesList = matchService.displayAllMatches();
//        List<Match> heldmatchesList = matchService.displayHeldMatches();
        List<Match> toBeHeldMatchesList = matchService.displayToBeHeldMatches();

        for (Match match: toBeHeldMatchesList) {
            MatchPrinter.printMatches(match);
        }


        //Test Team Players
//        List<Player> teamPlayers = teamService.displayTeamPlayers(1); //YOU MUST ENTER ANY TEAM ID AS A PARAMETER


        //Test Player/s
//        Player playerInfo = playerService.getPlayerData("Mohamed Salah"); //YOU MUST ENTER ANY PLAYER NAME AS A PARAMETER
//        Player playerInfo2 = playerService.searchPlayer(11, "Mohamed Salah", 1); //YOU MUST ENTER ANY PLAYER NAME AS A PARAMETER

//        PlayerPrinter.printFullPlayerInfo(playerInfo);
//        PlayerPrinter.printPlayerPosition(playerInfo);
//        PlayerPrinter.printPlayerRoleWithDescription(playerInfo);



    } //END OF MAIN
} //END OF CLASS