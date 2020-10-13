package Default;

// Imports
import java.util.*;
import javax.swing.*;

public class main // Game manager class
{
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    public static String proceed;
	public static survivor[] PARTY = new survivor[20];
	public static zombie[] HORDE = new zombie[40]; 
	public static settlement settlement = new settlement();
	public static JFrame JFrame = new JFrame();
	public static int partySize;
	public static int hordeSize;
    public static int round = 1;
    public static boolean isDead = false;
    public static int event;
	public static String userInput;
    
    public static void main(String[] args) // Start function
    {
		JFrame.main(args);
		JFrame.setVisible(true);
		JFrame.outputTextArea.append("\nWelcome to Zombie Apocalypse.\nPress enter to continue.");
		
		
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
		JFrame.setVisible(true);
		JFrame.outputTextArea.append("\nYou are starting the game with:");
		JFrame.outputTextArea.append("\n- " + settlement.houses + " house");
		JFrame.outputTextArea.append("\n- " + settlement.wood + " wood");
		JFrame.outputTextArea.append("\n- " + settlement.metal + " metal");
		JFrame.outputTextArea.append("\n- " + settlement.food + " food");
		JFrame.outputTextArea.append("\n- " + settlement.meds + " meds");
		JFrame.outputTextArea.append("\n- " + settlement.ammo + " ammo");
	}

	public static void roundManager()
	{
		while(round <= 100 && !isDead)
        {
        	JFrame.outputTextArea.append("\n\nYou are now starting round "+round);
			
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
					JFrame.outputTextArea.append("\nCongratulations! You have found " + newResourceAmount + " " + resourceArray[newResource]);
				
					switch (resourceArray[newResource])
					{
						// Case for if the resource is wood
						case "wood":
							settlement.wood = settlement.wood + newResourceAmount;
							JFrame.outputTextArea.append("\nYou now have " + settlement.wood + " wood");
							break;
						// Case for if the resource is metal
						case "metal":
							settlement.meds = settlement.meds + newResourceAmount;
							JFrame.outputTextArea.append("\nYou now have " + settlement.meds + " metal");
							break;
						// Case for if the resource is meds
						case "meds":
							settlement.meds = settlement.meds + newResourceAmount;
							JFrame.outputTextArea.append("\nYou now have " + settlement.meds + " meds");
							break;
						// Case for if the resource is ammo
						case "ammo":
							settlement.ammo = settlement.ammo + newResourceAmount;
							JFrame.outputTextArea.append("\nYou now have " + settlement.ammo + " ammo");
							break;
						// Error
						default:
							JFrame.outputTextArea.append("\nThere was an error collecting the resources");
							break;
					}
					JFrame.outputTextArea.append("\n\nPress enter to continue to task selection");
					proceed = scan.nextLine();
					break;

				// Another zombie event (To increase the chances of it occurring)
				case 2:
					zombieEvent();
					break;

				// food event
				case 3: 
					// Randomly generates an amount of food for the survivors to find
					int newfood = rand.nextInt(partySize * 2);
					JFrame.outputTextArea.append("\n\nYou have found " + newfood + " food.");
					
					// Updates the total amount of food available
					settlement.food = settlement.food + newfood;
					JFrame.outputTextArea.append("\n\nYou now have " + settlement.food + " food.");
					JFrame.outputTextArea.append("\n\nPress enter to continue to task selection");
					proceed = scan.nextLine();
					break;

				// Nothing happens
        		case 4:
					JFrame.outputTextArea.append("\n\nNothing has has happened this round");
					JFrame.outputTextArea.append("\n\nPress enter to continue to task selection");
					proceed = scan.nextLine();
					break;

				// Survivor event
        		case 5:
					survivorEvent();
					break;
					
				// Error
        		default:
        			JFrame.outputTextArea.append("\n\nThere was an error starting the round");
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
	
	public static void idleTasks()
	{
		// Idle tasks that occur every round
    	for (int i = 0; i < partySize ; i++)
    	{
			PARTY[i].idle(i);	
		}
		JFrame.outputTextArea.append("\n\n\nPlease press enter to continue to the next round");
		proceed = scan.nextLine();
	}
	
	public static void survivorEvent()
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
					JFrame.outputTextArea.append("\n\nThere was an error adding a new survivor");
					break;
			}
			JFrame.outputTextArea.append("\n\nYou found a " + PARTY[partySize-1].role + ". They have joined your party!");
		}
		else
		{
			JFrame.outputTextArea.append("\n\nA survivor tried to join your party but you had no space. RIP");
		}

		JFrame.outputTextArea.append("\n\nPress enter to continue to task selection");
		proceed = scan.nextLine();
	}

	public static void zombieEvent()
	{
		hordeSize = rand.nextInt(partySize*2);
		JFrame.outputTextArea.append("\n\nYou have encountered:");
		for(int i = 0; i < hordeSize; i++)
		{
			HORDE[i] = new zombie();
			HORDE[i].role = HORDE[i].zombieTypes[rand.nextInt(3)];
			HORDE[i].setStats();
			JFrame.outputTextArea.append("\n-" + HORDE[i].role);
		}
	
		JFrame.outputTextArea.append("\n\nThe horde consists of " + hordeSize + " zombies");
		
		int partyPower = 0;
		for(int i = 0; i < partySize - 1; i++)
		{
			partyPower += PARTY[i].combatStrength;
		}
	
		int hordePower = 0;
		for(int i = 0; i < partySize - 1; i++)
		{
			hordePower += PARTY[i].combatStrength;
		}
	
		JFrame.outputTextArea.append("\n\nYour total combat power is: " + partyPower + "\nThe total combat power of the horde is: " + hordePower);
		JFrame.outputTextArea.append("\nWould you like to use ammo to increase your total combat power or potentially risk the life of a survivor? ( Yes/No )");
		userInput = scan.nextLine();
		while(!(userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("No")))
		{
			JFrame.outputTextArea.append("\nPlease enter a valid answer");
		}

		if(userInput.equalsIgnoreCase("Yes"))
		{
			JFrame.outputTextArea.append("\nHow much ammo would you like to use. 1 ammo equates to +1 combat strength");
			JFrame.outputTextArea.append("\nYou have " + settlement.ammo + " available to use");
			userInput = scan.nextLine();
			while(!(Integer.parseInt(userInput) <= settlement.ammo))
			{
				JFrame.outputTextArea.append("\nPlease enter a valid value");
			}
			partyPower += Integer.parseInt(userInput);
			JFrame.outputTextArea.append("\nYour total combat power is now " + partyPower);
			settlement.ammo -= Integer.parseInt(userInput);
		}

		if((partyPower - hordePower) >= 1)
		{
			JFrame.outputTextArea.append("\nYou have emerged victorious! Your survivors will live to see another day.");
		}
		else if ((partyPower - hordePower) <= -1)
		{
			JFrame.outputTextArea.append("\nYour party was outclassed by the zombie horde, your most recent survivor has been fatally wounded");
			if(settlement.meds > 0)
			{
				JFrame.outputTextArea.append("\nWould you like to use 1 med to save this survivor? ( Yes/No )");
				userInput = scan.nextLine();
				while(!(userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no")))
				{
					userInput = scan.nextLine();
				}

				if(userInput.equalsIgnoreCase("Yes"))
				{
					settlement.meds--;
					JFrame.outputTextArea.append("\nYou saved them");
				}
				else if(userInput.equalsIgnoreCase("No"))
				{
					JFrame.outputTextArea.append("\nYOU MONSTER! YOU HAD ENOUGH MEDS TO SAVE THEIR LIFE AND YOU CHOSE NOT TO!!!");
					PARTY[partySize-1] = null;
					partySize--;
				}
			}
			else 
			{
				JFrame.outputTextArea.append("\nThey have perished");
				PARTY[partySize-1] = null;
				partySize--;
			}
		}
		else 
		{
			JFrame.outputTextArea.append("\nYour party is evenly matched with the horde. The gods will decide your fate..");
			int randomNum = rand.nextInt(2);
			if(randomNum == 0)
			{
				JFrame.outputTextArea.append("\nYou have emerged victorious! Your survivors will live to see another day.");
			}
			else 
			{
				JFrame.outputTextArea.append("\nThe odds were not in your favour, your most recent survivor has been fatally wounded");
				if(settlement.meds > 0)
				{
					JFrame.outputTextArea.append("\nWould you like to use 1 med to save this survivor? ( Yes/No )");
					userInput = scan.nextLine();
					while(!(userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no")))
					if(userInput.equalsIgnoreCase("Yes"))
					{
						settlement.meds--;
						JFrame.outputTextArea.append("\nYou saved them");
					}
					else if(userInput.equalsIgnoreCase("No"))
					{
						JFrame.outputTextArea.append("\nYOU MONSTER! YOU HAD ENOUGH MEDS TO SAVE THEIR LIFE AND YOU CHOSE NOT TO!!!");
						PARTY[partySize-1] = null;
						partySize--;
					}
				}
				else 
				{
					JFrame.outputTextArea.append("\nThey have perished");
					PARTY[partySize-1] = null;
					partySize--;
				}
			}
		}
		JFrame.outputTextArea.append("\nPress enter to continue to task selection");
		proceed = scan.nextLine();
					
	}
}
