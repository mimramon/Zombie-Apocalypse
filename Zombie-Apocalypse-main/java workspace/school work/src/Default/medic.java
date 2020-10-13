package Default;

public class medic extends survivor
{
    public medic()
    {
        role = "Medic";
        scavenging = 3;
    	combatStrength = 1;
    	foodConsumption = 1;
    }

    // MEDIC IDLE TASKS
	public void idle(int partyPosition)
	{
		Default.main.JFrame.outputTextArea.append("\n\nWhat would you like your medic to do.");
    	Default.main.JFrame.outputTextArea.append("\n1) Scavenge\n2) Find timber\n3) Mining");
		if((main.settlement.food >= 10) && main.settlement.workshop)
    	{
			Default.main.JFrame.outputTextArea.append("\n4) Make meds");
			//#region Builder Tasks (Up to task 5)
    		userInput = scan.nextInt();
    		switch (userInput) 
    		{
    			case 1:
    				break;
    			case 2:
					main.settlement.wood = main.settlement.wood + rand.nextInt(Default.main.partySize * 2);
					Default.main.JFrame.outputTextArea.append("\nYou now have " + main.settlement.wood + " wood");
    				break;
				case 3:
					randomNum = rand.nextInt(Default.main.partySize * 2);
					Default.main.JFrame.outputTextArea.append("\nYou have mined " + randomNum + " metal!");
					main.settlement.metal = main.settlement.metal + randomNum;
					Default.main.JFrame.outputTextArea.append("\nYou now have " + main.settlement.metal + " metal");
    				break;
				case 4:
					// Code to make meds here
					Default.main.JFrame.outputTextArea.append("\nHow many meds would you like to make?\nWith your current resources, you can make " + main.settlement.food/10 + " meds.");
					userInput = scan.nextInt();
					if(main.settlement.food/(userInput*10) >= 1)
					{
						main.settlement.food = main.settlement.food - (userInput*10);
						main.settlement.meds = main.settlement.meds + userInput;
						Default.main.JFrame.outputTextArea.append("\nYou have made " + userInput + " meds, you now have " + main.settlement.meds + " meds.");
					}
					else
					{
						Default.main.JFrame.outputTextArea.append("\nYou do not have enough food, please choose a different option");
						idle(partyPosition);
					}
					
    				break;
    			default:
    				break;
			}
					//#endregion
		}
		else 
		{
			defaultTasks(partyPosition);
		}
		
	}
}
