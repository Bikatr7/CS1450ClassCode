/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, September 28 1:40pm
 * Assignment 4
 * This assignment allows us to get familiar with Java's comparable interface by using it to interact with a team and its roster.
 * Read a team from a file, display them, and rank them.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;
 
public class BilyeuKadenAssignment4
{

    public static void main(String[] args) throws IOException
    {

        File file = new File("Team.txt");
        Scanner inputFile = new Scanner(file);

        String teamName = inputFile.nextLine();
        int rosterSize = inputFile.nextInt();

        Team team = new Team(teamName, rosterSize);

        while(inputFile.hasNext())
        {

            int ranking = inputFile.nextInt();
            int rosterSpot = inputFile.nextInt();

            // was told to use trim this time (plus using correct comment format)
            String name = inputFile.nextLine().trim();

            Player player = new Player(teamName, ranking, name);

            // add player based on roster spot
            team.addPlayer(rosterSpot, player);

        }

        // close the file 
        inputFile.close();

        // display the team
        team.displayTeam();

        // print the roster by ranking
        printRosterByRanking(team);

    }

//-------------------start-of-printRosterByRanking()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the roster by ranking
     * @param team
     * @return void
     */

    public static void printRosterByRanking(Team team)
    {
        // create arraylist to store players
        ArrayList<Player> players = new ArrayList<Player>();

        int rosterSize = team.getNumberSpots();

        // add players to arraylist
        for(int i = 0; i < rosterSize; i++)
        {
            Player player = team.getPlayer(i);

            if(player != null)
            {
                players.add(player);
            }
        }

        // sort using comparable
        Collections.sort(players);

        // print out the roster
        System.out.println("\n************************************************************************");
        System.out.println("\t\t\tPLAYERS ON TEAM");
        System.out.println("\t\t(From Highest Rank to Lowest Rank)");
        System.out.println("************************************************************************");
        System.out.println("Team\tRanking\t\tPlayer Name");
        System.out.println("------------------------------------------------------------------------");

        for (Player player : players)
        {
            System.out.printf("%s\t%d\t\t%-10s\n", player.getTeam(), player.getRanking(), player.getName());
        }

    }

}

//-------------------start-of-Team---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Team 
{

    private String name;
    private int numberSpots;
    private Player [] roster;

//-------------------start-of-Team()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Team (String name, int numberSpots)
    {
        this.name = name;
        this.numberSpots = numberSpots;
        this.roster = new Player[numberSpots];
    }

//-------------------start-of-getName()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the name of the team
     * @param none
     * @return String
     */

    public String getName()
    {
        return name;
    }

//-------------------start-of-getNumberSpots()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the number of spots on the team roster
     * @param none
     * @return int
     */

    public int getNumberSpots()
    {
        return numberSpots;
    }

//-------------------start-of-addPlayer()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Adds a player to the team roster
     * @param spot
     * @param player
     * @return void
     */

    public void addPlayer(int spot, Player player)
    {
        roster[spot] = player;
    }

//-------------------start-of-getPlayer()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player at the given spot
     * @param spot
     * @return Player
     */

    public Player getPlayer(int spot)
    {
        return roster[spot];
    }

//-------------------start-of-displayTeam()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Displays the team roster
     * @param none
     * @return void
     */

    public void displayTeam()
    {

        System.out.println("----------------------------");
        System.out.println("TEAM ROSTER for " + name);
        System.out.println("----------------------------");

        System.out.printf("%-9s %-9s\n", "Spot", "Player Name");

        System.out.println("----------------------------");

        for(int i = 0; i < numberSpots; i++)    
        {

            String name;

            // if the spot is not null, get the name
            if(roster[i] != null)
            {

                name = roster[i].getName();
            }
            else
            {
                name = "-------";
            }

            System.out.printf("%-9d %-9s\n", i, name);

        }

    }
}

//-------------------start-of-Player---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Player implements Comparable <Player>
{

    private String team;
    private int ranking;
    private String name;

//-------------------start-of-Player()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Player (String team, int ranking, String name)
    {
        this.team = team;
        this.ranking = ranking;
        this.name = name;
    }

//-------------------start-of-getTeam()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the team name
     * @param none
     * @return String
     */

    public String getTeam()
    {
        return team;
    }

//-------------------start-of-getRanking()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's ranking
     * @param none
     * @return int
     */

    public int getRanking()
    {
        return ranking;
    }

//-------------------start-of-getName()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's name
     * @param none
     * @return String
     */

    public String getName()
    {
        return name;
    }

//-------------------start-of-toString()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's information in a string
     * @param none
     * @return String
     */

    @Override
    public String toString()
    {
        return String.format("%s\t%d\t\t%-10s",team, ranking, name);
    }

//-------------------start-of-compareTo()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Compares the player's ranking to another player's ranking
     * @param otherPlayer
     * @return int
     */
    
    @Override
    public int compareTo(Player otherPlayer)
    {
        if (this.ranking < otherPlayer.ranking)
        {
            return -1;
        }
        else if (this.ranking > otherPlayer.ranking)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}