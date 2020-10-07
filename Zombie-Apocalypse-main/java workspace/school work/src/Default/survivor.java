package Default;

// Imports
import java.util.*;

public class survivor 
{
	// VARIABLES - Unused
	public boolean isHunting;
	
	// VARIABLES - Methods
	public Random rand = new Random();

	//VARIABLES - Survivor Classes
	static public final String[] JOBS = {"Hunter","Blacksmith","Builder","Medic"};
	

	// VARIABLES - Survivor stats
	public int combatStrength;
	public int foodConsumption;
	public int scavenging; 
	
	// VARIABLES - Misc
    public String role;
    
    public void setStats ()
    {
		// Setting the stats for a survivor when they are added to the party
    	switch (role) 
    	{
    		case "Hunter":
    			scavenging = 4;
    			combatStrength = 5;
    			foodConsumption = 3;
    			break;
    		case "Blacksmith":
    			scavenging = 1;
    			combatStrength = 3;
    			foodConsumption = 4;
    			break;
    		case "Builder":
    			scavenging = 1;
    			combatStrength = 2;
    			foodConsumption = 5;
    			break;
    		case "Medic":
    			scavenging = 3;
    			combatStrength = 1;
    			foodConsumption = 1;
    			break;
    		default:
    			System.out.println("There was an error setting the stats for that survivor");
    			break;
    	}
    }
}
