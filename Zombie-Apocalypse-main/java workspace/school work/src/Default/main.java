// Imports
import java.util.*;

public class main // Game manager class
{
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
	public static String proceed;
	public static boolean proceedBool = false;
	public static survivor[] PARTY = new survivor[20];
	public static zombie[] HORDE = new zombie[40]; 
	public static settlement settlement = new settlement();
	public static window gui = new window();
	public static int partySize;
	public static int hordeSize;
    public static int round = 1;
    public static boolean isDead = false;
    public static int event;
	public static String userInput;
    
    public static void main(String[] args) throws InterruptedException
    {
		// Open the window
		gui.createWindow();

		windowOutput("Welcome to Zombie Apocalypse.");
		windowOutput("Press enter to continue.");
        proceed();
		
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
	    windowOutput("You are starting the game with:");
		windowOutput("- " + settlement.houses + " house");
		windowOutput("- " + settlement.wood + " wood");
		windowOutput("- " + settlement.metal + " metal");
		windowOutput("- " + settlement.food + " food");
		windowOutput("- " + settlement.meds + " meds");
		windowOutput("- " + settlement.ammo + " ammo");
	}

	public static void roundManager() throws InterruptedException
	{
		while(round <= 100 && !isDead)
        {
			gui.nextRound();
        	windowOutput("\nYou are now starting round "+round);
			
			// In-game event handler
			
        	event = rand.nextInt(6);
        	
        	switch (event)
        	{
				// Zombie event
				case 0:
					zombieEvent();
					break;

				// Resource event
        		case 1:
					String[] resourceArray = {"wood", "metal", "meds", "ammo"};
					int newResource = rand.nextInt(resourceArray.length);
					int newResourceAmount = rand.nextInt(partySize * 5);
					windowOutput("Congratulations! You have found " + newResourceAmount + " " + resourceArray[newResource]);
				
					switch (resourceArray[newResource])
					{
						// Case for if the resource is wood
						case "wood":
							settlement.wood = settlement.wood + newResourceAmount;
							windowOutput("You now have " + settlement.wood + " wood");
							break;
						// Case for if the resource is metal
						case "metal":
							settlement.meds = settlement.meds + newResourceAmount;
							windowOutput("You now have " + settlement.meds + " metal");
							break;
						// Case for if the resource is meds
						case "meds":
							settlement.meds = settlement.meds + newResourceAmount;
							windowOutput("You now have " + settlement.meds + " meds");
							break;
						// Case for if the resource is ammo
						case "ammo":
							settlement.ammo = settlement.ammo + newResourceAmount;
							windowOutput("You now have " + settlement.ammo + " ammo");
							break;
						// Error
						default:
							windowOutput("There was an error collecting the resources");
							break;
					}
					windowOutput("Press enter to continue to task selection");
					proceed();
					break;

				// Another zombie event (To increase the chances of it occurring)
				case 2:
					zombieEvent();
					break;

				// food event
				case 3: 
					// Randomly generates an amount of food for the survivors to find
					int newfood = rand.nextInt(partySize * 2);
					windowOutput("You have found " + newfood + " food.");
					
					// Updates the total amount of food available
					settlement.food = settlement.food + newfood;
					windowOutput("You now have " + settlement.food + " food.");
					windowOutput("Press enter to continue to task selection");
					proceed();
					break;

				// Nothing happens
        		case 4:
					windowOutput("Nothing has has happened this round");
					windowOutput("Press enter to continue to task selection");
					proceed();
					break;

				// Survivor event
        		case 5:
					survivorEvent();
					break;
					
				// Error
        		default:
        			windowOutput("There was an error starting the round");
        			break;
        	}
        	
        	idleTasks();
			round++;
			if (partySize < 1)
			{
				isDead = true;
			}	
		}	
	}
	
	public static void idleTasks() throws InterruptedException
	{
		// Idle tasks that occur every round
    	for (int i = 0; i < partySize ; i++)
    	{
			PARTY[i].idle(i);	
		}
		windowOutput("\n\nPlease press enter to continue to the next round");
		proceed();
	}
	
	public static void survivorEvent() throws InterruptedException
	{
		if(partySize < settlement.houses*4)
		{
			partySize++;
			int random = rand.nextInt(4);
			switch (random)
			{
				case 0:
					PARTY[partySize-1] = new hunter();
					break;
				case 1:
					PARTY[partySize-1] = new blacksmith();
					break;
				case 2:
					PARTY[partySize-1] = new builder();
					break;
				case 3:
					PARTY[partySize-1] = new medic();
					break;
				default:
					windowOutput("There was an error adding a new survivor");
					break;
			}
			windowOutput("You found a " + PARTY[partySize-1].role + ". They have joined your party!");
		}
		else
		{
			windowOutput("A survivor tried to join your party but you had no space. RIP");
		}

		windowOutput("Press enter to continue to task selection");
		proceed();
	}

	public static void zombieEvent() throws InterruptedException
	{
		hordeSize = rand.nextInt(partySize*2);
		windowOutput("You have encountered:");
		for(int i = 0; i < hordeSize; i++)
		{
			HORDE[i] = new zombie();
			HORDE[i].role = HORDE[i].zombieTypes[rand.nextInt(3)];
			HORDE[i].setStats();
			windowOutput("-" + HORDE[i].role);
		}
	
		windowOutput("The horde consists of " + hordeSize + " zombies");
		
		int partyPower = 0;
		for(int i = 0; i < partySize; i++)
		{
			partyPower += PARTY[i].combatStrength;
		}
	
		int hordePower = 0;
		for(int i = 0; i < hordeSize; i++)
		{
			hordePower = hordePower + HORDE[i].combatStrength;
		}
	
		windowOutput("\nYour total combat power is: " + partyPower + "\nThe total combat power of the horde is: " + hordePower);
		windowOutput("Would you like to use ammo to increase your total combat power or potentially risk the life of a survivor? ( Yes/No )");
		userInput = scan.nextLine();
		windowOutput(userInput);
		while(!(userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("No")))
		{
			windowOutput("Please enter a valid answer");
			userInput = scan.nextLine();
			windowOutput(userInput);
		}

		if(userInput.equalsIgnoreCase("Yes"))
		{
			windowOutput("How much ammo would you like to use. 1 ammo equates to +1 combat strength");
			windowOutput("You have " + settlement.ammo + " available to use");
			userInput = scan.nextLine();
			windowOutput(userInput);
			while(!(Integer.parseInt(userInput) <= settlement.ammo))
			{
				windowOutput("Please enter a valid value");
				userInput = scan.nextLine();
				windowOutput(userInput);
			}
			partyPower += Integer.parseInt(userInput);
			windowOutput("Your total combat power is now " + partyPower);
			settlement.ammo -= Integer.parseInt(userInput);
		}

		if((partyPower - hordePower) >= 1)
		{
			windowOutput("You have emerged victorious! Your survivors will live to see another day.");
		}
		else if ((partyPower - hordePower) <= -1)
		{
			windowOutput("Your party was outclassed by the zombie horde, your most recent survivor has been fatally wounded");
			if(settlement.meds > 0)
			{
				windowOutput("Would you like to use 1 med to save this survivor? ( Yes/No )");
				userInput = scan.nextLine();
				windowOutput(userInput);
				while(!(userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no")))
				{
					windowOutput("Please enter a valid answer");
					userInput = scan.nextLine();
					windowOutput(userInput);
				}

				if(userInput.equalsIgnoreCase("Yes"))
				{
					settlement.meds--;
					windowOutput("You saved them");
				}
				else if(userInput.equalsIgnoreCase("No"))
				{
					windowOutput("YOU MONSTER! YOU HAD ENOUGH MEDS TO SAVE THEIR LIFE AND YOU CHOSE NOT TO!!!");
					PARTY[partySize-1] = null;
					partySize--;
				}
			}
			else 
			{
				windowOutput("They have perished");
				PARTY[partySize-1] = null;
				partySize--;
			}
		}
		else 
		{
			windowOutput("Your party is evenly matched with the horde. The gods will decide your fate..");
			int randomNum = rand.nextInt(2);
			if(randomNum == 0)
			{
				windowOutput("You have emerged victorious! Your survivors will live to see another day.");
			}
			else 
			{
				windowOutput("The odds were not in your favour, your most recent survivor has been fatally wounded");
				if(settlement.meds > 0)
				{
					windowOutput("Would you like to use 1 med to save this survivor? ( Yes/No )");
					userInput = scan.nextLine();
					windowOutput(userInput);
					while(!(userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no")))
					{
						windowOutput("Please enter a valid answer");
						userInput = scan.nextLine();
						windowOutput(userInput);
					}
					if(userInput.equalsIgnoreCase("Yes"))
					{
						settlement.meds--;
						windowOutput("You saved them");
					}
					else if(userInput.equalsIgnoreCase("No"))
					{
						windowOutput("YOU MONSTER! YOU HAD ENOUGH MEDS TO SAVE THEIR LIFE AND YOU CHOSE NOT TO!!!");
						PARTY[partySize-1] = null;
						partySize--;
					}
				}
				else 
				{
					windowOutput("They have perished");
					PARTY[partySize-1] = null;
					partySize--;
				}
			}
		}
		windowOutput("Press enter to continue to task selection");
		proceed();			
	}
	
	public static void windowOutput(String output)
	{
		window.outputArea.append(output); // Append the text to the output area
		window.outputArea.append("\n"); // ^^^
		window.outputArea.setCaretPosition(window.outputArea.getDocument().getLength()); // Set the scroll bar to the bottom in the JFrame
	}
	
	public static void proceed() throws InterruptedException 
	{
		while(!proceedBool)
		{
			Thread.sleep(1);
		}
		proceedBool = false;
	}
}
