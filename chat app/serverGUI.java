import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class serverGUI extends JFrame implements ActionListener
{
    public JPanel inputPanel;
    public JPanel outputPanel;
    public JPanel buttonPanel;
    public JTextField textField;
    public JButton send;
    public JTextArea textArea;
    public server server;

    public serverGUI(server _server)
    {
        server = _server;
        setupFrame();
    }

    public void setupFrame()
    {
        //basic frame
        setTitle("Chat App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1280, 720);  
        setResizable(false);

        //Jpanel setup
        inputPanel = new JPanel();
        outputPanel = new JPanel();
        buttonPanel = new JPanel();
        inputPanel.setBackground(Color.CYAN);
        outputPanel.setBackground(Color.PINK);
        buttonPanel.setBackground(Color.GREEN);
        inputPanel.setLayout(new BorderLayout());
        outputPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new BorderLayout());
        inputPanel.setBounds(542, 0, 130, 18);
        outputPanel.setBounds(542, 20, 196, 72);
        buttonPanel.setBounds(674, 0, 66, 18);
        add(outputPanel);
        add(inputPanel);
        add(buttonPanel);

        //panel component setup
        textField = new JTextField();
        send = new JButton("Send");
        textArea = new JTextArea();
        send.addActionListener(this);
        textArea.setSize(196, 72);
        textField.setSize(128, 16);
        send.setSize(64, 16);
        textArea.setAlignmentX(0);
        textArea.setAlignmentY(0);
        textField.setAlignmentX(0);
        textField.setAlignmentY(0);
        send.setAlignmentX(1);
        send.setAlignmentY(0);
        
        outputPanel.add(textArea);
        inputPanel.add(textField);
        buttonPanel.add(send);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == send)
        {
            String input = textField.getText();
            textField.setText("");
            try
            {
                server.sendMessage(input);
            }
            
            catch(IOException ex)
            {
                System.out.println(ex);
            }
        }
    }
}