package FrameExperiments;
import javax.swing.*;
import java.awt.event.*;

public class MenuWindow extends JFrame
{
    public MenuWindow()
    {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);  
        pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setBounds(0, 0, 1280, 720); 
        JButton newGame = new JButton("new game");
        newGame.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){Main.createWindow(Main.WinType.GAME);}});
        this.add(newGame);
    }
}
