/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, October 26th 1:40pm
 * Assignment 7
 * This assignment allows us to get more familiar with queues and priority queues.
 * The goal of the assignment is to manipulate a team and simulate a game using queues.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BilyeuKadenAssignment7 
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

    }

} // BilyeuKadenAssignment7

//-------------------start-of-EscapeRoom---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class EscapeRoom
{

//-------------------start-of-hash()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Hashes a string using the Jenkins hash function.
     * Jenkins hash function provided by the professor.
     * @param key String - the key to be hashed
     * @return int - the hash value of the key
     */

    private int hash(String key) 
    {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) 
        {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }

        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);

        return Math.abs(hash);
    } 

//-------------------start-of-tryToEscape()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public int tryToEscape(String playerName, int playerRanking)
    {
        String keyToHash = playerName + playerRanking;
        int hashValue = hash(keyToHash);
        int score = hashValue % 101;

        return score;

    }

} // EscapeRoom

//-------------------start-of-Game---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Game
{
    private Queue<Player> players;
}

//-------------------start-of-Team7---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Team7
{

    private String name;
    private int numberSpots;
    private Player [] roster;

//-------------------start-of-Team7()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Team7(String name, int numberSpots)
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

//-------------------start-of-Player7---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Player7 implements Comparable <Player7>
{

    private String team;
    private String name;

    private int ranking;
    private int score;

//-------------------start-of-Player()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Player7(String team, int ranking, String name)
    {
        this.team = team;
        this.ranking = ranking;
        this.name = name;
    }

//-------------------start-of-getTeam()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the team name
     * @return String
     */

    public String getTeam()
    {
        return team;
    }

//-------------------start-of-getRanking()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's ranking
     * @return int
     */

    public int getRanking()
    {
        return ranking;
    }

//-------------------start-of-getName()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's name
     * @return String
     */

    public String getName()
    {
        return name;
    }

//-------------------start-of-getScore()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's score
     * @return int
     */

    public int getScore()
    {
        return score;
    }

//-------------------start-of-setScore()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Sets the player's score
     * @param score int
     * @return void
     */

    public void setScore(int score)
    {
        this.score = score;
    }

//-------------------start-of-toString()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's information in a string
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
     * @param otherPlayer Player - the other player to compare to
     * @return int - -1 if this player's ranking is less than the other player's ranking, 1 if this player's ranking is greater than the other player's ranking, 0 if they are equal
     */
    
    @Override
    public int compareTo(Player7 otherPlayer)
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