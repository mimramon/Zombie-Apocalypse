package Default;

import java.util.*;

public class survivor 
{
	public boolean isHunting;
	
	public Random rand = new Random();
	static public final String[] JOBS = {"hunter","blacksmith","builder","medic"};
	
    public int combatStrength;
    public int foodConsumption;
    public int scavenging; 
    public String role;
    
    public void setStats ()
    {
    	switch (role) 
    	{
    	case "hunter":
    		scavenging = 4;
    		combatStrength = 5;
    		foodConsumption = 3;
    		break;
    	case "blacksmith":
    		scavenging = 1;
    		combatStrength = 3;
    		foodConsumption = 4;
    		break;
    	case "builder":
    		scavenging = 1;
    		combatStrength = 2;
    		foodConsumption = 5;
    		break;
    	case "medic":
    		scavenging = 3;
    		combatStrength = 1;
    		foodConsumption = 1;
    		break;
    	default:
    		System.out.println("error setting stats");
    		break;
    	}
    }
}
