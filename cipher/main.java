import java.util.Scanner;

public class main
{

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {

        System.out.println("type in your message in lowercase and using only alphabetical characters");
        String input = scan.next();
        System.out.println(encrypt(input, -2));
        String[] decryptArr = decrypt(encrypt(input, -2));
        System.out.println("take the decrypted message from the following");
        for(int i = 0; i < 25; i++)
        {
            System.out.println(decryptArr[i]);
        }

    }

    static String encrypt(String message, int _shift)
    {
        int shift = _shift;
        if(shift < 0)
        {
            shift = 26 + shift;
        }
        String msg = message;
        String encryptMsg = "";
        for(int i = 0; i < message.length(); i++)
        {
            char c = (char)(message.charAt(i) + shift);
            if(c > 'z')
            {
                encryptMsg += (char)(msg.charAt(i) - (26 - shift));
            }
            else
            {
                encryptMsg += (char)(msg.charAt(i) + shift);
            }
        }
        return encryptMsg;
    }

    static String[] decrypt(String _encryptMsg)
    {
        int arrayCounter = 0;
        String[] decryptMsg = new String[25];
        for(int j = 1; j < 26; j++)
        {
            decryptMsg[arrayCounter] = "";
            String encryptMsg = _encryptMsg;
            for(int i = 0; i < encryptMsg.length(); i++)
            {
                char c = (char)(encryptMsg.charAt(i) + j);
                if(c > 'z')
                {
                    decryptMsg[arrayCounter] += (char)(encryptMsg.charAt(i) - (26 - j));
                }
                else
                {
                    decryptMsg[arrayCounter] += (char)(encryptMsg.charAt(i) + j);
                }
            }
            arrayCounter++;
        }
        return decryptMsg;
    }

}