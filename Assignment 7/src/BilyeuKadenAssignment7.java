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

        GameController gameController = new GameController();
        Game game = new Game();

        Team7 team = new Team7(teamName, rosterSize);

        while(inputFile.hasNext())
        {

            int ranking = inputFile.nextInt();
            int rosterSpot = inputFile.nextInt();

            // was told to use trim this time (plus using correct comment format)
            String name = inputFile.nextLine().trim();

            Player7 player = new Player7(teamName, ranking, name);

            // add player based on roster spot
            team.addPlayer(rosterSpot, player);
        }

        // close the file 
        inputFile.close();

        // display the team
        team.displayTeam();

        // Start of Assignment 7
        // move players into the game
        gameController.movePlayersIntoGame(team, game);

        // simulate the game
        gameController.simulateGame(game);

        // display the results
        gameController.displayResults(game);

        // prove that the game is over
        gameController.isGameOver(game);
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

    /**
     * Simulates a player trying to escape the room
     * @param playerName String - the player's name
     * @param playerRanking int - the player's ranking
     * @return int - the player's score
     */

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
    private Queue<Player7> waitingToPlayQ;
    private PriorityQueue<Player7> resultsQ;
    private EscapeRoom escapeRoom;

//-------------------start-of-Game()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Game()
    {

        waitingToPlayQ = new LinkedList<Player7>();
        resultsQ = new PriorityQueue<Player7>();
        escapeRoom = new EscapeRoom();

    }

//-------------------start-of-isWaitingToPlayQEmpty()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns true if the waiting to play queue is empty
     * @return boolean - true if the waiting to play queue is empty
     */

    public boolean isWaitingToPlayQEmpty()
    {
        return waitingToPlayQ.isEmpty();
    }

//-------------------start-of-addPlayerToWaitingToPlayQ()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Adds a player to the waiting to play queue
     * @param player Player7 - the player to add
     */

    public void addPlayerToWaitingToPlayQ(Player7 player)
    {
        waitingToPlayQ.add(player);
    }

//-------------------start-of-removePlayerFromWaitingToPlayQ()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Removes a player from the waiting to play queue
     * @return Player7 - the player removed
     */

    public Player7 removePlayerFromWaitingToPlayQ()
    {
        return waitingToPlayQ.remove();
    }

//-------------------start-of-isResultsQEmpty()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns true if the results queue is empty
     * @return boolean - true if the results queue is empty
     */

    public boolean isResultsQEmpty()
    {
        return resultsQ.isEmpty();
    }

//-------------------start-of-addPlayerToResultsQ()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Adds a player to the results queue
     * @param player Player7 - the player to add
     */

    public void addPlayerToResultsQ(Player7 player)
    {
        resultsQ.add(player);
    }

//-------------------start-of-removePlayerFromResultsQ()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Removes a player from the results queue
     * @return Player7 - the player removed
     */

    public Player7 removePlayerFromResultsQ()
    {
        return resultsQ.remove();
    }

//-------------------start-of-tryToEscape()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int tryToEscape(String playerName, int playerRanking)
    {
        return escapeRoom.tryToEscape(playerName, playerRanking);
    }

} // Game

//-------------------start-of-GameController---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class GameController
{

//-------------------start-of-movePlayersIntoGame()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Moves the players from the team roster into the game
     * @param team Team7 - the team to move the players from
     * @param game Game - the game to move the players into
     */

    public void movePlayersIntoGame(Team7 team, Game game)
    {

        System.out.println("\nGame Controller: Moving players on Team roster into game");
        System.out.println("----------------------------------------------------------------");

        for(int i = 0; i < team.getNumberSpots(); i++)
        {
            Player7 player = team.getPlayer(i);

            if(player != null)
            {
                game.addPlayerToWaitingToPlayQ(player);
                System.out.println("Moved into game: " + player.getName() + " from roster spot: " + i);
            }

        }

    }

//-------------------start-of-simulateGame()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Simulates the game
     * @param game Game - the game to simulate
     */

    public void simulateGame(Game game)
    {
        System.out.println("\nGame Controller: Starting Game - moving players waiting to play into escape room:");

        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-9s %-9s %-9s\n", "Player", "Score", "Current Leader");
        System.out.println("----------------------------------------------------------------");

        while(!game.isWaitingToPlayQEmpty())
        {

            Player7 player = game.removePlayerFromWaitingToPlayQ();

            int score = game.tryToEscape(player.getName(), player.getRanking());

            player.setScore(score);

            game.addPlayerToResultsQ(player);

            System.out.printf("%-9s %-9d %-9s\n", player.getName(), score, game.removePlayerFromResultsQ().getName());
        }

    }

//-------------------start-of-displayResults()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Displays the results of the game
     * @param game Game - the game to display the results of
     */

    public void displayResults(Game game)
    {

        System.out.println("Game Controller: Escape Room Results");

        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-9s %-9s \n", "Player", "Score");
        System.out.println("----------------------------------------------------------------");

        while(!game.isResultsQEmpty())
        {

            Player7 player = game.removePlayerFromResultsQ();

            System.out.printf("%-9s %-9d \n", player.getName(), player.getScore());
        }
    }

//-------------------start-of-isGameOver()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns true if the game is over
     * @param game Game - the game to check
     * @return boolean - true if the game is over
     */

    public boolean isGameOver(Game game)
    {
        if(game.isWaitingToPlayQEmpty() && game.isResultsQEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

//-------------------start-of-Team7---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Team7
{
    private String name;
    private int numberSpots;
    private Player7 [] roster;

//-------------------start-of-Team7()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Team7(String name, int numberSpots)
    {
        this.name = name;
        this.numberSpots = numberSpots;
        this.roster = new Player7[numberSpots];
    }

//-------------------start-of-getName()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the name of the team
     * @return String - the name of the team
     */

    public String getName()
    {
        return name;
    }

//-------------------start-of-getNumberSpots()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the number of spots on the team roster
     * @return int - the number of spots on the team roster
     */

    public int getNumberSpots()
    {
        return numberSpots;
    }

//-------------------start-of-addPlayer()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Adds a player to the team roster
     * @param spot int - the spot on the roster to add the player
     * @param player Player7 - the player to add
     */

    public void addPlayer(int spot, Player7 player)
    {
        roster[spot] = player;
    }

//-------------------start-of-getPlayer()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player at the given spot
     * @param spot int - the spot of the player
     * @return Player7 - the player at the given spot
     */

    public Player7 getPlayer(int spot)
    {
        return roster[spot];
    }

//-------------------start-of-displayTeam()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Displays the team roster
     */

    public void displayTeam()
    {

        System.out.println("----------------------------");
        System.out.println("TEAM ROSTER for " + name);
        System.out.println("----------------------------");

        System.out.printf("%-9s %-9s\n", "Spot", "Name");

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
} // Team7

//-------------------start-of-Player7---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Player7 implements Comparable <Player7>
{
    private String team;
    private String name;

    private int ranking;
    private int score;

//-------------------start-of-Player7()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Player7(String team, int ranking, String name)
    {
        this.team = team;
        this.ranking = ranking;
        this.name = name;
        this.score = 0;
    }

//-------------------start-of-getTeam()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the team name
     * @return String - the team name
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
     * @return String - the player's name
     */

    public String getName()
    {
        return name;
    }

//-------------------start-of-getScore()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's score
     * @return int - the player's score
     */

    public int getScore()
    {
        return score;
    }

//-------------------start-of-setScore()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Sets the player's score
     * @param score int - the player's score
     */

    public void setScore(int score)
    {
        this.score = score;
    }

//-------------------start-of-toString()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the player's information in a string
     * @return String - the player's information
     */

    @Override
    public String toString()
    {
        return String.format("%s\t%d\t\t%-10s",team, ranking, name);
    }

//-------------------start-of-compareTo()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Compares two players based on their score
     * @param otherPlayer Player7 - the other player to compare to
     * @return int - -1 if this player's score is less than the other player's score, 1 if this player's score is greater than the other player's score, 0 if they are equal
     */
    
    @Override
    public int compareTo(Player7 otherPlayer)
    {
        if (this.score < otherPlayer.score)
        {
            return -1;
        }
        else if (this.score > otherPlayer.score)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
} // Player7