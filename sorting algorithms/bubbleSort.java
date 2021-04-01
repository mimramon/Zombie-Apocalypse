import java.util.*;

public class bubbleSort
{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) 
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("enter the numbers you want to sort, if you are done type 'done'");
        boolean done = false;
        while(!done)
        {
            String input = scan.next();
            if(input.equalsIgnoreCase("done"))
            {
                done = true;
            }
            else
            {
                try
                {
                    int num = Integer.parseInt(input);
                    list.add(num);
                }
                
                catch(Exception e)
                {
                    System.out.println("that isnt a valid input");
                }  
            }
               
        }
        System.out.println("list has been entered");
        if(list.size() == 0)
        {
            System.out.println("you didnt enter anything into the list!");
        }
        else
        {
            list = Sort(list);
            System.out.println("this is the sorted list");
            for(int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i));
            }
        }
    }

    static ArrayList<Integer> Sort(ArrayList<Integer> _list)
    {
        ArrayList<Integer> list = _list;
        
        for(int i = 0; i < list.size() ; i++)
        {
            for(int j = 0; j < list.size(); j++)
            {
                if(j>= list.size()-1){}
                else if(list.get(j) > list.get(j + 1))
                {
                    int num = list.get(j);
                    list.remove(j);
                    list.add(j + 1, num);
                }
            }
        }
        return list;
    }
}