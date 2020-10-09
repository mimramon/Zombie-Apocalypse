package Default;

// Imports
import java.util.*;

public class survivor 
{
	// VARIABLES - Unused
	public boolean isHunting;
	
	// VARIABLES - Methods
	public Scanner scan = new Scanner(System.in);
	public Random rand = new Random();
	public static settlement settlement = new settlement();
	

	//VARIABLES - Survivor Classes
	static public final String[] JOBS = {"Hunter","Blacksmith","Builder","Medic"};
	

	// VARIABLES - Survivor stats
	public int combatStrength;
	public int foodConsumption;
	public int scavenging; 
	
	// VARIABLES - Misc
	public String role;
    public static String userInput;
    
    public void setStats ()
    {
		// Setting the stats for a survivor when they are added to the party
    	switch (role) 
    	{
			// Hunter class
    		case "Hunter":
    			scavenging = 4;
    			combatStrength = 5;
    			foodConsumption = 3;
				break;
			// Blacksmith class
    		case "Blacksmith":
    			scavenging = 1;
    			combatStrength = 3;
    			foodConsumption = 4;
				break;
			// Builder class
    		case "Builder":
    			scavenging = 1;
    			combatStrength = 2;
    			foodConsumption = 5;
				break;
			// Medic class
    		case "Medic":
    			scavenging = 3;
    			combatStrength = 1;
    			foodConsumption = 1;
				break;
			// Error
    		default:
    			System.out.println("There was an error setting the stats for that survivor");
    			break;
    	}
	}
	
	public void builderIdle()
	{
		if(settlement.wood >=10)
		{
			System.out.println("4) Build a house");
    			if(settlement.wood >= 20)
    			{
					System.out.println("5) Build a workshop");
					//#region Builder Tasks (Up to task 5)
    				userInput = scan.next();
    				switch (userInput) 
    				{
    					case "1":
						
    						break;
    					case "2":
							settlement.wood = settlement.wood + rand.nextInt(main.partySize * 2);
    						break;
    					case "3":
						
    						break;
    					case "4":
						
    						break;
    					case "5":
							settlement.workshop = true;
							System.out.println("You have built the workshop!");
    						break;
    					default:
    						break;
					}
					//#endregion
				}
				//#region Builder Tasks (Up to option 4)
				userInput = scan.next();
    			switch (userInput) 
    			{
    				case "1":
    				
    					break;
    				case "2":
    					
    					break;
    				case "3":
    					
    					break;
    				case "4":
						settlement.houses++;
						System.out.println("You have built another house. You now have " + settlement.houses + " houses.");
    					break;
    				default:
    					break;
				}
				//#endregion
		}
		else 
		{
			userInput = scan.next();
		}
	}

	public void blacksmithIdle()
	{

	}

	public void medicIdle()
	{

		if(settlement.wood >= 20)
    	{
			System.out.println("4) Make meds");
			//#region Builder Tasks (Up to task 5)
    		userInput = scan.next();
    		switch (userInput) 
    		{
    			case "1":
    				break;
    			case "2":
					settlement.wood = settlement.wood + rand.nextInt(main.partySize * 2);
    				break;
    			case "3":
    				break;
				case "4":
					// Code to make meds here
					settlement.food = settlement.food - 10;
					settlement.meds++;
					System.out.println("You have made a Med, you now have " + settlement.meds + " meds.");
    				break;
    			default:
    				break;
			}
					//#endregion
		}
		else 
		{
			userInput = scan.next();
		}
		
	}

	public void hunterIdle()
	{
		userInput = scan.next();
		//#region Base Tasks (Up to option 3)
		switch (userInput) 
		{
			case "1":
				// Scavenge
				break;
			case "2":
				// Find timber
				break;
			case "3":
				// Mining
				break;
			default:
				break;
				}
		//#endregion
	}
}
