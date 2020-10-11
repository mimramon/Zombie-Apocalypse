package Default;

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
		System.out.println("\nWhat would you like your blacksmith to do.");
    	System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
		if(main.settlement.metal >0 && main.settlement.workshop)
    	{
			System.out.println("4) Make ammo");
    		userInput = scan.nextInt();
    		switch (userInput) 
    		{
    			case 1:
    				break;
    			case 2:
					main.settlement.wood = main.settlement.wood + rand.nextInt(Default.main.partySize * 2);
					System.out.println("You now have " + main.settlement.wood + " wood");
    				break;
    			case 3:
					randomNum = rand.nextInt(Default.main.partySize * 2);
					System.out.println("You have mined " + randomNum + " metal!");
					main.settlement.metal = main.settlement.metal + randomNum;
					System.out.println("You now have " + main.settlement.metal + " metal");
					break;
				case 4:
					System.out.println("How much ammo would you like to make?\nWith your current resources, you can make " + main.settlement.metal + " ammo.");
					userInput = scan.nextInt();
					if(main.settlement.metal/userInput >= 1)
					{
						main.settlement.metal = main.settlement.metal - userInput;
						main.settlement.ammo = main.settlement.ammo + userInput;
						System.out.println("You have made " + userInput + " ammo, you now have " + main.settlement.ammo + " ammo.");
					}
					else
					{
						System.out.println("You do not have enough metal, please choose a different option");
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
