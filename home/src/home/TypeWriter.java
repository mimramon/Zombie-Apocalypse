package home;
import java.util.*;



public class TypeWriter {
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
    	Scanner scan = new Scanner(System.in);
    	System.out.println("input the string you want to typewrite:");
		String str = scan.nextLine();
    	for(int i = 0; i < str.length(); i++) 
		{
    		try{Thread.sleep(150);}
    		catch(InterruptedException ex) {}
       		System.out.print(str.substring(i, i + 1));
       	}
		
	}

}
