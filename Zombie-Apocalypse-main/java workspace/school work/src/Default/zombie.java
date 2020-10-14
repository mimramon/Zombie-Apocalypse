// Imports
import java.util.*;

public class zombie 
{
	// VARIABLES - Methods
	public Random rand = new Random();

	//VARIABLES - Zombie Classes
	static public final String[] zombieTypes = {"Charger", "Volatile Charger", "Toxic Charger"};
	

	// VARIABLES - Zombie stats (We can add more later if needed)
	public int combatStrength;
	
	// VARIABLES - Misc
    public String role;
    
    public void setStats ()
    {
		// Setting the stats for a survivor when they are added to the party
    	switch (role) 
    	{
            // Regular zombie (Low damage)
    		case "Charger":
    			combatStrength = 2;
                break;
            // Volatile zombie (High damage)
    		case "Volatile Charger":
    			combatStrength = 4;
                break;
            // Toxic zombie (High damage)
    		case "Toxic Charger":
    			combatStrength = 5;
                break;
            // Error
    		default:
    			System.out.println("There was an error setting the stats for that zombie");
    			break;
    	}
    }
}
