/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, September 13 1:40pm
 * Assignment 3
 * This assignment gives us a chance to learn to write abstract classes and interfaces and practice using arrays and ArrayLists.
 * Read a list of "insects" from file correctly, display info about them, find fit insects, and more.
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

        // temporary variables to hold data from file
        String type;
        int decomposeAbility;
        int predatorAbility;
        int buildAbility;
        int pollinateAbility;
        String name;

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

        System.out.println("------------------------------------------------------------");
        System.out.println("All INSECTS IN ARRAY");
        System.out.println("------------------------------------------------------------");

        for(Insect insect: insects)
        {
            displayInsect(insect);
        }

        inputFile.close();

    }

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



}

interface Decomposer
{
    public int decompose();
}

interface Predator
{
    public int predator();
}

interface Builder
{
    public int build();
}

interface Pollinator
{
    public int pollinate();
}

abstract class Insect
{
    private String name;
    private String type;


    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public abstract String purpose();
    {

    }
}

class HoneyBee extends Insect implements Builder, Pollinator
{

    private int buildAbility;
    private int pollinateAbility;

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

    @Override
    public int build()
    {
        return buildAbility;
    }

    @Override
    public int pollinate()
    {
        return pollinateAbility;
    }

    @Override
    public String purpose()
    {
        return "I produce honey and pollinate 35% of the crops! Without me, 1/3 of the food you eat would not be available!";
    }


}

class Ladybug extends Insect implements Predator, Pollinator
{
    
    private int predatorAbility;
    private int pollinateAbility;

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

    @Override
    public int predator()
    {
        return predatorAbility;
    }

    @Override
    public int pollinate()
    {
        return pollinateAbility;
    }

    @Override
    public String purpose()
    {
        return "Named after the Virgin Mary, I'm considered good luck if I land on you! I'm a pest control expert eating up to 5,000 plant pests during my life span.";
    }
}

class Ant extends Insect implements Decomposer, Predator, Builder
{

    private int decomposeAbility;
    private int predatorAbility;
    private int buildAbility;

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

    @Override
    public int decompose()
    {
        return decomposeAbility;
    }

    @Override
    public int predator()
    {
        return predatorAbility;
    }

    @Override
    public int build()
    {
        return buildAbility;
    }

    @Override
    public String purpose()
    {
        return "Don't squash me, I'm an ecosystem engineer! Me and my 20 million friends accelerate decomposition of dead wood, aerate soil, improve drainage, and eat insects like ticks and termites!";
    }
}

class PrayingMantis extends Insect implements Predator
{

    private int predatorAbility;

    public PrayingMantis(String name, int predatorAbility)
    {
        // use implicit super constructor
        super();

        this.predatorAbility = predatorAbility;

        // because we are using the implicit super constructor, we need to set the name and type manually
        this.setName(name);
        this.setType("Praying Mantis");
    }

    @Override
    public int predator()
    {
        return predatorAbility;
    }

    @Override
    public String purpose()
    {
        return "I'm an extreme predator quick enough to catch a fly. Release me in a garden and I'll eat beetles, grasshoppers, crickets, and even pesky moths.";
    }
}