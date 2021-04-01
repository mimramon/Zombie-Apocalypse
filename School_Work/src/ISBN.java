import java.util.*;

public class ISBN 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int[] ISBN = new int[13];
        for(int i = 0; i < 13; i++)
        {
            System.out.println("enter digit " + (i+1) +" of the code");
            ISBN[i] = scan.nextInt();
        }
        scan.close();

        int calculatedDigit = 0;
        int count = 0;

        while(count < 12)
        {
            calculatedDigit += ISBN[count];
            count++;
            calculatedDigit += (ISBN[count] * 3);
            count++;
        }

        while(calculatedDigit >= 10)
        {
            calculatedDigit -= 10;
        }
        calculatedDigit = 10 - calculatedDigit;

        if(calculatedDigit == 10)
        {
            calculatedDigit = 0;
        }

        System.out.println("calculated digit: " + calculatedDigit);

        if(calculatedDigit == ISBN[12])
        {
            System.out.println("valid code");
        }
        else
        {
            System.out.println("invalid code");
        }
    }
}
