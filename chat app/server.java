import java.io.*;
import java.net.*;

public class server 
{
    public ServerSocket serverSocket;
    public Socket socket;
    public DataInputStream inStream;
    public DataOutputStream outStream;

    public server() throws IOException
    {
        serverGUI gui = new serverGUI(this);
        serverSocket = new ServerSocket(4999);
        socket = serverSocket.accept();
        inStream = new DataInputStream(socket.getInputStream());
        outStream = new DataOutputStream(socket.getOutputStream());
        while(true)
        {
            String incomingMessage = inStream.readUTF();
            gui.textArea.append("client says: " + incomingMessage + "\n");
        }
    }

    public void sendMessage(String input) throws IOException
    {
        outStream = new DataOutputStream(socket.getOutputStream());
        outStream.writeUTF(input);
        outStream.flush();
    }

    public static void main(String[] args) throws IOException
    {
        server server = new server();    
    }
}
