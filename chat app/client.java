import java.io.*;
import java.net.*;

public class client
{

    public Socket socket;
    public DataInputStream inStream;
    public DataOutputStream outStream;

    public client() throws IOException
    {
        GUI gui = new GUI(this);
        socket = new Socket("localhost", 4999);
        inStream = new DataInputStream(socket.getInputStream());
        outStream = new DataOutputStream(socket.getOutputStream());
        while(true)
        {
            String incomingMessage = inStream.readUTF();
            gui.textArea.append("server says: " + incomingMessage + "\n");
        }
    }

    public static void main(String[] args) throws IOException
    {
        client client = new client();
    }
}
