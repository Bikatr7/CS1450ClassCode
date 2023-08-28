/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, August 31st 1:40pm
 * Assignment 1
 * To get back into the flow of writing code, by reviewing the basics of Java. Such as loops, arrays, and files
 */

import java.util.*;

public class BilyeuKadenAssignment1
{

    public static void main(String[] args) throws Exception 
    {

        // Clear console
        clearConsole();

        int[] array = {17, 10, 2, 16, 8, 15, 9, 17, 14, 18, 1, 19, 17, 2, 0};

        Arrays.sort(array);

        System.out.println("Values in array sorted");
        System.out.println("---------------------------------");

        printArray(array);

        System.out.println("\nAny pair whose sum is 10");
        System.out.println("---------------------------------");

        print_pairs_with_sum_of_10(array);
        
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