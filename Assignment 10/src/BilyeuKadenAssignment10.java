/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Tuesday, November 14th 1:40pm
 * Assignment 9
 * This assignment allows some crucial hands on experience with binary trees
 * More shit here that i'll add later.
 */

 import java.io.File;
import java.io.IOException;
import java.util.*;

public class BilyeuKadenAssignment10
{

    public static void main(String[] args) throws IOException
    {

    }

}

//-------------------start-of-Parrot--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Parrot implements Comparable<Parrot>
{
    private int id;
    private String name;
    private String songPhrase;

//-------------------start-of-Parrot()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Parrot(int id, String name, String songPhrase)
    {
        this.id = id;
        this.name = name;
        this.songPhrase = songPhrase;
    }

//-------------------start-of-getName()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the name of the parrot.
     * @return name String - the name of the parrot.
     */

    public String getName()
    {
        return name;
    }

//-------------------start-of-getSongPhrase()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the song phrase of the parrot.
     * @return songPhrase String - the song phrase of the parrot.
     */

    public String getSongPhrase()
    {
        return songPhrase;
    }

//-------------------start-of-compareTo())--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Compares the id of the parrot to another parrot
     * @param otherParrot Parrot - the parrot to compare to
     * @return int - -1 if the id is less than the other parrot, 1 if the id is greater than the other parrot, 0 if the id is equal to the other parrot.
     */

    public int compareTo(Parrot otherParrot)
    {
        if (this.id < otherParrot.id) 
        {
            return -1;
        } 
        else if (this.id > otherParrot.id) 
        {
            return 1;
        } 
        else
        {
            return 0;
        }
    }

} 

//-------------------start-of-BinaryTree--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class BinaryTree
{

    private TreeNode root;

//-------------------start-of-BinaryTree()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public BinaryTree()
    {
        root = null;
    }

//-------------------start-of-TreeNode()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private class TreeNode
    {
        Parrot parrot;

        TreeNode left;
        TreeNode right;
    
//-------------------start-of-TreeNode()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public TreeNode(Parrot parrot)
        {
            this.parrot = parrot;

            left = null;
            right = null;
        }
    
    }

}