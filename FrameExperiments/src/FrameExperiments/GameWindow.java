package FrameExperiments;
import javax.swing.*;

public class GameWindow extends JFrame 
{
    public GameWindow()
    {
        setTitle("Game"); //may want to set a parameter for this instead
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setBounds(0, 0, 1280, 720);  
        this.add(new PixelCanvas());

    }
}
