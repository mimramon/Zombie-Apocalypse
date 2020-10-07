package Default;

import java.util.*;

public class main //game manager class
{
    public static Scanner scan= new Scanner(System.in);
    public static String proceed;
    public static survivor[] SURVIVORS = new survivor[30];
    public static void main(String[] args) throws NullPointerException //start function
    {
        System.out.println("Welcome to zombie apocalypse.\nPress enter to continue.");
        proceed = scan.nextLine();
        
        SURVIVORS[0]= new survivor();
        
        //SURVIVORS[0].setStats();
       
    }
    
}
