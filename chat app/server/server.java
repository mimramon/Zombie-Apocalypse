//package server;
import java.io.*;
import java.net.*;

public class server 
{
    public ServerSocket serverSocket;
    public Socket socket;
    public DataInputStream inStream;
    public DataOutputStream outStream;
    public String userInput;

    public server() throws IOException
    {
        GUI gui = new GUI(this);
        serverSocket = new ServerSocket(4999);
        socket = serverSocket.accept();
        inStream = new DataInputStream(socket.getInputStream());
        outStream = new DataOutputStream(socket.getOutputStream());
        while(!userInput.equalsIgnoreCase("stop"))
        {
            System.out.println("server says: " + inStream.readUTF());
        }
    }

    public static void main(String[] args) throws IOException
    {
        server server = new server();
    }
}
