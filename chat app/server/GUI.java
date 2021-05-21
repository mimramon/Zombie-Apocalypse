import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener
{
    JTextField textField;
    JButton send;
    client client;
    server server;
    public GUI(server _server)
    {
        server = _server;
        setTitle("Chat App");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);  
        pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setBounds(0, 0, 1280, 720); 
        textField = new JTextField();
        send = new JButton();
        send.addActionListener(this);
        this.setResizable(false);
        this.add(send);
        this.add(textField);
        textField.setVisible(true);
        textField.setBounds(544, 0, 128, 18);
        send.setVisible(true);
        send.setBounds(674,0,64,18);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == send)
        {
            String input = textField.getText();
            try
            {
                server.outStream.writeUTF(input);
                server.outStream.flush();
            }
            catch(IOException ex)
            {
                System.out.println(ex);
            }
        }
    }
}