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
	public static String userInput;
	public static int randomNum;
	
	public void idle(int partyPosition)
	{

	}

	public void defaultTasks(int partyPosition) 
	{
		userInput = scan.nextLine();
		while(!(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") ))
		{
			System.out.println("Please enter a valid answer");
			userInput = scan.nextLine();
		}
		switch (Integer.parseInt(userInput)) 
		{
			// Scavenging
			case 1:
				if(main.PARTY[partyPosition].role.equals("Hunter"))
				{
					int max = main.PARTY[partyPosition].scavenging * 3;
					int min = main.partySize;
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
				randomNum = rand.nextInt(main.partySize * 2);
				System.out.println("You have found " + randomNum + " wood!");
				main.settlement.wood = main.settlement.wood + randomNum;
				System.out.println("You now have " + main.settlement.wood + " wood");
				break;
			// Metal
			case 3:
				randomNum = rand.nextInt(main.partySize * 2);
				System.out.println("You have mined " + randomNum + " metal!");
				main.settlement.metal = main.settlement.metal + randomNum;
				System.out.println("You now have " + main.settlement.metal + " metal");
				break;
				
			default:
				break;
		}
	}
}
