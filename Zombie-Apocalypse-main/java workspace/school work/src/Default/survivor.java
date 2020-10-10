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
	public static main main = new main();
	

	//VARIABLES - Survivor Classes
	static public final String[] JOBS = {"Hunter","Blacksmith","Builder","Medic"};
	

	// VARIABLES - Survivor stats
	public int combatStrength;
	public int foodConsumption;
	public int scavenging; 
	
	// VARIABLES - Misc
	public String role;
	public static int userInput;
	public static int randomNum;
    
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
	
	// BUILDER IDLE TASKS
	public void builderIdle()
	{
		if(settlement.wood >=10)
		{
			System.out.println("4) Build a house");
    			if(settlement.wood >= 20 && !settlement.workshop)
    			{
					System.out.println("5) Build a workshop");
					//#region Builder Tasks (Up to task 5)
    				userInput = scan.nextInt();
    				switch (userInput) 
    				{
    					case 1:

    						break;
    					case 2:
							settlement.wood = settlement.wood + rand.nextInt(Default.main.partySize * 2);
							System.out.println("You now have " + settlement.wood + " wood");
    						break;
    					case 3:
							randomNum = rand.nextInt(Default.main.partySize * 2);
							System.out.println("You have mined " + randomNum + " metal!");
							settlement.metal = settlement.metal + randomNum;
							System.out.println("You now have " + settlement.metal + " metal");
    						break;
    					case 4:
							settlement.houses = settlement.houses + 1;
							settlement.wood = settlement.wood - 10;
							System.out.println("You have built another house. You now have " + settlement.houses + " houses.");
    						break;
    					case 5:
							settlement.workshop = true;
							settlement.wood = settlement.wood - 20;
							System.out.println("You have built the workshop!");
    						break;
    					default:
    						break;
					}
					//#endregion
				}
				else
				{
					//#region Builder Tasks (Up to option 4)
					userInput = scan.nextInt();
    				switch (userInput) 
    				{
    					case 1:
						
    						break;
    					case 2:
							settlement.wood = settlement.wood + rand.nextInt(Default.main.partySize * 2);
							System.out.println("You now have " + settlement.wood + " wood");
    						break;
    					case 3:
							randomNum = rand.nextInt(Default.main.partySize * 2);
							System.out.println("You have mined " + randomNum + " metal!");
							settlement.metal = settlement.metal + randomNum;
							System.out.println("You now have " + settlement.metal + " metal");
    						break;
    					case 4:
							settlement.houses = settlement.houses + 1;
							settlement.wood = settlement.wood - 10;
							System.out.println("You have built another house. You now have " + settlement.houses + " houses.");
    						break;
    					default:
    						break;
					}
					//#endregion
				}
				
		}
		else 
		{
			userInput = scan.nextInt();
		}
	}

	// BLACKSMITH IDLE TASKS
	public void blacksmithIdle()
	{
		if(settlement.metal >0 && settlement.workshop == true)
    	{
			System.out.println("4) Make ammo");
			//#region Builder Tasks (Up to task 5)
    		userInput = scan.nextInt();
    		switch (userInput) 
    		{
    			case 1:
    				break;
    			case 2:
					settlement.wood = settlement.wood + rand.nextInt(Default.main.partySize * 2);
					System.out.println("You now have " + settlement.wood + " wood");
    				break;
    			case 3:
					randomNum = rand.nextInt(Default.main.partySize * 2);
					System.out.println("You have mined " + randomNum + " metal!");
					settlement.metal = settlement.metal + randomNum;
					System.out.println("You now have " + settlement.metal + " metal");
					break;
				case 4:
					System.out.println("How much ammo would you like to make?\nWith your current resources, you can make " + settlement.metal + " ammo.");
					userInput = scan.nextInt();
					if(settlement.metal/userInput >= 1)
					{
						settlement.metal = settlement.metal - userInput;
						settlement.ammo = settlement.ammo + userInput;
						System.out.println("You have made " + userInput + " ammo, you now have " + settlement.ammo + " ammo.");
					}
					else
					{
						System.out.println("You do not have enough metal, please choose a different option");
						blacksmithIdle();
					}
    				break;
    			default:
    				break;
			}
			//#endregion
		}
		else 
		{
			userInput = scan.nextInt();
		}
	}

	// MEDIC IDLE TASKS
	public void medicIdle()
	{
		if(settlement.food >= 10 && settlement.workshop == true)
    	{
			System.out.println("4) Make meds");
			//#region Builder Tasks (Up to task 5)
    		userInput = scan.nextInt();
    		switch (userInput) 
    		{
    			case 1:
    				break;
    			case 2:
					settlement.wood = settlement.wood + rand.nextInt(Default.main.partySize * 2);
					System.out.println("You now have " + settlement.wood + " wood");
    				break;
				case 3:
					randomNum = rand.nextInt(Default.main.partySize * 2);
					System.out.println("You have mined " + randomNum + " metal!");
					settlement.metal = settlement.metal + randomNum;
					System.out.println("You now have " + settlement.metal + " metal");
    				break;
				case 4:
					// Code to make meds here
					System.out.println("How many meds would you like to make?\nWith your current resources, you can make " + settlement.food/10 + " meds.");
					userInput = scan.nextInt();
					if(settlement.food/(userInput*10) >= 1)
					{
						settlement.food = settlement.food - (userInput*10);
						settlement.meds = settlement.meds + userInput;
						System.out.println("You have made " + userInput + " meds, you now have " + settlement.meds + " meds.");
					}
					else
					{
						System.out.println("You do not have enough food, please choose a different option");
						medicIdle();
					}
					
    				break;
    			default:
    				break;
			}
					//#endregion
		}
		else 
		{
			userInput = scan.nextInt();
		}
		
	}

	// HUNTER IDLE TASKS
	public void hunterIdle()
	{
		userInput = scan.nextInt();
		//#region Base Tasks (Up to option 3)
		switch (userInput) 
		{
			case 1:
				// Scavenge
				break;
			case 2:
				settlement.wood = settlement.wood + rand.nextInt(Default.main.partySize * 2);
				System.out.println("You now have " + settlement.wood + " wood");
				break;
			case 3:
				randomNum = rand.nextInt(Default.main.partySize * 2);
				System.out.println("You have mined " + randomNum + " metal!");
				settlement.metal = settlement.metal + randomNum;
				System.out.println("You now have " + settlement.metal + " metal");
				break;
			default:
				break;
				}
		//#endregion
	}
}
