package Default;

// Imports
import java.util.*;

public class main // Game manager class
{
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    public static String proceed;
    public static survivor[] PARTY = new survivor[4]; //
    public static int round = 1;
    public static boolean isDead = false;
    public static int event;
    
    
    public static void main(String[] args) // Start function
    {
        System.out.println("Welcome to zombie apocalypse.\nPress enter to continue.");
        proceed = scan.nextLine();
        
        // Sreates starting party
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
        			System.out.println("Food");
					break;
				// Nothing happens
        		case 4:
        			System.out.println("Nothing");
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
