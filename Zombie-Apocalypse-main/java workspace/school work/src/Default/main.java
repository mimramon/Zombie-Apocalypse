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
		
		PARTY[0] = new hunter();
        PARTY[1] = new hunter();
        PARTY[2] = new builder();
        PARTY[3] = new medic();
		
        //Creates starting settlement
		settlement.setSettlement();
		System.out.println("You are starting the game with:");
		System.out.println("- " + settlement.houses + " house");
		System.out.println("- " + settlement.wood + " wood");
		System.out.println("- " + settlement.metal + " metal");
		System.out.println("- " + settlement.food + " food");
		System.out.println("- " + settlement.meds + " meds");
		System.out.println("- " + settlement.ammo + " ammo");
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
					System.out.println("Press enter to continue to task selection");
					proceed = scan.nextLine();
					break;

				// Another zombie event (To increase the chances of it occurring)
        		case 2:
					System.out.println("You are attacked by a horde of zombies");
					System.out.println("Press enter to continue to task selection");
					proceed = scan.nextLine();
					break;

				// food event
				case 3: 
					// Randomly generates an amount of food for the survivors to find
					int newfood = rand.nextInt(partySize * 2);
					System.out.println("You have found " + newfood + " food.");
					
					// Updates the total amount of food available
					settlement.food = settlement.food + newfood;
					System.out.println("You now have " + settlement.food + " food.");
					System.out.println("Press enter to continue to task selection");
					proceed = scan.nextLine();
					break;

				// Nothing happens
        		case 4:
					System.out.println("Nothing has has happened this round");
					System.out.println("Press enter to continue to task selection");
					proceed = scan.nextLine();
					break;

				// Survivor event
        		case 5:
					System.out.println("Survivor");
					System.out.println("Press enter to continue to task selection");
					proceed = scan.nextLine();
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
			PARTY[i].idle(i);	
		}
		System.out.println("\n\nPlease press enter to continue to the next round");
		proceed = scan.nextLine();
	}
    
}
