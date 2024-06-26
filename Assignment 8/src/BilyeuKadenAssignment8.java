/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, November 2nd 1:40pm
 * Assignment 8
 * This assignment provides a hands-on experience with implementing single-linked and double-linked lists, along with methods for adding, removing, sorting, and printing elements.
 * The objective of the assignment is to track and manage the linguistic adventures of parrots in Lima. Utilizing single and double linked lists, we will organize a collection of abecedarian words—words with letters in alphabetical order—as discovered by the parrots during their stay.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

 public class BilyeuKadenAssignment8
{
    public static void main(String[] args) throws IOException
    {

        File codeGridFile = new File("codeGrid.txt");
        File messageFile = new File("message.txt");

        Scanner codeGridScanner = new Scanner(codeGridFile);
        Scanner messageScanner = new Scanner(messageFile);

        ArrayList<Character> chars = new ArrayList<>();

        Queue<CodeElement> codeElementsQueue = new LinkedList<>();

        Iterator<Character> message;

        CodeMachine codeMachine;

        codeMachine = new CodeMachine(codeGridScanner.nextInt(), codeGridScanner.nextInt());

        // already read the first two ints, so we need to skip the rest of the line
        codeGridScanner.nextLine();

        while(codeGridScanner.hasNext())
        {
            chars.add(codeGridScanner.next().charAt(0));
        }

        // load the codeGrid using the chars ArrayList iterator
        codeMachine.loadCodeGrid(chars.iterator());

        codeMachine.printCodeGrid();

        while(messageScanner.hasNext())
        {
            // I love one-liners
            codeElementsQueue.add(new CodeElement(messageScanner.nextInt(), messageScanner.nextInt()));
        }

        message = codeMachine.decode(codeElementsQueue.iterator());

        System.out.println("\nParrot Secret Decoded Message");
        System.out.println("--------------------------------------------------------------------");

        while(message.hasNext())
        {
            System.out.print(message.next());
        }

        // close the scanners
        codeGridScanner.close();
        messageScanner.close();

    }

} // end of BilyeuKadenAssignment8

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

        System.out.println("Code Grid");
        System.out.println("-----------------------");

        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < numColumns; j++)
            {
                System.out.print(codeGrid[i][j] + " ");
            }
 
            System.out.println();
        }
    }
 
} // end of CodeMachine