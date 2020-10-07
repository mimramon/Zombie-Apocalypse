package Default;

// Importing
import java.util.*;

public class zombie 
{
	// VARIABLES - Methods
	public Random rand = new Random();

	// VARIABLES - Zombie Types
	static public final String[] zombieTypes = {"Charger", "Volatile Charger", "Toxic"};
	
	// VARIABLES - Zombie statistics 
    public int combatStrength;

    // VARIABLES - Misc
    public String role;
    
    public void setStats ()
    {
    	switch (role) 
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
    			System.out.println("There was an error setting the stats for this zombie");
    			break;
    	}
    }
}
