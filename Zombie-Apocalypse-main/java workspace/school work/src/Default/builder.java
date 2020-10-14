package Default;

public class builder extends survivor
{
	public static JFrame JFrame = new JFrame();

	public builder()
	{
		role = "Builder";
		scavenging = 1;
    	combatStrength = 2;
    	foodConsumption = 5;
	}

    // BUILDER IDLE TASKS
	public void idle(int partyPosition)
	{
		main.JFrame.outputTextArea.append("\n\nWhat would you like your builder to do.");
    	main.JFrame.outputTextArea.append("\n1) Scavenge\n2) Find timber\n3) Mining");
		if(main.settlement.wood >=10)
		{
			main.JFrame.outputTextArea.append("\n4) Build a house");
    			if(main.settlement.wood >= 20 && !main.settlement.workshop)
    			{
					main.JFrame.outputTextArea.append("\n5) Build a workshop");
					//#region Builder Tasks (Up to task 5)
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
							main.settlement.houses = main.settlement.houses + 1;
							main.settlement.wood = main.settlement.wood - 10;
							main.JFrame.outputTextArea.append("\nYou have built another house. You now have " + main.settlement.houses + " houses.");
    						break;
    					case 5:
							main.settlement.workshop = true;
							main.settlement.wood = main.settlement.wood - 20;
							main.JFrame.outputTextArea.append("\nYou have built the workshop!");
    						break;
    					default:
    						break;
					}
					//#endregion
				}
				else
				{
					//#region Builder Tasks (Up to option 4)
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
							main.settlement.houses = main.settlement.houses + 1;
							main.settlement.wood = main.settlement.wood - 10;
							main.JFrame.outputTextArea.append("\nYou have built another house. You now have " + main.settlement.houses + " houses.");
    						break;
    					default:
    						break;
					}
					//#endregion
				}
				
		}
		else 
		{
			defaultTasks(partyPosition);
		}
	}

}
