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

    public boolean isAbecedarian()
    {
        return abecedarian;
    }

//-------------------start-of-abecedarianTest()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

    public String print()
    {
        return String.format("%s\t\t%b", letters, abecedarian);
    }

//-------------------start-of-compareTo()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Compares two words based on the alphabetical order of the letters in the word.
     * @param otherWord
     * @return integer value (-1, 0, 1) based on result of comparing two words.
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

}