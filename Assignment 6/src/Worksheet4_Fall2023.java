package src;
// CS 1450 Assignment #6 Fall 2023
// Worksheet4: Priority Queue
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Worksheet4_Fall2023 {

	public static void main(String[] args) {
		
		// Setup some hard coded players to use in the queue questions!
		// Create two hard coded players - hard coding is the way to go when learning!
		// Of course we would not do this in an assignment!  I'm doing it for testing purposes.
		PlayerW4 player1 = new PlayerW4("Garrett");  
		PlayerW4 player2 = new PlayerW4("Selene");    

		// Add some scores to each player
		// Note this time I'm adding the scores with a call to addScore method on the player.
		// Create 3 hard coded score objects and add them to player #1's queue
		player1.addScore(new ScoreW4(80, "02/04/2023"));
		player1.addScore(new ScoreW4(67, "02/27/2023"));
		player1.addScore(new ScoreW4(95, "03/27/2023"));
		player1.addScore(new ScoreW4(70, "04/04/2023"));
		
		// Create 2 hard coded score objects and add them to player #2's queue
		player2.addScore(new ScoreW4(42, "05/15/2023"));
		player2.addScore(new ScoreW4(63, "08/01/2023"));


		PriorityQueue<PlayerW4> results = new PriorityQueue<>();
		
		results.offer(player1);
		results.offer(player2);
		
		
		
		System.out.println("Player #1 is in priority queue");	
		System.out.println("Player #2 is in priority queue");

	} // main

} // Worksheet4


class ScoreW4  {
	
	private int value;
	private String dateOfScore;
	
	public ScoreW4 (int value, String dateOfScore) {
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


class PlayerW4 implements Comparable<PlayerW4> {
	
	private String name;		
	
	// Queue of scores this player obtained
	private Queue<ScoreW4> scores = new LinkedList<>();  

	
	public PlayerW4 (String name) {
		this.name = name;
	}

	
	public int getScoresSize() {
		return scores.size();
		
		
	}
	
	public void addScore(ScoreW4 score) {
		scores.add(score);
		
		
	}
	
	public ScoreW4 removeScore() {
		return scores.remove();
		
		
	}
	
	@Override
	public int compareTo(PlayerW4 otherThingy) 
	{
		if(this.getScoresSize() > otherThingy.getScoresSize())
		{
			return 1;
		}
		else if(this.getScoresSize() < otherThingy.getScoresSize())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}


} // Player

