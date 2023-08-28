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
    public static void main(String[] args) 
    {

        // Clear console
        clearConsole();

        int[] array = {17, 10, 2, 16, 8, 15, 9, 17, 14, 18, 1, 19, 17, 2, 0};

        Arrays.sort(array);

        System.out.println("Values in array sorted");
        System.out.println("---------------------------------");

        printArray(array);
        
    }

    public static void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.printf("array[%d] = %d\n", i, array[i]);
        }
    }


    public static void clearConsole()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

}