package Default;

import java.util.*;

public class zombie 
{
    public Random rand = new Random();

    static public final String[] zombieTypes = {"Charger", "Volatile Charger", "Toxic"};

    // VARIABLES - Statistics for each type of zombie (NOTE: Not all of these will end up being used, they are just ideas for now)
    public int combatStrength;
    public int speed;
    public int range;
    public String role;

    public void setStats ()
    {
        // Set the base stats for each zombie depending on their type
        switch(role)
        {
            case "Charger":
                combatStrength = 3;
                break;
            case "Volatile Charger":
                combatStrength = 4;
                break;
            case "Toxic":
                combatStrength = 5;
                break;
            default:
                System.out.println("There was an error setting stats for this zombie");

        }
    }
    // Will assign the statistics to each type of zombie in the same way they were assigned to the survivors
}
