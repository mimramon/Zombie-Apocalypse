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
	public void builderIdle(int partyPosition)
	{
		System.out.println("\nWhat would you like your builder to do.");
    	System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
		if(main.settlement.wood >=10)
		{
			System.out.println("4) Build a house");
    			if(main.settlement.wood >= 20 && !main.settlement.workshop)
    			{
					System.out.println("5) Build a workshop");
					//#region Builder Tasks (Up to task 5)
    				userInput = scan.nextInt();
    				switch (userInput) 
    				{
    					case 1:

    						break;
    					case 2:
							main.settlement.wood = main.settlement.wood + rand.nextInt(Default.main.partySize * 2);
							System.out.println("You now have " + main.settlement.wood + " wood");
    						break;
    					case 3:
							randomNum = rand.nextInt(Default.main.partySize * 2);
							System.out.println("You have mined " + randomNum + " metal!");
							main.settlement.metal = main.settlement.metal + randomNum;
							System.out.println("You now have " + main.settlement.metal + " metal");
    						break;
    					case 4:
							main.settlement.houses = main.settlement.houses + 1;
							main.settlement.wood = main.settlement.wood - 10;
							System.out.println("You have built another house. You now have " + main.settlement.houses + " houses.");
    						break;
    					case 5:
							main.settlement.workshop = true;
							main.settlement.wood = main.settlement.wood - 20;
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
							main.settlement.wood = main.settlement.wood + rand.nextInt(Default.main.partySize * 2);
							System.out.println("You now have " + main.settlement.wood + " wood");
    						break;
    					case 3:
							randomNum = rand.nextInt(Default.main.partySize * 2);
							System.out.println("You have mined " + randomNum + " metal!");
							main.settlement.metal = main.settlement.metal + randomNum;
							System.out.println("You now have " + main.settlement.metal + " metal");
    						break;
    					case 4:
							main.settlement.houses = main.settlement.houses + 1;
							main.settlement.wood = main.settlement.wood - 10;
							System.out.println("You have built another house. You now have " + main.settlement.houses + " houses.");
    						break;
    					default:
    						break;
					}
					//#endregion
				}
				
		}
		else 
		{
			defaultTasks(partyPosition);
		}
	}

	// BLACKSMITH IDLE TASKS
	public void blacksmithIdle(int partyPosition)
	{
		System.out.println("\nWhat would you like your blacksmith to do.");
    	System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
		if(main.settlement.metal >0 && main.settlement.workshop)
    	{
			System.out.println("4) Make ammo");
    		userInput = scan.nextInt();
    		switch (userInput) 
    		{
    			case 1:
    				break;
    			case 2:
					main.settlement.wood = main.settlement.wood + rand.nextInt(Default.main.partySize * 2);
					System.out.println("You now have " + main.settlement.wood + " wood");
    				break;
    			case 3:
					randomNum = rand.nextInt(Default.main.partySize * 2);
					System.out.println("You have mined " + randomNum + " metal!");
					main.settlement.metal = main.settlement.metal + randomNum;
					System.out.println("You now have " + main.settlement.metal + " metal");
					break;
				case 4:
					System.out.println("How much ammo would you like to make?\nWith your current resources, you can make " + main.settlement.metal + " ammo.");
					userInput = scan.nextInt();
					if(main.settlement.metal/userInput >= 1)
					{
						main.settlement.metal = main.settlement.metal - userInput;
						main.settlement.ammo = main.settlement.ammo + userInput;
						System.out.println("You have made " + userInput + " ammo, you now have " + main.settlement.ammo + " ammo.");
					}
					else
					{
						System.out.println("You do not have enough metal, please choose a different option");
						blacksmithIdle(partyPosition);
					}
    				break;
    			default:
    				break;
			}
		}
		else 
		{
			defaultTasks(partyPosition);
		}
	}

	// MEDIC IDLE TASKS
	public void medicIdle(int partyPosition)
	{
		System.out.println("\nWhat would you like your medic to do.");
    	System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
		if((main.settlement.food >= 10) && main.settlement.workshop)
    	{
			System.out.println("4) Make meds");
			//#region Builder Tasks (Up to task 5)
    		userInput = scan.nextInt();
    		switch (userInput) 
    		{
    			case 1:
    				break;
    			case 2:
					main.settlement.wood = main.settlement.wood + rand.nextInt(Default.main.partySize * 2);
					System.out.println("You now have " + main.settlement.wood + " wood");
    				break;
				case 3:
					randomNum = rand.nextInt(Default.main.partySize * 2);
					System.out.println("You have mined " + randomNum + " metal!");
					main.settlement.metal = main.settlement.metal + randomNum;
					System.out.println("You now have " + main.settlement.metal + " metal");
    				break;
				case 4:
					// Code to make meds here
					System.out.println("How many meds would you like to make?\nWith your current resources, you can make " + main.settlement.food/10 + " meds.");
					userInput = scan.nextInt();
					if(main.settlement.food/(userInput*10) >= 1)
					{
						main.settlement.food = main.settlement.food - (userInput*10);
						main.settlement.meds = main.settlement.meds + userInput;
						System.out.println("You have made " + userInput + " meds, you now have " + main.settlement.meds + " meds.");
					}
					else
					{
						System.out.println("You do not have enough food, please choose a different option");
						medicIdle(partyPosition);
					}
					
    				break;
    			default:
    				break;
			}
					//#endregion
		}
		else 
		{
			defaultTasks(partyPosition);
		}
		
	}

	// HUNTER IDLE TASKS
	public void hunterIdle(int partyPosition)
	{
		System.out.println("\nWhat would you like your hunter to do.");
    	System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
		defaultTasks(partyPosition);
	}

	public void defaultTasks(int partyPosition) 
	{
		userInput = scan.nextInt();
		switch (userInput) 
		{
			// Scavenging
			case 1:
				if(main.PARTY[partyPosition].role.equals("Hunter"))
				{
					int max = main.PARTY[partyPosition].scavenging * 3;
					int min = Default.main.partySize;
					randomNum = rand.nextInt(max + 1 - min) + min;
				}
				else
				{
					int max = main.PARTY[partyPosition].scavenging * 3;
					int min = 0;
					randomNum = rand.nextInt(max + 1 - min) + min;
				}
				System.out.println("You have found " + randomNum + " food!");
				main.settlement.food = main.settlement.food + randomNum;
				System.out.println("You now have " + main.settlement.food + " food");
				break;
			// Wood
			case 2:
				randomNum = rand.nextInt(Default.main.partySize * 2);
				System.out.println("You have found " + randomNum + " wood!");
				main.settlement.wood = main.settlement.wood + randomNum;
				System.out.println("You now have " + main.settlement.wood + " wood");
				break;
			// Metal
			case 3:
				randomNum = rand.nextInt(Default.main.partySize * 2);
				System.out.println("You have mined " + randomNum + " metal!");
				main.settlement.metal = main.settlement.metal + randomNum;
				System.out.println("You now have " + main.settlement.metal + " metal");
				break;
			default:
				break;
				}
	}
}
