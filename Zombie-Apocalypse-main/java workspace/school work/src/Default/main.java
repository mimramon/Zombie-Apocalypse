package Default;

import java.util.*;

public class main //game manager class
{
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    public static String proceed;
    public static survivor[] PARTY = new survivor[4]; //
    public static int round = 1;
    public static boolean isDead = false;
    public static int event;
    
    
    public static void main(String[] args) //start function
    {
        System.out.println("Welcome to zombie apocalypse.\nPress enter to continue.");
        proceed = scan.nextLine();
        
        //creates starting party
        PARTY[0] = new survivor();
        PARTY[0].role ="hunter";
        PARTY[0].setStats();
        PARTY[1] = new survivor();
        PARTY[1].role ="hunter";
        PARTY[1].setStats();
        PARTY[2] = new survivor();
        PARTY[2].role ="builder";
        PARTY[2].setStats();
        PARTY[3] = new survivor();
        PARTY[3].role ="medic";
        PARTY[3].setStats();
        
        while(round <= 100 && !isDead)
        {
        	System.out.println("you are now startring round "+round);
        	
        	event = rand.nextInt(6);
        	
        	switch (event)
        	{
        	case 0:
        		System.out.println("zombie");
        		break;
        	case 1:
        		System.out.println("resource");
        		break;
        	case 2:
        		System.out.println("zombie");
        		break;
        	case 3:
        		System.out.println("food");
        		break;
        	case 4:
        		System.out.println("nothing");
        		break;
        	case 5:
        		System.out.println("survivor");
        		break;
        	default:
        		System.out.println("error starting round");
        		break;
        	}
        	
        	for (int i = 0; i < PARTY.length ; i++)
        	{
        		System.out.println(i);
        		//do the idle actions of the party member
        	}
        
        	round++;
        }
        
    }
    
}
