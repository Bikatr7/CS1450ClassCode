/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Tuesday, November 14th 1:40pm
 * Assignment 9
 * This assignment allows some crucial hands on experience with binary trees, and the methods used to traverse them, such as level order traversal and visiting leaves, and inserting nodes.
 * The objective of the assignment is to create a binary tree of parrots, and then print the song lyrics of the parrots in level order, and then print the names of the parrots that are leaves.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BilyeuKadenAssignment10
{

    public static void main(String[] args) throws IOException
    {

        // fancy variables
        BinaryTree tree = new BinaryTree();

        File parrotFile = new File("parrots.txt");
        Scanner parrotScanner = new Scanner(parrotFile);

        // read file and load into tree
        while(parrotScanner.hasNext())
        {
            int id = parrotScanner.nextInt();
            String name = parrotScanner.next();

            // trim my beloved.
            String songPhrase = parrotScanner.nextLine().trim();

            Parrot newParrot = new Parrot(id, name, songPhrase);

            tree.insert(newParrot);

        }

        // Get the song lyrics

        System.out.println("\nParrot Christmas Song");
        System.out.println("----------------------");

        tree.levelOrder();

        // Show leaves
        System.out.println("\n\nParrots on Leave Nodes");
        System.out.println("----------------------");

        tree.visitLeaves();

        // close file
        parrotScanner.close();

        // Thanks for all the work grader. Have a great break!
        // Pretty sure this is the last assignment I'll have.
        // -Kaden
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
        if(this.id < otherParrot.id) 
        {
            return -1;
        } 
        else if(this.id > otherParrot.id) 
        {
            return 1;
        } 
        else
        {
            return 0;
        }
    }

} // end of Parrot

//-------------------start-of-BinaryTree--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class BinaryTree
{

    private TreeNode root;

//-------------------start-of-BinaryTree()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public BinaryTree()
    {
        root = null;
    }

//-------------------start-of-insert()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Inserts a parrot into the binary tree.
     * @param parrot Parrot - the parrot to insert into the binary tree.
     * @return boolean - true if the parrot was inserted, false if the parrot was not inserted.
     */

    public boolean insert(Parrot parrot)
    {
        TreeNode newNode = new TreeNode(parrot);

        // if the tree is empty, insert the parrot as the root
        if(root == null)
        {
            root = newNode;
            return true;
        }
        else
        {
            TreeNode current = root;
            TreeNode parent = null;

            while(true)
            {
                parent = current;

                // if the parrot is less than the current parrot, go left
                if(parrot.compareTo(current.parrot) < 0)
                {
                    current = current.left;

                    if (current == null)
                    {
                        parent.left = newNode;
                        return true;
                    }
                }
                // if the parrot is greater than the current parrot, go right
                else if(parrot.compareTo(current.parrot) > 0)
                {
                    current = current.right;

                    if(current == null)
                    {
                        parent.right = newNode;
                        return true;
                    }
                }
                // if the parrot is already in the tree, return false
                else
                {
                    return false;
                }
            }
        }
    }

//-------------------start-of-levelOrder()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the parrots in the binary tree in level order.
     */

    public void levelOrder()
    {
        // create a queue for the level order traversal to hold the nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode node = queue.remove();

            System.out.print(node.parrot.getSongPhrase() + " ");

            // add the left and right nodes to the queue
            if(node.left != null)
            {
                queue.add(node.left);
            }

            if(node.right != null)
            {
                queue.add(node.right);
            }
        }
    }

//-------------------start-of-visitLeaves()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the parrots in the binary tree that are leaves.
     */

    public void visitLeaves()
    {
        visitLeaves(root);
    }

//-------------------start-of-visitLeaves()--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the parrots in the binary tree that are leaves.
     * @param node TreeNode - the node to start at.
     */

    private void visitLeaves(TreeNode node)
    {
        if(node != null)
        {
            if(node.left == null && node.right == null)
            {
                System.out.println(node.parrot.getName());
            }
            // if the node is not a leaf, go left and right to find leaves
            else
            {
                visitLeaves(node.left);
                visitLeaves(node.right);
            }
        }
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
    
    } // end of TreeNode

} // end of BinaryTree