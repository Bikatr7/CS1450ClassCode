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

        inputFile.close();

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
