import java.io.*;
import java.net.*;

public class client
{
    public Socket socket;
    public DataInputStream inStream;
    public DataOutputStream outStream;

    public client() throws IOException
    {
        clientGUI gui = new clientGUI(this);
        socket = new Socket("localhost", 4999);
        inStream = new DataInputStream(socket.getInputStream());
        outStream = new DataOutputStream(socket.getOutputStream());
       
        while(true)
        {
            String incomingMessage = inStream.readUTF();
            gui.textArea.append("server says: " + incomingMessage + "\n");
        }
    }

    public void sendMessage(String input) throws IOException
    {
        outStream = new DataOutputStream(socket.getOutputStream());
        outStream.writeUTF(input);
        outStream.flush();
    }

    /*
    public static void main(String[] args) throws IOException
    {
        client client = new client();
    }
    */
}
