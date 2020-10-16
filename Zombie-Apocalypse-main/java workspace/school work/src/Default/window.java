// IMPORTS
import javax.swing.*; // Import the swing library
import java.awt.event.*;

public class window implements ActionListener
{   
    public static JFrame frame = new JFrame("Game GUI"); // Make the window and the name of the window
    public static JLabel title = new JLabel("Zombie Apocalypse", SwingConstants.CENTER); // Creates the title for the window
    public static JButton loadButton = new JButton("Load Game"); // Make the saveButton
    public static JButton saveButton = new JButton("Save Game"); // Make the saveButton
    public static JButton proceedButton = new JButton("Next"); // Make the proceedButton
    public static JTextArea outputArea = new JTextArea(); // Make the text area for the game output
    public static JScrollPane scroll = new JScrollPane(outputArea); // Make the scroll pane and place the output area inside of it
    public static JTextField inputField = new JTextField(); // Make the text field for the user input
    public static JProgressBar progressBar = new JProgressBar(); // Makes the progress bar 

    public void createWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make the window exit when X button pressed
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println("Look and feel could not be set");
        }

        
        title.setBounds(0, 15, 1280, 20); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(title); // Add the title to the JPanel

        
        loadButton.setBounds(20, 50, 100, 40); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(loadButton); // Add loadButton to the JFrame

        
        saveButton.setBounds(20, 100, 100, 40); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(saveButton); // Add saveButton to the JFrame

        
        outputArea.setBounds(140, 50, 1090, 550); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        scroll.setBounds(140, 50, 1090, 550); // Set bounds of the scroll panel        
        outputArea.setEditable(false); // Stops users from editing the output area
        outputArea.setLineWrap(true); // Start a new line when there isn't enough space ( Basically removes the need for a horisontal scrollbar)
        frame.getContentPane().add(scroll); // Add outputArea to the JFrame inside of scroll

        inputField.setBounds(140, 610, 950, 25); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(inputField); // Add the input field to the JFrame
        

        proceedButton.setBounds(1155, 610, 75, 25); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        frame.getContentPane().add(proceedButton); // Add the proceed button to the JFrame
        proceedButton.addActionListener(this);
        
        progressBar.setBounds(20, 650, 1220, 20); // IN ORDER: X Value (From Top Left), Y Value (From Top Left), Width, Height (ALL IN PIXELS)
        progressBar.setMinimum(0);  // Set the minimum value for the progress bar
        progressBar.setMaximum(100); // Set the maximum value for the progress bar
        progressBar.setStringPainted(true); // Allows text on the progress bar
        frame.getContentPane().add(progressBar); // Add progressBar to the JFrame
        

        frame.setSize(1280, 720); // Set the size of the window when opened
        frame.setLayout(null); // Set the window layout
        frame.setVisible(true); // Show the window
        frame.setResizable(false); // Disable resizing of the window
    }
    
    @Override
	public void actionPerformed(ActionEvent e)
	{
    	main.userInput = inputField.getText();
		outputArea.append(inputField.getText());
		inputField.setText("");
	}
    public static void nextRound()
    {
        progressBar.setValue(main.round); // Set the value of the progress bar
        progressBar.setString(main.round + "%"); // Sets the text of the progress bar
    }
}