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

}