/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, November 2nd 1:40pm
 * Assignment 8
 * This assignment allows us to get more familiar with 2D arrays, ArrayLists, queues, and iterators.
 * The goal of the assignment is to decode a secret message from parrots using these tools
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

 public class BilyeuKadenAssignment8
{
    public static void main(String[] args) throws IOException
    {

    }

}

//-------------------start-of-CodeElement--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class CodeElement
{
    private int row;
    private int column;

//-------------------start-of-CodeElement()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public CodeElement(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

//-------------------start-of-getRow()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Gets the row of the CodeElement
     * @return row int - the row of the CodeElement
     */

    public int getRow()
    {
        return row;
    }

//-------------------start-of-getColumn()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Gets the column of the CodeElement
     * @return column int - the column of the CodeElement
     */

    public int getColumn()
    {
        return column;
    }

} // end of CodeElement

//-------------------start-of-CodeMachine--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class CodeMachine
{
    private char[][] codeGrid;
    private int numRows;
    private int numColumns;

//-------------------start-of-CodeMachine()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public CodeMachine(int numRows, int numColumns)
    {
        this.numRows = numRows;
        this.numColumns = numColumns;

        codeGrid = new char[numRows][numColumns];
    }

//-------------------start-of-loadCodeGrid()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Loads the codeGrid with the characters from the iterator
     * @param characterIterator Iterator<Character> - the iterator that contains the characters to be loaded into the codeGrid
     */

    public void loadCodeGrid(Iterator<Character> characterIterator)
    {
        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < numColumns; j++)
            {
                codeGrid[i][j] = characterIterator.next();
            }
        }
    }

//-------------------start-of-decode()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Decodes the message from the iterator
     * @param messageIterator Iterator<CodeElement> - the iterator that contains the CodeElements to be decoded
     * @return decodedMessage Iterator<Character> - an iterator that contains the decoded message
     */

    public Iterator<Character> decode(Iterator<CodeElement> messageIterator)
    {
        ArrayList<Character> decodedMessage = new ArrayList<>();

        while(messageIterator.hasNext())
        {
            CodeElement codeElement = messageIterator.next();

            decodedMessage.add(codeGrid[codeElement.getRow()][codeElement.getColumn()]);
        }

        return decodedMessage.iterator();
    }

//-------------------start-of-printCodeGrid()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the codeGrid
     */

    public void printCodeGrid()
    {
        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < numColumns; j++)
            {
                System.out.println(codeGrid[i][j]);
            }

            System.out.println();
        }
    }
 
} // end of CodeMachine