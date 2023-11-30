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

import javax.swing.tree.TreeNode;

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

    public Parrot(int id, String name, String songPhrase)
    {
        this.id = id;
        this.name = name;
        this.songPhrase = songPhrase;
    }

    public String getName()
    {
        return name;
    }

    public String getSongPhrase()
    {
        return songPhrase;
    }

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

class BinaryTree
{

    private TreeNode root;

    public BinaryTree()
    {
        root = null;
    }

    private class TreeNode
    {
        Parrot parrot;

        TreeNode left;
        TreeNode right;

        public TreeNode(Parrot parrot)
        {
            this.parrot = parrot;

            left = null;
            right = null;
        }
}
}