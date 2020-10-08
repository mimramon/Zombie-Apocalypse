package Default;

// Imports
import java.util.*;

public class main // Game manager class
{
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    public static String proceed;
	public static Survivor[] PARTY = new Survivor[20];
	public static Settlement settlement = new Settlement();
	public static int partySize;
    public static int round = 1;
    public static boolean isDead = false;
    public static int event;
    
    
    public static void main(String[] args) // Start function
    {
        System.out.println("Welcome to zombie apocalypse.\nPress enter to continue.");
        proceed = scan.nextLine();
		
		startGame();

		roundManager(); 
        
	}
	
	public static void startGame()
	{
		// Creates starting party
		partySize = 4;
		
		PARTY[0] = new Survivor();
        PARTY[0].role ="Hunter";
        PARTY[0].setStats();
        PARTY[1] = new Survivor();
        PARTY[1].role ="Hunter";
        PARTY[1].setStats();
        PARTY[2] = new Survivor();
        PARTY[2].role ="Builder";
        PARTY[2].setStats();
        PARTY[3] = new Survivor();
        PARTY[3].role ="Medic";
        PARTY[3].setStats();
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
        			System.out.println("Zombie");
					break;
				// Resource event
        		case 1:
        			System.out.println("Resource");
					break;
				// Another zombie event (To increase the chances of it occuring)
        		case 2:
        			System.out.println("Zombie");
					break;
				// Food event
				case 3: 
					// Randomly generates an amount of food for the survivors to find
					int newFood = rand.nextInt(partySize * 2);
					System.out.println("You have found " + newFood + " food.");
					
					// Updates the total amount of food available
					settlement.food = settlement.food + newFood;
					System.out.println("You now have " + settlement.food + " food.");
					break;
				// Nothing happens
        		case 4:
					System.out.println("Nothing has has happened this round");
					break;
				// Survivor event
        		case 5:
        			System.out.println("Survivor");
					break;
				// Error
        		default:
        			System.out.println("There was an error starting the round");
        			break;
        	}
			
			// Idle tasks thhat occur every round
        	for (int i = 0; i < PARTY.length ; i++)
        	{
        		//System.out.println("IDLE TASK GOES HERE");
        		//do the idle actions of the party member
        	}
        
        	round++;
        }
	}
    
}
