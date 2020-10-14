package Default;

public class blacksmith extends survivor
{
	public static JFrame JFrame = new JFrame();
	
    public blacksmith()
    {
		role = "Blacksmith";
		scavenging = 1;
    	combatStrength = 3;
    	foodConsumption = 4;
	}

    // BLACKSMITH IDLE TASKS
	public void idle(int partyPosition)
	{
		main.JFrame.outputTextArea.append("\n\nWhat would you like your blacksmith to do.");
    	main.JFrame.outputTextArea.append("\n1) Scavenge\n2) Find timber\n3) Mining");
		if(main.settlement.metal >0 && main.settlement.workshop)
    	{
			main.JFrame.outputTextArea.append("\n4) Make ammo");
    		userInput = scan.nextInt();
    		switch (userInput) 
    		{
    			case 1:
    				break;
    			case 2:
					main.settlement.wood = main.settlement.wood + rand.nextInt(main.partySize * 2);
					main.JFrame.outputTextArea.append("\nYou now have " + main.settlement.wood + " wood");
    				break;
    			case 3:
					randomNum = rand.nextInt(main.partySize * 2);
					main.JFrame.outputTextArea.append("\nYou have mined " + randomNum + " metal!");
					main.settlement.metal = main.settlement.metal + randomNum;
					main.JFrame.outputTextArea.append("\nYou now have " + main.settlement.metal + " metal");
					break;
				case 4:
					main.JFrame.outputTextArea.append("\nHow much ammo would you like to make?\nWith your current resources, you can make " + main.settlement.metal + " ammo.");
					userInput = scan.nextInt();
					if(main.settlement.metal/userInput >= 1)
					{
						main.settlement.metal = main.settlement.metal - userInput;
						main.settlement.ammo = main.settlement.ammo + userInput;
						main.JFrame.outputTextArea.append("\nYou have made " + userInput + " ammo, you now have " + main.settlement.ammo + " ammo.");
					}
					else
					{
						main.JFrame.outputTextArea.append("\nYou do not have enough metal, please choose a different option");
						idle(partyPosition);
					}
    				break;
    			default:
    				break;
			}
		}
		else 
		{
			defaultTasks(partyPosition);
		}
	}
}
