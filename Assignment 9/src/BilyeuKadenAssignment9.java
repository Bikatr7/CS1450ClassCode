/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Tuesday, November 14th 1:40pm
 * Assignment 9
 * This assignment provides a hands-on experience with implementing single-linked and double-linked lists, along with methods for adding, removing, sorting, and printing elements.
 * The objective of the assignment is to track and manage the linguistic adventures of parrots in Lima. Utilizing single and double linked lists, we will organize a collection of abecedarian words—words with letters in alphabetical order—as discovered by the parrots during their stay.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BilyeuKadenAssignment9
{

    public static void main(String[] args) throws IOException
    {
        // variables
        WordLinkedList wordList = new WordLinkedList();
        DoubleLinkedList doubleList = new DoubleLinkedList();

        File wordFile = new File("words.txt");

        Scanner wordScanner = new Scanner(wordFile);

        int numRemoved;

        // fill the linked list with words from the file
        while(wordScanner.hasNext())
        {
            wordList.addInFront(new Word(wordScanner.next()));
        }

        // part 1 (initial list)
        System.out.println("Words in the linked list\n\n");
        wordList.printList();

        // part 2 (non-abecedarian words)
        numRemoved = wordList.removeNonAbecedarianWords();

        System.out.println("\n\n\nRemoving non-abecedarian words...");
        System.out.println("Number of non-abecedarian removed = " + numRemoved + "\n\n");
        wordList.printList();

        // part 3 (sorted list)
        wordList.bubbleSort();

        System.out.println("\n\n\nBubble sorted linked list of abecedarian words\n\n");
        wordList.printList();

        // part 4 (double linked list built from single linked list)
        doubleList.build(wordList);

        System.out.println("\n\n\nDouble linked list of abecedarian words backwards\n\n");
        doubleList.printListBackwards();

        System.out.println("\n\nSize of the wordLinkedList = " + wordList.getSize());

    } // end of main

}

//-------------------start-of-Word--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Word
{
    private String letters;
    private Boolean abecedarian;

//-------------------start-of-Word()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Word(String letters)
    {
        this.letters = letters;
        this.abecedarian = abecedarianTest();
    }

//-------------------start-of-isAbecedarian()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Checks if the word is abecedarian or not.
     * @return abecedarian bool - if the word is abecedarian or not.
     */

    public boolean isAbecedarian()
    {
        return abecedarian;
    }

//-------------------start-of-abecedarianTest()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Tests if the word is abecedarian or not.
     * @return bool - if the word is abecedarian or not.
     */

    private boolean abecedarianTest()
    {
        for(int i = 0; i < letters.length() - 1; i++)
        {
            if(letters.charAt(i) > letters.charAt(i + 1))
            {
                return false;
            }
        }

        return true;
    }

//-------------------start-of-print()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the word and if it is abecedarian or not.
     * @return String - the word and if it is abecedarian or not.
     */

    public String print()
    {
        return String.format("%s\t\t%b", letters, abecedarian);
    }

//-------------------start-of-compareTo()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Compares two words to see which one comes first alphabetically.
     * @param otherWord Word - the other word to compare to.
     * @return int - -1 if this word comes first, 1 if the other word comes first, 0 if they are the same.
     */

    public int compareTo(Word otherWord)
    {

        if(this.letters.compareTo(otherWord.letters) < 0)
        {
            return -1;
        }
        else if(this.letters.compareTo(otherWord.letters) > 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }

} // end of Word

//-------------------start-of-WordLinkedList--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class WordLinkedList
{
    private Node head;
    private int size;

//-------------------start-of-WordLinkedList()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public WordLinkedList()
    {
        head = null;
        size = 0;
    }

//-------------------start-of-getSize()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Gets the size of the linked list.
     * @return int - the size of the linked list.
     */

    public int getSize()
    {
        return size;
    }

//-------------------start-of-addInFront()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Adds a word to the front of the linked list.
     * @param wordToAdd Word - the word to add to the front of the linked list.
     */

    public void addInFront(Word wordToAdd)
    {
        Node newNode = new Node(wordToAdd);

        newNode.next = head;
        head = newNode;
        size++;
    
    }

//-------------------start-of-removeNonAbecedarianWords()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Removes all non-abecedarian words from the linked list.
     * @return int - the number of words removed.
     */

    public int removeNonAbecedarianWords()
    {
        int numRemoved = 0;

        Node current = head;
        Node previous = null;

        while(current != null)
        {
            if(!current.word.isAbecedarian())
            {
                if(previous == null)
                {
                    head = current.next;
                }
                else
                {
                    previous.next = current.next;
                }

                numRemoved++;
                size--;
            }
            else
            {
                previous = current;
            }

            current = current.next;
        }

        return numRemoved;
    }

//-------------------start-of-removeFirstNode()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Removes the first node from the linked list.
     * @return Word - the word that was removed.
     */

    public Word removeFirstNode()
    {
        if(head == null)
        {
            return null;
        }
        else
        {
            Word wordToReturn = head.word;
            head = head.next;
            size--;

            return wordToReturn;
        }
    
    }

//-------------------start-of-bubbleSort()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Sorts the linked list using bubble sort.
     */

    public void bubbleSort()
    {
        boolean swapped = true;

        while(swapped)
        {
            swapped = false;

            Node current = head;

            while(current != null && current.next != null)
            {
                if(current.word.compareTo(current.next.word) > 0)
                {
                    swapNodeData(current, current.next);
                    swapped = true;
                }

                current = current.next;
            }
        }
    }

//-------------------start-of-printList()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the linked list.
     */

    public void printList()
    {
        Node current = head;

        System.out.println("Word\t\tAbecedarian Status");
        System.out.println("---------------------------------------");

        while(current != null)
        {
            System.out.println(current.word.print());
            current = current.next;
        }
    }

//-------------------start-of-swapNodeData()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Swaps the data of two nodes.
     * @param node1 Node - the first node to swap.
     * @param node2 Node - the second node to swap.
     */

    public void swapNodeData(Node node1, Node node2)
    {
        Word temp = node1.word;
        node1.word = node2.word;
        node2.word = temp;
    }

//-------------------start-of-Node--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static class Node
    {
        private Word word;
        private Node next;

//-------------------start-of-Node()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public Node(Word word)
        {
            this.word = word;
            next = null;
        }

    } // end of Node
 
} // end of WordLinkedList

//-------------------start-of-DoubleLinkedList--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class DoubleLinkedList
{
    private Node head;
    private Node tail;

//-------------------start-of-DoubleLinkedList()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
        public DoubleLinkedList()
        {
            head = null;
            tail = null;
        }

//-------------------start-of-build()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        /**
         * Removes a node from the incoming single linked list and adds it to the end of the double linked list.
         * @param wordList
         */

        public void build(WordLinkedList wordList)
        {

            while(wordList.getSize() > 0)
            {
                Word wordToAdd = wordList.removeFirstNode();
                Node newNode = new Node(wordToAdd);

                if(head == null)
                {
                    head = newNode;
                    tail = newNode;
                }
                else
                {
                    tail.next = newNode;
                    newNode.previous = tail;
                    tail = newNode;
                }
            }

        }

//-------------------start-of-printListBackwards()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        /**
         * Prints the double linked list backwards.
         */

        public void printListBackwards()
        {
            Node current = tail;

            System.out.println("Word\t\tAbecedarian Status");
            System.out.println("---------------------------------------");

            while(current != null)
            {
                System.out.println(current.word.print());
                current = current.previous;
            }
        }

//-------------------start-of-Node--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        private static class Node
        {
            private Word word;
            private Node next;
            private Node previous;

//-------------------start-of-Node()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

            public Node(Word word)
            {
                this.word = word;
                next = null;
                previous = null;
            }

         // end of Node
        }

} // end of DoubleLinkedList