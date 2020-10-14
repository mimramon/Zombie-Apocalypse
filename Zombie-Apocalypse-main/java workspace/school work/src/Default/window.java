// IMPORTS
import javax.swing.*;

public class window
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Game GUI"); // Make the window and the name of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make the window exit when X button pressed

        JButton loadButton = new JButton("Load Game"); // Make the saveButton
        loadButton.setBounds(20, 50, 100, 40); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(loadButton); // Add loadButton to the JFrame

        JButton saveButton = new JButton("Save Game"); // Make the saveButton
        saveButton.setBounds(20, 100, 100, 40); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(saveButton); // Add saveButton to the JFrame

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(140, 50, 1090, 620);
        frame.getContentPane().add(outputArea);
        
        frame.setSize(1280, 720); // Set the size of the window when opened
        frame.setLayout(null); // Set the window layout
        frame.setVisible(true); // Show the window
    }
}