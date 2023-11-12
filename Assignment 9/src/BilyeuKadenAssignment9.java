/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Tuesday, November 14th 1:40pm
 * Assignment 9
 * *This assignment copypasta*
 * *The goal of this copypasta*
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BilyeuKadenAssignment9
{

    public static void main(String[] args) throws IOException
    {


    }

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
    private Word head;
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

}