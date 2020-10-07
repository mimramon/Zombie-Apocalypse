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
    		System.out.println("hunter");
    		break;
    	case "blacksmith":
    		System.out.println("blacksmith");
    		break;
    	case "builder":
    		System.out.println("builder");
    		break;
    	case "medic":
    		System.out.println("medic");
    		break;
    	default:
    		System.out.println("error assigning job");
    		break;
    	}
    }
}
