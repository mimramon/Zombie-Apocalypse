//package client;

import java.io.*;
import java.net.*;

public class client
{

    public Socket socket;
    public DataInputStream inStream;
    public DataOutputStream outStream;

    public String userInput;
    public client() throws IOException
    {
        GUI gui = new GUI(this);
        socket = new Socket("localhost", 4999);
        inStream = new DataInputStream(socket.getInputStream());
        outStream = new DataOutputStream(socket.getOutputStream());
        while(!userInput.equalsIgnoreCase("stop"))
        {
            System.out.println("server says: " + inStream.readUTF());
        }
    }

    public static void main(String[] args) throws IOException
    {
        client client = new client();
    }
}
