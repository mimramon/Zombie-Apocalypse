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
		System.out.println("\nWhat would you like your medic to do.");
    	System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
		if((main.settlement.food >= 10) && main.settlement.workshop)
    	{
			System.out.println("4) Make meds");
			//#region Builder Tasks (Up to task 5)
    		userInput = scan.nextLine();
    		while(!(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4")))
    		{
    			System.out.println("Please enter a valid answer");
    			userInput = scan.nextLine();
    		}
    		switch (Integer.parseInt(userInput)) 
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
					// Code to make meds here
					System.out.println("How many meds would you like to make?\nWith your current resources, you can make " + main.settlement.food/10 + " meds.");
					userInput = scan.nextLine();
					while(!(main.settlement.food/(Integer.parseInt(userInput)*10) >= 1))
					{
						System.out.println("Please enter a valid number");
						userInput = scan.nextLine();
					}
					if(main.settlement.food/(Integer.parseInt(userInput)*10) >= 1)
					{
						main.settlement.food = main.settlement.food - (Integer.parseInt(userInput)*10);
						main.settlement.meds = main.settlement.meds + Integer.parseInt(userInput);
						System.out.println("You have made " + userInput + " meds, you now have " + main.settlement.meds + " meds.");
					}
					else
					{
						System.out.println("You do not have enough food, please choose a different option");
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
