// IMPORTS
import javax.swing.*;

public class window
{   
    public static JFrame frame = new JFrame("Game GUI"); // Make the window and the name of the window
    public static JLabel title = new JLabel("Zombie Apocalypse", SwingConstants.CENTER); // Creates the title for the window
    public static JButton loadButton = new JButton("Load Game"); // Make the saveButton
    public static JButton saveButton = new JButton("Save Game"); // Make the saveButton
    public static JTextArea outputArea = new JTextArea(); // Make the text area for the game output
    public static JProgressBar progressBar = new JProgressBar(); // Makes the progress bar 

    public static void createWindow() {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make the window exit when X button pressed

        
        title.setBounds(0, 15, 1280, 20);
        frame.getContentPane().add(title);

        
        loadButton.setBounds(20, 50, 100, 40); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(loadButton); // Add loadButton to the JFrame

        
        saveButton.setBounds(20, 100, 100, 40); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(saveButton); // Add saveButton to the JFrame

        
        outputArea.setBounds(140, 50, 1090, 550); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(outputArea); // Add outputArea to the JFrame

        
        progressBar.setBounds(20, 650, 1220, 20); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        progressBar.setMinimum(0);  // Set the minimum value for the progress bar
        progressBar.setMaximum(100); // Set the maximum value for the progress bar
        progressBar.setStringPainted(true); // Allows text on the progress bar
        frame.getContentPane().add(progressBar); // Add progressBar to the JFrame
        
        frame.setSize(1280, 720); // Set the size of the window when opened
        frame.setLayout(null); // Set the window layout
        frame.setVisible(true); // Show the window
    }
    public static void nextRound()
    {
        progressBar.setValue(main.round); // Set the value of the progress bar
        progressBar.setString(main.round + "%");
    }
}