/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, September 7 1:40pm
 * Assignment 2
 * This assignment gives us a chance to review objects, inheritance, and polymorphism. 
 * Read a list of "sharks" from file correctly, display info about them, and place select sharks in a aquarium object.
 */


 // Note to grader.
 // Sorry, been writing python too long so I messed up my func names.
 // And as for clearConsole, that's for my own benefit, but I'll exclude it from future assignments.

import java.io.File;
import java.io.IOException;
import java.util.*;
 
public class BilyeuKadenAssignment2
{

    public static void main(String[] args) throws IOException
    {
        File fileName = new File("sharks.txt");
        Scanner inputFile = new Scanner(fileName);

        // temp variables for object creation
        String type;
        String name;
        int age;

        int numOfSharks = inputFile.nextInt();

        Shark[] sharks = new Shark[numOfSharks];

        Aquarium aquarium = new Aquarium();

        // reads in sharks from file and creates objects
        for(int i = 0; i < numOfSharks; i++)
        {

            type = inputFile.next();
            age = inputFile.nextInt();
            name = inputFile.nextLine();

            // I dunno if it'll always be lowercase, but I'll make it so.
            switch(type.toLowerCase())
            {
                case "greatwhite":
                    sharks[i] = new GreatWhite(age, name);
                    break;
                case "hammerhead":
                    sharks[i] = new Hammerhead(age, name);
                    break;
                case "tiger":
                    sharks[i] = new Tiger(age, name);
                    break;
                case "zebra":
                    sharks[i] = new Zebra(age, name);
                    break;
            }

        }

        inputFile.close();

        displaySharkTable(sharks);

        aquarium.fillAquarium(sharks);
        aquarium.printAquariumDetails();

    }

//-------------------start-of-displaySharkTable()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Displays a table of shark information
     * @param sharks Shark[] | The array of sharks to be displayed.
     * @return None.
     */

    public static void displaySharkTable(Shark[] sharks)
    {
        // prints out a formatted table of sharks
        System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%-15s%-10s%-13s%-10s%n", "Type", "Age", "Name", "Physical Description");
        System.out.println("-------------------------------------------------------------------------------------");

        for (Shark shark : sharks)
        {
            System.out.printf("%-15s%-10s%-13s%-10s%n", shark.getType(), shark.getAge(), shark.getName(), shark.physicalDescription());
        }

    }

}

//-------------------start-of-Shark()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Shark
{

    private String type;
    private int age;
    private String name;

    public Shark(String type, int age, String name)
    {
        this.type = type;
        this.age = age;
        this.name = name;
    }

//-------------------start-of-getType()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the type of the shark
     * @param None.
     * @return String | The type of the shark.
     */

    public String getType()
    {
        return this.type;
    }

//-------------------start-of-getAge()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the age of the shark
     * @param None.
     * @return int | The age of the shark.
     */

    public int getAge()
    {
        return this.age;
    }

//-------------------start-of-getName()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the name of the shark
     * @param None.
     * @return String | The name of the shark.
     */

    public String getName()
    {
        return this.name;
    }

//-------------------start-of-physicalDescription()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the physical description of the shark
     * @param None.
     * @return String | The physical description of the shark.
     */

    public String physicalDescription()
    {
        return "";
    }

}

//-------------------start-of-GreatWhite()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class GreatWhite extends Shark
{

    public GreatWhite(int age, String name)
    {
        super("Great White", age, name);
    }

//-------------------start-of-physicalDescription()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the physical description of the shark
     * @param None.
     * @return String | The physical description of the shark.
     */

    @Override
    public String physicalDescription()
    {
        return "Torpedo-shaped body with a white-colored underside";
    }

}

//-------------------start-of-Hammerhead()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Hammerhead extends Shark
{

    public Hammerhead(int age, String name)
    {
        super("Hammerhead", age, name);
    }

//-------------------start-of-physicalDescription()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the physical description of the shark
     * @param None.
     * @return String | The physical description of the shark.
     */

    @Override
    public String physicalDescription()
    {
        return "Flattened head that laterally extends into a hammer shape";
    }

}

//-------------------start-of-Tiger()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Tiger extends Shark
{

    public Tiger(int age, String name)
    {
        super("Tiger", age, name);
    }

//-------------------start-of-physicalDescription()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the physical description of the shark
     * @param None.
     * @return String | The physical description of the shark.
     */

    @Override
    public String physicalDescription()
    {
        return "Tiger-like stripes that fade as shark matures";
    }

}

//-------------------start-of-Zebra()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Zebra extends Shark
{

    public Zebra(int age, String name)
    {
        super("Zebra", age, name);
    }

//-------------------start-of-physicalDescription()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the physical description of the shark
     * @param None.
     * @return String | The physical description of the shark.
     */

    @Override
    public String physicalDescription()
    {
        return "Yellowish stripes on dark body that change to dark spots";
    }

}

//-------------------start-of-Aquarium()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Aquarium
{

    private int numTigerSharks;
    private int numZebraSharks;
    
    private Shark[] aquariumSharks;

//-------------------start-of-fillAquarium()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Fills the aquarium with sharks, but only tiger and zebra sharks.
     * @param sharks Shark[] | The array of sharks to be placed in the aquarium.
     * @return None.
     */

    public void fillAquarium(Shark[] sharks)
    {

        // counts the number of each type of shark
        // would've done this in a single loop using an arraylist or some other data structure, but I'm not sure if we're allowed to use those yet.
        for (Shark shark : sharks)
        {
            if (shark instanceof Tiger)
            {
                this.numTigerSharks++;
            }
            else if (shark instanceof Zebra)
            {
                this.numZebraSharks++;
            }
        }

        // sets size to the number of each type of shark
        this.aquariumSharks = new Shark[this.numTigerSharks + this.numZebraSharks];

        int tigerIndex = 0;
        int zebraIndex = 0;

        // fills the aquarium with sharks
        for (Shark shark : sharks)
        {
            if (shark instanceof Tiger)
            {
                this.aquariumSharks[tigerIndex++] = shark;
            }
            else if (shark instanceof Zebra)
            {
                // this should be able to handle a different order of sharks, my previous method failed to do so.
                this.aquariumSharks[numTigerSharks + zebraIndex++] = shark;
            }
        }

    }

//-------------------start-of-printAquariumDetails()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Prints the details of the aquarium.
     * @param None.
     * @return None.
     */

    public void printAquariumDetails()
    {

        // prints out the details of the aquarium in a formatted table
        System.out.println("\nShark Aquarium");
        System.out.println("---------------------------------");

        System.out.println("Number of tiger sharks: " + this.numTigerSharks);
        System.out.println("Number of zebra sharks: " + this.numZebraSharks);

        System.out.println("");
        
        for (Shark shark : this.aquariumSharks)
        {

            System.out.printf("%-10s%-5s%-9s\n", shark.getType(), "---", shark.getName());

        }
    }

}
