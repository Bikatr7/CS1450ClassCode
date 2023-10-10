// CS1450 Assignment #6 Fall 2023
// Worksheet #3: Complicated Nested Objects
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet3_Fall2023 {

	public static void main(String[] args) {
		

		//**********************************
		// Worksheet3 Team Setup 
		//**********************************
		// I'm going to build a Team and fill it with a bunch of players by HARD CODING!
		// I'm doing this to test the code.
		
		// Create a team object that contains a roster
		// The roster is an array and will have 5 slots (0-4)
		int maxNumberSpots = 5;
		TeamW3 team = new TeamW3(maxNumberSpots);

		System.out.println();
		System.out.println("Hard coding 3 players to test code");
		System.out.println("Garrett contains 4 scores");
		System.out.println("Selen contains 2 scores");
		System.out.println("Paul contains 3 score");
		System.out.println();
		
		// Hard code 3 players - hard coding is the way to go when learning!
		// Of course we would not do this in an assignment!  
		// I'm doing it for testing purposes.
		PlayerW3 garrett = new PlayerW3("Garrett");  
		PlayerW3 selene = new PlayerW3("Selene");    
		PlayerW3 paul = new PlayerW3("Paul");    
		
		// Add players to team - hard coding the roster spot for quick setup.
		// Of course we would not do this in a regular assignment - this is just for testing purposes
		team.addPlayer(0, garrett);
		team.addPlayer(3, selene);
		team.addPlayer(4, paul);
				
		// Add some scores to each player	
		// Create some scores and add them to Garrett in slot = 0
		ScoreW3 garrettScore1 = new ScoreW3(80, "02/04/2023");
		ScoreW3 garrettScore2 = new ScoreW3(67, "02/27/2023");
		ScoreW3 garrettScore3 = new ScoreW3(95, "03/27/2023");
		ScoreW3 garrettScore4 = new ScoreW3(70, "04/04/2023");
		team.addScoreToPlayer(garrettScore1, 0);
		team.addScoreToPlayer(garrettScore2, 0);
		team.addScoreToPlayer(garrettScore3, 0);
		team.addScoreToPlayer(garrettScore4, 0);

		// Create some scores and add them to Selene in slot = 3
		ScoreW3 seleneScore1 = new ScoreW3(42, "05/15/2023");
		ScoreW3 seleneScore2 = new ScoreW3(63, "08/01/2023");
		team.addScoreToPlayer(seleneScore1, 3);
		team.addScoreToPlayer(seleneScore2, 3);

		// Create some scores and add them to Paul in slot = 4
		ScoreW3 paulScore1 = new ScoreW3(90, "03/01/2023");
		ScoreW3 paulScore2 = new ScoreW3(85, "03/27/2023");
		ScoreW3 paulScore3 = new ScoreW3(68, "03/31/2023");
		team.addScoreToPlayer(paulScore1, 4);
		team.addScoreToPlayer(paulScore2, 4);
		team.addScoreToPlayer(paulScore3, 4);

		// Now the team is setup with players that contain a score queues!
		// Display some information to test the code 
		for (int spot = 0; spot < maxNumberSpots; spot++) {
			
			System.out.println("Roster spot # " + spot);
			
			// Get a player out of roster
			PlayerW3 aPlayer = team.getPlayer(spot);
			
			// If there was a player in (spot) display scores in the queue
			if (aPlayer != null) {
				System.out.print("Player " + aPlayer.getName());

				// Display number of scores
				int numScores = aPlayer.getScoresSize();
				System.out.println(" contains " + numScores + " scores");
				
				// To display scores, use method removeScore to return a Score object 
				// then call getValue on Score object
				for (int i = 0; i < numScores; i++) {
					System.out.println("Score: " + aPlayer.removeScore().getValue());
				}
			}
			else {
				System.out.println("Empty spot - null");
			}
			System.out.println();

		} // for slot
		
	} // main

} // Worksheet3


class ScoreW3  {
	
	private int value;
	private String dateOfScore;
	
	public ScoreW3 (int value, String dateOfScore) {
		this.value = value;
		this.dateOfScore = dateOfScore;
	}

	public int getValue() {
		return value;
	}
	
	public String getDateOfScore() {
		return dateOfScore;
	}
} // Score


//********************************
// Worksheet3 Question #1
// Write the code for each method
//********************************
class PlayerW3  {
	
	private String name;			
	private Queue<ScoreW3> scores = new LinkedList<>();  // Queue of scores this player obtained

	public PlayerW3 (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getScoresSize() {
		// ADD CODE HERE
		
		
	}
	
	public void addScore(ScoreW3 score) {
		// ADD CODE HERE
		
		
	}
	
	public ScoreW3 removeScore() {
		// ADD CODE HERE
		
		
	}

} // Player


//Represents a Team of players   
class TeamW3 {

	private PlayerW3[] roster;		// Array of players on the team	
	
	public TeamW3(int numberSpots) {
		roster = new PlayerW3[numberSpots];    // Allocate memory for the roster array 
	}

	
	// Add a player to the roster array in a specific location
	public void addPlayer(int spot, PlayerW3 player) {
		roster[spot] = player; 
	}


	// Returns the player in the specified location in the array.  
	// When a slot does NOT contain a player return null.
	public PlayerW3 getPlayer(int spot) {
		return roster[spot];
	}

	
	//********************************
	// Worksheet3 Question #3
	// Add a score to the player in location (spot) in the player array
	//********************************
	public void addScoreToPlayer(ScoreW3 score, int spot) {
		// ADD CODE HERE

	
	
	}	

} // Team

