/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, September 13 1:40pm
 * Assignment 3
 * This assignment gives us a chance to learn to write abstract classes and interfaces and practice using Arrays and ArrayLists.
 * Read a list of "insects" from file correctly, display info about them, find specific insects, and determine the most able insect.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;
 
public class BilyeuKadenAssignment3
{

    public static void main(String[] args) throws IOException
    {

        File file = new File("insects.txt");
        Scanner inputFile = new Scanner(file);

        // temporary variables to hold data from file, initializing them this time.
        String type = "";
        int decomposeAbility = 0;
        int predatorAbility = 0;
        int buildAbility = 0;
        int pollinateAbility = 0;
        String name = "";

        int numberOfInsects = inputFile.nextInt();

        Insect insects[] = new Insect[numberOfInsects];

        for(int i = 0; i < insects.length; i++)
        {

            type = inputFile.next();
            decomposeAbility = inputFile.nextInt();
            predatorAbility = inputFile.nextInt();
            buildAbility = inputFile.nextInt();
            pollinateAbility = inputFile.nextInt();
            name = inputFile.nextLine().strip(); // using strip because I noticed some names had a space at the beginning, not sure if that's due to my code but this fixes it

            // once again coercing to lowercase to make sure it matches the switch statement
            switch(type.toLowerCase())
            {
                case "honeybee":
                    insects[i] = new HoneyBee(name, buildAbility, pollinateAbility);
                    break;

                case "ladybug":
                    insects[i] = new Ladybug(name, predatorAbility, pollinateAbility);
                    break;

                case "ant":
                    insects[i] = new Ant(name, decomposeAbility, predatorAbility, buildAbility);
                    break;

                case "prayingmantis":
                    insects[i] = new PrayingMantis(name, predatorAbility);
                    break;
            }

        }

        // close the file after we're done with it
        inputFile.close();

        // task 1; display all insects
        System.out.println("------------------------------------------------------------");
        System.out.println("All INSECTS IN ARRAY");
        System.out.println("------------------------------------------------------------");

        for(Insect insect: insects)
        {
            displayInsect(insect);
        }

        // task 2; display all insects that are predators and pollinators (using ArrayList)
        System.out.println("------------------------------------------------------------");
        System.out.println("INSECTS THAT ARE PREDATORS AND POLLINATORS");
        System.out.println("------------------------------------------------------------");

        System.out.printf("%-18s %-18s %-18s %-18s\n", "Insect", "Type", "Predator Ability", "Pollinating Ability");
        System.out.println("------------------------------------------------------------");

        for (Insect insect : findPredatorsPollinators(insects))
        {
            System.out.printf("%-18s %-18s %-18d %-18d\n", insect.getName(), insect.getType(), ((Predator) insect).predator(), ((Pollinator) insect).pollinate());
        }

        // task 3; display the most able insect
        System.out.println("\nTHE MOST ABLE INSECT");
        System.out.println("------------------------------------------------------------");

        Insect mostAble = findMostAble(insects);

        displayInsect(mostAble);

    }

//-------------------start-of-displayInsect()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    /**
     * Displays the name, type, and purpose of an insect, as well as any special abilities it has.
     * @param insect
     * @return void
     */

    public static void displayInsect(Insect insect)
    {
        System.out.println(insect.getName() + " the " + insect.getType());
        System.out.println(insect.purpose() + "");

        if(insect instanceof Decomposer)
        {
            System.out.println("Decompose Ability : " + ((Decomposer) insect).decompose());
        
        }

        if(insect instanceof Predator)
        {
            System.out.println("Predator Ability : " + ((Predator) insect).predator());
        }

        if(insect instanceof Builder)
        {
            System.out.println("Build Ability : " + ((Builder) insect).build());
        }

        if(insect instanceof Pollinator)
        {
            System.out.println("Pollinate Ability : " + ((Pollinator) insect).pollinate());
            
        }

        // new line for formatting
        System.out.println();

    }

//-------------------start-of-findPredatorsPollinators()----------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Finds all insects that are both predators and pollinators but not decomposers or builders.
     * @param insects
     * @return ArrayList<Insect>
     */

    public static ArrayList<Insect> findPredatorsPollinators(Insect[] insects)
    {
        ArrayList<Insect> predatorsPollinators = new ArrayList<Insect>();

        for(Insect insect: insects)
        {
            // clarified with professor that we should not only check if it is an instance of both, but also that it is not an instance of the other two
            if(insect instanceof Predator && insect instanceof Pollinator)
            {
                if(insect instanceof Decomposer == false && insect instanceof Builder == false)
                {
                    predatorsPollinators.add(insect);
                }
            }
        }

        return predatorsPollinators;
    }

//-------------------start-of-findMostAble()------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Finds the most able insect in an array of insects.
     * @param insects
     * @return Insect
     */

    public static Insect findMostAble(Insect[] insects)
    {

        // note that specsheet has type InsectF23, but I'm assuming that's a typo (insect fall 23?) and it should be Insect

        Insect mostAble = null;
        
        int topFitness = 0;
        int currentFitness = 0;

        for(Insect insect: insects)
        {

            currentFitness = 0;

            if(insect instanceof Decomposer)
            {
                currentFitness += ((Decomposer) insect).decompose();
            }

            if(insect instanceof Predator)
            {
                currentFitness += ((Predator) insect).predator();
            }

            if(insect instanceof Builder)
            {
                currentFitness += ((Builder) insect).build();
            }

            if(insect instanceof Pollinator)
            {
                currentFitness += ((Pollinator) insect).pollinate();
            }

            if(currentFitness > topFitness)
            {
                topFitness = currentFitness;
                mostAble = insect;
            }

        }

        return mostAble;
    }

}

//-------------------start-of-Decomposer----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

interface Decomposer
{
    public int decompose();
}

//-------------------start-of-Predator------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

interface Predator
{
    public int predator();
}

//-------------------start-of-Builder-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

interface Builder
{
    public int build();
}

//-------------------start-of-Pollinator----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

interface Pollinator
{
    public int pollinate();
}

//-------------------start-of-Insect-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

abstract class Insect
{
    private String name;
    private String type;

//-------------------start-of-getName()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the name of the insect.
     * @return String
     */

    public String getName()
    {
        return name;
    }

//-------------------start-of-getType()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the type of the insect.
     * @return String
     */

    public String getType()
    {
        return type;
    }

//-------------------start-of-setName()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Sets the name of the insect.
     * @param name
     * @return void
     */

    public void setName(String name)
    {
        this.name = name;
    }

//-------------------start-of-setType()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Sets the type of the insect.
     * @param type
     * @return void
     */

    public void setType(String type)
    {
        this.type = type;
    }

//-------------------start-of-purpose()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the purpose of the insect.
     * @return String
     */

    public abstract String purpose();
    {

    }
}

//-------------------start-of-HoneyBee----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class HoneyBee extends Insect implements Builder, Pollinator
{

    private int buildAbility;
    private int pollinateAbility;

//-------------------start-of-HoneyBee()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public HoneyBee(String name, int buildAbility, int pollinateAbility)
    {
        // use implicit super constructor
        super();

        this.buildAbility = buildAbility;
        this.pollinateAbility = pollinateAbility;

        // because we are using the implicit super constructor, we need to set the name and type manually
        this.setName(name);
        this.setType("Honey Bee");
    }

//-------------------start-of-build()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the build ability of the HoneyBee.
     * @return int
     */

    @Override
    public int build()
    {
        return buildAbility;
    }

//-------------------start-of-pollinate()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the pollinate ability of the HoneyBee.
     * @return int
     */

    @Override
    public int pollinate()
    {
        return pollinateAbility;
    }

//-------------------start-of-purpose()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the purpose of the HoneyBee.
     * @return String
     */

    @Override
    public String purpose()
    {
        return "I produce honey and pollinate 35% of the crops! Without me, 1/3 of the food you eat would not be available!";
    }

}

//-------------------start-of-Ladybug----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Ladybug extends Insect implements Predator, Pollinator
{
    
    private int predatorAbility;
    private int pollinateAbility;

//-------------------start-of-Ladybug()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Ladybug(String name, int predatorAbility, int pollinateAbility)
    {
        // use implicit super constructor
        super();

        this.predatorAbility = predatorAbility;
        this.pollinateAbility = pollinateAbility;

        // because we are using the implicit super constructor, we need to set the name and type manually
        this.setName(name);
        this.setType("Ladybug");
    }

//-------------------start-of-predator()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the predator ability of the Ladybug.
     * @return int
     */

    @Override
    public int predator()
    {
        return predatorAbility;
    }

//-------------------start-of-pollinate()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the pollinate ability of the Ladybug.
     * @return int
     */

    @Override
    public int pollinate()
    {
        return pollinateAbility;
    }

//-------------------start-of-purpose()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the purpose of the Ladybug.
     * @return String
     */

    @Override
    public String purpose()
    {
        return "Named after the Virgin Mary, I'm considered good luck if I land on you! I'm a pest control expert eating up to 5,000 plant pests during my life span.";
    }
}

//-------------------start-of-Ant----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Ant extends Insect implements Decomposer, Predator, Builder
{

    private int decomposeAbility;
    private int predatorAbility;
    private int buildAbility;

//-------------------start-of-Ant()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Ant(String name, int decomposeAbility, int predatorAbility, int buildAbility)
    {
        // use implicit super constructor
        super();

        this.decomposeAbility = decomposeAbility;
        this.predatorAbility = predatorAbility;
        this.buildAbility = buildAbility;

        // because we are using the implicit super constructor, we need to set the name and type manually
        this.setName(name);
        this.setType("Ant");
    }

//-------------------start-of-decompose()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the decompose ability of the Ant.
     * @return int
     */

    @Override
    public int decompose()
    {
        return decomposeAbility;
    }

//-------------------start-of-predator()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the predator ability of the Ant.
     * @return int
     */

    @Override
    public int predator()
    {
        return predatorAbility;
    }

//-------------------start-of-build()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the build ability of the Ant.
     * @return int
     */

    @Override
    public int build()
    {
        return buildAbility;
    }

//-------------------start-of-purpose()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the purpose of the Ant.
     * @return String
     */

    @Override
    public String purpose()
    {
        return "Don't squash me, I'm an ecosystem engineer! Me and my 20 million friends accelerate decomposition of dead wood, aerate soil, improve drainage, and eat insects like ticks and termites!";
    }
}

//-------------------start-of-PrayingMantis----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class PrayingMantis extends Insect implements Predator
{

    private int predatorAbility;

//-------------------start-of-PrayingMantis()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public PrayingMantis(String name, int predatorAbility)
    {
        // use implicit super constructor
        super();

        this.predatorAbility = predatorAbility;

        // because we are using the implicit super constructor, we need to set the name and type manually
        this.setName(name);
        this.setType("Praying Mantis");
    }

//-------------------start-of-predator()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the predator ability of the PrayingMantis.
     * @return int
     */

    @Override
    public int predator()
    {
        return predatorAbility;
    }

//-------------------start-of-purpose()----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the purpose of the PrayingMantis.
     * @return String
     */

    @Override
    public String purpose()
    {
        return "I'm an extreme predator quick enough to catch a fly. Release me in a garden and I'll eat beetles, grasshoppers, crickets, and even pesky moths.";
    }
}