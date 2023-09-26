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

    }

}


class Team 
{

    private String name;
    private int numberSpots;
    private Player [] roster;


    public Team (String name, int numberSpots)
    {
        this.name = name;
        this.numberSpots = numberSpots;
        this.roster = new Player[numberSpots];
    }

    public String getName()
    {
        return name;
    }

    public int getNumberSpots()
    {
        return numberSpots;
    }


    public void addPlayer(int spot, Player player)
    {
        roster[spot] = player;
    }

    public Player getPlayer(int spot)
    {
        return roster[spot];
    }

    public void displayTeam()
    {
        return;
    }
}

class Player implements Comparable <Player>
{

    private String team;
    private int ranking;
    private String name;

    public Player (String team, int ranking, String name)
    {
        this.team = team;
        this.ranking = ranking;
        this.name = name;
    }

    public String getTeam()
    {
        return team;
    }

    public int getRanking()
    {
        return ranking;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return String.format("%s\t%d\t\t%-10s",team, ranking, name);
    }

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