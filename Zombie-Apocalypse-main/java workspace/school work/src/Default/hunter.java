public class hunter extends survivor
{
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
		System.out.println("\nWhat would you like your hunter to do.");
    	System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
		defaultTasks(partyPosition);
	}
}
