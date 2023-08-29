/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, August 31st 1:40pm
 * Assignment 1
 * To get back into the flow of writing code, by reviewing the basics of Java. Such as loops, arrays, and files.
 * Perform a series of tasks on an array of integers, and later a matrix of integers.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class BilyeuKadenAssignment1
{

    public static void main(String[] args) throws Exception 
    {

        // Clear console
        clearConsole();

        int[] array = {17, 10, 2, 16, 8, 15, 9, 17, 14, 18, 1, 19, 17, 2, 0};
        int[][] matrix = new int[3][5];

        File fileName = new File("assignment1.txt");
        Scanner inputFile = new Scanner(fileName);
        PrintWriter outputFile = new PrintWriter(fileName);

        // sort array
        Arrays.sort(array);

        System.out.println("Values in array sorted");
        System.out.println("---------------------------------");

        printArray(array);

        System.out.println("\nAny pair whose sum is 10");
        System.out.println("---------------------------------");

        print_pairs_with_sum_of_10(array);

        System.out.println("\nMode value - number that occurs most often");
        System.out.println("---------------------------------");

        print_mode_of_array(array);

        write_one_dimensional_array_to_file(array, outputFile);

        read_matrix_from_file(matrix, inputFile);

        System.out.println("\n\nValues from file placed into 2D array - largest to smallest");
        System.out.println("---------------------------------");

        printMatrix(matrix);
        
    }

//-------------------start-of-read_matrix_from_file()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Reads the values of an integer matrix from a file
     * @param matrix int[][] | The matrix to be read into.
     * @param inputFile Scanner | The file to be read from.
     * @return None.
     */

    public static void read_matrix_from_file(int[][] matrix, Scanner inputFile)
    {
        for(int i = matrix.length- 1; i >= 0; i--)
        {
            for(int ii = matrix[i].length - 1; ii >= 0; ii--)
            {
                matrix[i][ii] = inputFile.nextInt();
            }
        }
    }

//-------------------start-of-write_one_dimensional_array_to_file()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Writes the values of an integer array to a file
     * @param array int[] | The array to be written.
     * @param outputFile PrintWriter | The file to be written to.
     * @return None.
     */

    public static void write_one_dimensional_array_to_file(int[] array, PrintWriter outputFile)
    {

        for(int i = 0; i < array.length; i++)
        {
            outputFile.println(array[i]);
        }

        outputFile.close();
    }

//-------------------start-of-print_mode_of_array()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the mode of an array
     * @param array int[] | The array to be searched.
     * @return None.
     */

    public static void print_mode_of_array(int[] array)
    {
        int currentMode = 0;
        int currentModeCount = 0;

        for(int i = 0; i < array.length; i++)
        {
            int currentCount = 0;

            for(int ii = 0; ii < array.length; ii++)
            {
                if(array[i] == array[ii])
                {
                    currentCount++;
                }
            }

            if(currentCount > currentModeCount)
            {
                currentMode = array[i];
                currentModeCount = currentCount;
            }
        }

        System.out.printf("%d occurred %d times", currentMode, currentModeCount);

    }

//-------------------start-of-print_pairs_with_sum_of_10()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the pairs of numbers in an array that add up to 10
     * @param array int[] | The array to be searched.
     * @return None.
     */

    public static void print_pairs_with_sum_of_10(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            for(int ii = i; ii < array.length; ii++)
            {
                if(array[i] + array[ii] == 10)
                {
                    System.out.printf("Pair at index %d and %d -> (%d + %d)\n", i, ii, array[i], array[ii]);
                }
            }
        }

    }

//-------------------start-of-printMatrix()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * prints the values of an integer matrix
     * @param matrix int[][] | The matrix to be printed.
     * @return None.
     */

    public static void printMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int ii = 0; ii < matrix[i].length; ii++)
            {
                System.out.print(matrix[i][ii] + " ");
            }

            System.out.println("");
        }
    }

//-------------------start-of-printArray()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
    * prints the values of an integer array
    * @param array int[] | The array to be printed.
    * @return None.
    */ 

    public static void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.printf("array[%d] = %d\n", i, array[i]);
        }
    }

//-------------------start-of-clearConsole()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Clears the console
     * @param None.
     * @return None.
     */

    public static void clearConsole()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

}