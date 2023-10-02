/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, October 5th 1:40pm
 * Assignment 5
 * This assignment allows us to get familiar with the idea of generics and stacks, as well as how to use them.
 * The goal of the assignment is to implement and manipulate generic stacks in Java, focusing on adding zeros after even numbers, sorting, and rearranging elements based on a given value.
 */

 import java.util.*;

 public class BilyeuKadenAssignment5
 {

    public static void main(String[] args)
    {

        int[] values = {10, 1, 42, 15, 62, 8, 17, 2};

        Stack<Integer> stack = new Stack<Integer>();

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

    }

//-------------------start-of-addZeroAfterEvenValues()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Adds a zero after every even value in the stack
     * @param stack
     * @return void
     */

    public static void addZeroAfterEvenValues (Stack<Integer> stack)
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


    public static void printStack (Stack<Integer> stack)
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