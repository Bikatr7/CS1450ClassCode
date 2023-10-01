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

        for(int value : values)
        {
            stack.push(value);
        }

    }

//-------------------start-of-addZeroAfterEvenValues()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void addZeroAfterEvenValues (Stack<Integer> stack)
    {
        Stack<Integer> tempStack = new Stack<Integer>();

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

    }

//-------------------start-of-sortStack()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void printStack (Stack<Integer> stack)
    {

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

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

//-------------------start-of-getSize()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int getSize()
    {
        return list.size();
    }

//-------------------start-of-peek()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public E peek()
    {
        return list.get(getSize() - 1);
    }

//-------------------start-of-pop()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public E pop()
    {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

//-------------------start-of-push()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public E push(E o)
    {
        list.add(o);
        return o;
    }

 } // GenericStack