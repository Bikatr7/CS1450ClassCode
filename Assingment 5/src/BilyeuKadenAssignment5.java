/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, October 5th 1:40pm
 * Assignment 5
 * This assignment allows us to get familiar with the idea of generics and stacks, as well as how to use them.
 * The goal of the assignment is to implement and manipulate generic stacks in Java, focusing on adding zeros after even numbers, sorting, and rearranging elements based on a given value.
 */

 import java.util.*;
 import java.io.*;

 public class BilyeuKadenAssignment5 
 {

    public static void main(String[] args) throws FileNotFoundException
    {

        int[] values = {10, 1, 42, 15, 62, 8, 17, 2};

        Stack<Integer> stack = new Stack<Integer>();

        // requested constants for grader :)
        final int REARRANGE_NUMBER = 15;
        final String REARRANGE_STRING = "Durango";

        // initial push to stack
        for(int value : values)
        {
            stack.push(value);
        }

        // part 1
        addZeroAfterEvenValues(stack);

        System.out.println("Part 1: Stack With Zeros After Even Values");
        System.out.println("------------------------------------------");

        printStack(stack);

        // part 2
 
        GenericStack<Integer> integerStackOne = new GenericStack<Integer>();
        GenericStack<Integer> integerStackTwo = new GenericStack<Integer>();

        GenericStack<String> stringStackOne = new GenericStack<String>();
        GenericStack<String> stringStackTwo = new GenericStack<String>();

        fillStacksWithFiles(integerStackOne, integerStackTwo, stringStackOne, stringStackTwo);

        System.out.println("\n\nValues read from file and pushed onto number stack1");
        System.out.println("---------------------------------------------------");

        printStack(integerStackOne);

        System.out.println("\n\nValues read from file and pushed onto number stack2");
        System.out.println("---------------------------------------------------");

        printStack(integerStackTwo);

        // part 2.33

        rearrangeStacks(integerStackOne, integerStackTwo, REARRANGE_NUMBER);

        integerStackOne = sortStack(integerStackOne);
        integerStackTwo = sortStack(integerStackTwo);

        System.out.printf("\n\nNumber stack1 rearranged & sorted with values < than %d", REARRANGE_NUMBER);
        System.out.println("\n---------------------------------------------------");

        printStack(integerStackOne);

        System.out.printf("\n\nNumber stack2 rearranged & sorted with values >= than %d", REARRANGE_NUMBER);
        System.out.println("\n---------------------------------------------------");

        printStack(integerStackTwo);

        // part 2.66

        System.out.println("\n\nStrings read from file and pushed onto string stack1");
        System.out.println("---------------------------------------------------");

        printStack(stringStackOne);

        System.out.println("\n\nStrings read from file and pushed onto string stack2");
        System.out.println("---------------------------------------------------");

        printStack(stringStackTwo);

        // part 2.99

        rearrangeStacks(stringStackOne, stringStackTwo, REARRANGE_STRING);

        stringStackOne = sortStack(stringStackOne);
        stringStackTwo = sortStack(stringStackTwo);

        System.out.printf("\n\nString stack1 rearranged & sorted with values < than %s", REARRANGE_STRING);
        System.out.println("\n---------------------------------------------------");

        printStack(stringStackOne);

        System.out.printf("\n\nString stack2 rearranged & sorted with values >= than %s", REARRANGE_STRING);
        System.out.println("\n---------------------------------------------------");

        printStack(stringStackTwo);
        
    } // main

//-------------------start-of-sortStack()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Sorts the stack
     * @param unsortedStack
     * @return GenericStack<E>
     */

    public static <E extends Comparable<E>> GenericStack<E> sortStack(GenericStack<E> unsortedStack)
    {

        GenericStack<E> tempStack = new GenericStack<E>();

        while(!unsortedStack.isEmpty())
        {
            E value = unsortedStack.pop();

            // same as rearrangeStacks() , only difference is the operator/method
            while(!tempStack.isEmpty() && value.compareTo(tempStack.peek()) > 0)
            {
                unsortedStack.push(tempStack.pop());
            }

            tempStack.push(value);
        }

        // done sorting, return the sorted stack
        return tempStack;

    }

//-------------------start-of-rearrangeStacks()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Rearranges the stacks based on a given value
     * @param stack1
     * @param stack2
     * @param rearrangeValue
     * @return void
     */

    public static <E extends Comparable<E>> void rearrangeStacks(GenericStack<E> stack1, GenericStack<E> stack2, E rearrangeValue)
    {
     
        Stack<E> tempStack = new Stack<E>();

        // move all elements to stack1
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

        while(!stack1.isEmpty())
        {
            E value = stack1.pop();

            // just need to check for less than since >= is fine for the other stack
            if(value.compareTo(rearrangeValue) < 0)
            {
                tempStack.push(value);
            }
            else
            {
                stack2.push(value);
            }
        }

        // restore the original stack
        while(!tempStack.isEmpty())
        {
            stack1.push(tempStack.pop());
        }

    }

//-------------------start-of-addZeroAfterEvenValues()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Adds a zero after every even value in the stack
     * @param stack
     * @return void
     */

    public static void addZeroAfterEvenValues(Stack<Integer> stack)
    {
        Stack<Integer> tempStack = new Stack<Integer>();

        // push the values onto the temporary stack and add a zero after each even value
        while(!stack.isEmpty())
        {
            int value = stack.pop();

            if(value % 2 == 0)
            {
                tempStack.push(value);
                tempStack.push(0);
            }
            else
            {
                tempStack.push(value);
            }
        }

        // Restore the original stack
        while(!tempStack.isEmpty())
        {
            stack.push(tempStack.pop());
        }

    }

//-------------------start-of-printStack()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the stack
     * @param stack
     * @return void
     */


    public static void printStack(Stack<Integer> stack)
    {

        // create a temporary stack
        Stack<Integer> tempStack = new Stack<Integer>();

        // Pop the values off the original stack and push them onto the temporary stack while printing them
        while(!stack.isEmpty())
        {

            int value = stack.pop();

            System.out.print(value + "\n");

            tempStack.push(value);
        }

        // put em back
        while(!tempStack.isEmpty())
        {
            int value = tempStack.pop();

            stack.push(value);
        }

    }

//-------------------start-of-printStack()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the stack
     * @param stack
     * @return void
     */

    public static <E> void printStack (GenericStack<E> stack)
    {

        // create a temporary stack
        GenericStack<E> tempStack = new GenericStack<E>();

        // Pop the values off the original stack and push them onto the temporary stack while printing them
        while(!stack.isEmpty())
        {

            E value = stack.pop();

            System.out.print(value + "\n");

            tempStack.push(value);
        }

        // put em back
        while(!tempStack.isEmpty())
        {
            E value = tempStack.pop();

            stack.push(value);
        }

    }

//-------------------start-of-fillStacksWithFiles()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Fills the stacks with file
     * @param integerStackOne t
     * @param integerStackTwo
     * @param stringStackOne
     * @param stringStackTwo
     * @return void
     */

    // Specsheet specified to use a non-generic method to fill the stacks with files, I'm assuming this is okay since only the parameters are generic
    public static void fillStacksWithFiles(GenericStack<Integer> integerStackOne, GenericStack<Integer> integerStackTwo, GenericStack<String> stringStackOne, GenericStack<String> stringStackTwo) throws FileNotFoundException
    {

        File integerFileOne = new File("numbers1.txt");
        File integerFileTwo = new File("numbers2.txt");

        File stringFileOne = new File("cities1.txt");
        File stringFileTwo = new File("cities2.txt");

        Scanner integerInputFileOne = new Scanner(integerFileOne);
        Scanner integerInputFileTwo = new Scanner(integerFileTwo);
        
        Scanner stringInputFileOne = new Scanner(stringFileOne);
        Scanner stringInputFileTwo = new Scanner(stringFileTwo);

        // fill the stacks with the files
        while(integerInputFileOne.hasNext())
        {
            integerStackOne.push(integerInputFileOne.nextInt());
        }

        while(integerInputFileTwo.hasNext())
        {
            integerStackTwo.push(integerInputFileTwo.nextInt());
        }

        while(stringInputFileOne.hasNext())
        {
            stringStackOne.push(stringInputFileOne.nextLine());
        }

        while(stringInputFileTwo.hasNext())
        {
            stringStackTwo.push(stringInputFileTwo.nextLine());
        }

        // close the files
        integerInputFileOne.close();
        integerInputFileTwo.close();
        stringInputFileOne.close();
        stringInputFileTwo.close();
    }

 } // BilyeuKadenAssignment5

 //-------------------start-of-GenericStack---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 class GenericStack<E>
 {
    private ArrayList<E> list;

//-------------------start-of-GenericStack()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public GenericStack()
    {
        list = new ArrayList<E>();
    }

//-------------------start-of-isEmpty()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns true if the stack is empty
     * @return boolean
     */

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

//-------------------start-of-getSize()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the size of the stack
     * @return int
     */

    public int getSize()
    {
        return list.size();
    }

//-------------------start-of-peek()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the top element of the stack
     * @return E
     */

    public E peek()
    {
        return list.get(getSize() - 1);
    }

//-------------------start-of-pop()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Removes the top element of the stack
     * @return E
     */

    public E pop()
    {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

//-------------------start-of-push()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Adds an element to the top of the stack
     * @param o
     * @return E
     */

    public E push(E o)
    {
        list.add(o);
        return o;
    }

 } // GenericStack