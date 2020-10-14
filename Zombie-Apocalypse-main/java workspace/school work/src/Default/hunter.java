package Default;

public class hunter extends survivor
{
    public static JFrame JFrame = new JFrame();
    
    public hunter()
    {
        role = "Hunter";
        scavenging = 4;
        combatStrength = 5;
        foodConsumption = 3;
    }

    // HUNTER IDLE TASKS
	public void idle(int partyPosition)
	{
		main.JFrame.outputTextArea.append("\n\nWhat would you like your hunter to do.");
    	main.JFrame.outputTextArea.append("\n1) Scavenge\n2) Find timber\n3) Mining");
		defaultTasks(partyPosition);
	}
}
