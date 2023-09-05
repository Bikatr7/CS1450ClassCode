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
 // And as for clearConsole, that's for my own benefit.

public class BilyeuKadenAssignment2
{

    public static void main(String[] args) throws Exception 
    {

    }

}


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

    public String getType()
    {
        return this.type;
    }

    public int getAge()
    {
        return this.age;
    }

    public String getName()
    {
        return this.name;
    }

    public String physicalDescription()
    {
        return "";
    }

}

class GreatWhite extends Shark
{

    public GreatWhite(int age, String name)
    {
        super("Great White", age, name);
    }

    @Override
    public String physicalDescription()
    {
        return "Great White Shark";
    }

}

class Hammerhead extends Shark
{

    public Hammerhead(int age, String name)
    {
        super("Hammerhead", age, name);
    }

    @Override
    public String physicalDescription()
    {
        return "Flattened head that laterally extends into a hammer shape";
    }

}

class Tiger extends Shark
{

    public Tiger(int age, String name)
    {
        super("Tiger", age, name);
    }

    @Override
    public String physicalDescription()
    {
        return "Tiger-like stripes that fade as shark matures";
    }

}

class Zebra extends Shark
{

    public Zebra(int age, String name)
    {
        super("Zebra", age, name);
    }

    @Override
    public String physicalDescription()
    {
        return "Yellowish stripes on dark body that change to dark spots";
    }

}

class Aquarium
{

    private int numTigerSharks;
    private int numZebraSharks;
    private Shark[] aquariumSharks;

    public void fillAquarium(Shark[] sharks)
    {
        for (Shark shark : sharks)
        {
            if (shark instanceof Tiger)
            {
                this.aquariumSharks[this.numTigerSharks] = shark;
                this.numTigerSharks++;
            }
            else if (shark instanceof Zebra)
            {
                this.aquariumSharks[this.numZebraSharks] = shark;
                this.numZebraSharks++;
            }
        }
    }

    public void printAquariumDetails()
    {
        System.out.println("Number of tiger sharks: " + this.numTigerSharks);
        System.out.println("Number of zebra sharks: " + this.numZebraSharks);
        
        for (Shark shark : this.aquariumSharks)
        {
            if (shark != null)
            {
                System.out.println(shark.getType() + " shark named " + shark.getName());
            }
        }
    }

}
