public class blacksmith extends survivor
{
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
		main.windowOutput("\nWhat would you like your blacksmith to do.");
		main.windowOutput("1) Scavenge\n2) Find timber\n3) Mining");
		if(main.settlement.metal >0 && main.settlement.workshop)
    	{
			main.windowOutput("4) Make ammo");
    		userInput = scan.nextLine();
    		while(!(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4")))
    		{
    			main.windowOutput("Please enter a valid answer");
    			userInput = scan.nextLine();
    		}
    		switch (Integer.parseInt(userInput)) 
    		{
    			case 1:
    				break;
    			case 2:
					main.settlement.wood = main.settlement.wood + rand.nextInt(main.partySize * 2);
					main.windowOutput("You now have " + main.settlement.wood + " wood");
    				break;
    			case 3:
					randomNum = rand.nextInt(main.partySize * 2);
					main.windowOutput("You have mined " + randomNum + " metal!");
					main.settlement.metal = main.settlement.metal + randomNum;
					main.windowOutput("You now have " + main.settlement.metal + " metal");
					break;
				case 4:
					main.windowOutput("How much ammo would you like to make?\nWith your current resources, you can make " + main.settlement.metal + " ammo.");
					userInput = scan.nextLine();
					if(main.settlement.metal/Integer.parseInt(userInput) >= 1)
					{
						main.settlement.metal = main.settlement.metal - Integer.parseInt(userInput);
						main.settlement.ammo = main.settlement.ammo + Integer.parseInt(userInput);
						main.windowOutput("You have made " + userInput + " ammo, you now have " + main.settlement.ammo + " ammo.");
					}
					else
					{
						main.windowOutput("You do not have enough metal, please choose a different option");
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
