import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.io.*;

public class GUI extends JFrame implements ActionListener
{
    public JTextField textField;
    public JButton send;
    public JTextArea textArea;
    public server server;
    public client client;

    public GUI(server _server)
    {
        server = _server;
        setupFrame();
    }

    public GUI(client _client)
    {
        client = _client;
        setupFrame();
    }

    public void setupFrame()
    {
        //basic frame
        setTitle("Chat App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.setSize(1280, 720);  
        this.setResizable(false);

        //frame components
        textField = new JTextField();
        send = new JButton("Send");
        textArea = new JTextArea();
        textField.setMaximumSize(new Dimension(128, 18));
        textArea.setMaximumSize(new Dimension(192, 72));
        send.addActionListener(this);
        textArea.setBounds(544, 360, 192, 72);
        textField.setBounds(544, 0, 128, 18);
        send.setBounds(674,0,64,18);
        this.add(textArea);
        this.add(send);
        this.add(textField);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == send)
        {
            String input = textField.getText();
            textField.setText("");
            try
            {
                if(server != null && client == null)
                {
                    server.outStream.writeUTF(input);
                    server.outStream.flush();
                }
                else if(server == null && client != null)
                {
                    client.outStream.writeUTF(input);
                    client.outStream.flush();
                }
                else 
                {
                    textArea.append("error");
                }
            }
            catch(IOException ex)
            {
                System.out.println(ex);
            }
        }
    }
}