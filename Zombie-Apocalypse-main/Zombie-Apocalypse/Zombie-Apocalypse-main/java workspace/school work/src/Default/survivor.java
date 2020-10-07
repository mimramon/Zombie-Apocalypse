package Default;

import java.util.*;

public class survivor 
{

	public boolean isHunting;
	
	public Random rand = new Random();

	// The classes that are assigned to each survivor in the party
	static public final String[] JOBS = {"Hunter", "Blacksmith", "Builder", "Medic"};
	
	// VARIABLES - Statistics for each survivor
    public int combatStrength;
    public int foodConsumption;
    public int scavenging; 
    public String role;
    
    public void setStats ()
    {
		// Set the base stats for each survivor when they are added to the party depending on their class type
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
    			System.out.println("There was an error setting stats for this survivor");
    			break;
    	}
    }
}
