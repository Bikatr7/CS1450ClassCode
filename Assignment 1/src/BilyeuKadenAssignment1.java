/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, August 31st 1:40pm
 * Assignment 1
 * To get back into the flow of writing code, by reviewing the basics of Java. Such as loops, arrays, and files
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

        File fileName = new File("assignment1.txt");
        PrintWriter outputFile = new PrintWriter(fileName);

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
        
    }

    public static void 

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