// CS1450 Assignment #6 Fall 2023
// Worksheet #2: Simple Nested Objects (Queues: not nested in a class and nested in a class)
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet2_Fall2023 {

	public static void main(String[] args) {
		
		// Create some books to be added to the queue
		BookW2 javaBook = new BookW2("Java");
		BookW2 cBook = new BookW2("C Programming");
		BookW2 pythonBook = new BookW2("Python");
		
		//*******************************************
		// Worksheet2 Question #1 
		// Queue in main - no nesting
		// Practice creating a queue and adding the above three books
		// Name your queue - queueNotNested
		//*******************************************
		// ADD CODE HERE

		
		
		
		
		
		// Test your non-nested queue by displaying the values in the queue
		System.out.println("Values in a queue that is not nested in a class");
		int queueLength = queueNotNested.size();
		for (int i = 0; i < queueLength; i++) {
			System.out.println("aQueue = " + queueNotNested.remove().getTitle());
		}

		
		//********************************
		// Worksheet2 Question #2
		// See BookQueue Class below
		//********************************

		
		
		//********************************
		// Worksheet2 Question #3a 
		// Use this code to test your BookQueue class
		// The queue is now nested in a class
		// Create an object of type BookQueue and add the three books
		//********************************
		// ADD CODE HERE

		
		
		
		
		
		//********************************
		// Worksheet2 Question #3b
		// Test your nested queue by displaying the titles of the books in the queue
		// DO NOT hard code the size of the queue
		//********************************
		// ADD CODE HERE	
		System.out.println();
		System.out.println("Values in a queue this is nested in a class");


		
		
		
	} // main

} // Worksheet2


//****************************************************
//Worksheet2 Question #2
//This class "contains" a queue of books. (HAS-A relationship)
//The class will provide methods to access the queue which it contains.
//Write the code for each method.
//****************************************************
class BookQueueW2 {
	
	private Queue<BookW2> queue = new LinkedList<>();

	public int size() {
		// ADD CODE HERE
		
		
	}
	
	public void offer(BookW2 book) {
		// ADD CODE HERE
		
		
	}
	
	public BookW2 remove() {
		// ADD CODE HERE
		
		
	}
	
} // BookQueue


class BookW2 {

	private String title;

	public BookW2 (String title) {
		this.title = title;
	}
		
	public String getTitle() {
		return title;
	}

} // Book


