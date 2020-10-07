package Default;

import java.util.*;

public class main //game manager class
{
    public static Scanner scan= new Scanner(System.in);
    public static String proceed;
    public static survivor[] PARTY = new survivor[30]; //
    
    public static void main(String[] args) throws NullPointerException //start function
    {
        System.out.println("Welcome to zombie apocalypse.\nPress enter to continue.");
        proceed = scan.nextLine();
        
        for (int i = 0;i<4;i++) //creates starting party
        {
        	PARTY[i] = new survivor();
        	PARTY[i].role = PARTY[i].JOBS[1];
        	PARTY[i].setStats();
        }
    }
    
}
