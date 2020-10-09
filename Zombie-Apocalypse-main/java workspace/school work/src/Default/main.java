package Default;

// Imports
import java.util.*;

public class main // Game manager class
{
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    public static String proceed;
	public static survivor[] PARTY = new survivor[20];
	public static settlement settlement = new settlement();
	public static int partySize;
    public static int round = 1;
    public static boolean isDead = false;
    public static int event;
    public static String userInput;
    
    public static void main(String[] args) // Start function
    {
        System.out.println("Welcome to Zombie Apocalypse.\nPress enter to continue.");
        proceed = scan.nextLine();
		
		startGame();

		roundManager();       
	}
	
	public static void startGame()
	{
		// Creates starting party
		partySize = 4;
		
		PARTY[0] = new survivor();
        PARTY[0].role ="Hunter";
        PARTY[0].setStats();
        PARTY[1] = new survivor();
        PARTY[1].role ="Hunter";
        PARTY[1].setStats();
        PARTY[2] = new survivor();
        PARTY[2].role ="Builder";
        PARTY[2].setStats();
        PARTY[3] = new survivor();
        PARTY[3].role ="Medic";
		PARTY[3].setStats();
		
		
        //Creates starting settlement
		settlement.setSettlement();
	}

	public static void roundManager()
	{
		while(round <= 100 && !isDead)
        {
        	System.out.println("\nYou are now startring round "+round);
			
			// In-game event handler
			
        	event = rand.nextInt(6);
        	
        	switch (event)
        	{
				// Zombie event
        		case 0:
        			System.out.println("You are attacked by a horde of zombies\nPress enter to continue to the next round");
					//proceed = scan.nextLine();
					break;

				// Resource event
        		case 1:
					String[] resourceArray = {"wood", "metal", "meds", "ammo"};
					int newResource = rand.nextInt(resourceArray.length);
					int newResourceAmount = rand.nextInt(partySize * 5);
					System.out.println("Congratulations! You have found " + newResourceAmount + " " + resourceArray[newResource]);
				
					switch (resourceArray[newResource])
					{
						// Case for if the resource is wood
						case "wood":
							settlement.wood = settlement.wood + newResourceAmount;
							System.out.println("You now have " + settlement.wood + " wood");
							break;
						// Case for if the resource is metal
						case "metal":
							settlement.meds = settlement.meds + newResourceAmount;
							System.out.println("You now have " + settlement.meds + " metal");
							break;
						// Case for if the resource is meds
						case "meds":
							settlement.meds = settlement.meds + newResourceAmount;
							System.out.println("You now have " + settlement.meds + " meds");
							break;
						// Case for if the resource is ammo
						case "ammo":
							settlement.ammo = settlement.ammo + newResourceAmount;
							System.out.println("You now have " + settlement.ammo + " ammo");
							break;
						// Error
						default:
							System.out.println("There was an error collecting the resources");
							break;
					}

					System.out.println("Press enter to continue to the next round");

					//proceed = scan.nextLine();
					break;

				// Another zombie event (To increase the chances of it occurring)
        		case 2:
					System.out.println("You are attacked by a horde of zombies\nPress enter to continue to the next round");
					//proceed = scan.nextLine();
					break;

				// food event
				case 3: 
					// Randomly generates an amount of food for the survivors to find
					int newfood = rand.nextInt(partySize * 2);
					System.out.println("You have found " + newfood + " food.");
					
					// Updates the total amount of food available
					settlement.food = settlement.food + newfood;
					System.out.println("You now have " + settlement.food + " food.\nPress enter to continue to the next round");
					//proceed = scan.nextLine();
					break;

				// Nothing happens
        		case 4:
					System.out.println("Nothing has has happened this round\nPress enter to continue.");
					//proceed = scan.nextLine();
					break;

				// Survivor event
        		case 5:
					System.out.println("Survivor\nPress enter to continue to the next round");
					//proceed = scan.nextLine();
					break;
					
				// Error
        		default:
        			System.out.println("There was an error starting the round");
        			break;
        	}
        	
        	idleTasks();
        	round++;
        }
	}
	
	public static void idleTasks()
	{
		// Idle tasks that occur every round
    	for (int i = 0; i < partySize ; i++)
    	{
    		//do the idle actions of the party member
    		System.out.println("\nWhat would you like your " + PARTY[i].role + " to do.");
    		System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
    		
    		//THE FOLLOWING IS SHIT CODE, NEVER DO THIS
    		if(PARTY[i].role.equals("Builder"))
    		{
				PARTY[i].builderIdle();
			}
			else if(PARTY[i].role.equals("Blacksmith"))
			{
				PARTY[i].blacksmithIdle();
			}
			else if(PARTY[i].role.equals("Medic"))
			{
				PARTY[i].medicIdle();
			}
			else if(PARTY[i].role.equals("Hunter"))
			{
				PARTY[i].hunterIdle();
			}
			else 
			{
			System.out.println("There was an error ");
			}
			
    	}
	}
    
}
