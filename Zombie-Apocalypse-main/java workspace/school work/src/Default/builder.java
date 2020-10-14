public class builder extends survivor
{
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
		System.out.println("\nWhat would you like your builder to do.");
    	System.out.println("1) Scavenge\n2) Find timber\n3) Mining");
		if(main.settlement.wood >=10)
		{
			System.out.println("4) Build a house");
    			if(main.settlement.wood >= 20 && !main.settlement.workshop)
    			{
					System.out.println("5) Build a workshop");
					//#region Builder Tasks (Up to task 5)
    				userInput = scan.nextLine();
    				while(!(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4") || userInput.equals("5")))
    	    		{
    	    			System.out.println("Please enter a valid answer");
    	    			userInput = scan.nextLine();
    	    		}
    				switch (Integer.parseInt(userInput)) 
    				{
    					case 1:

    						break;
    					case 2:
							main.settlement.wood = main.settlement.wood + rand.nextInt(main.partySize * 2);
							System.out.println("You now have " + main.settlement.wood + " wood");
    						break;
    					case 3:
							randomNum = rand.nextInt(main.partySize * 2);
							System.out.println("You have mined " + randomNum + " metal!");
							main.settlement.metal = main.settlement.metal + randomNum;
							System.out.println("You now have " + main.settlement.metal + " metal");
    						break;
    					case 4:
							main.settlement.houses = main.settlement.houses + 1;
							main.settlement.wood = main.settlement.wood - 10;
							System.out.println("You have built another house. You now have " + main.settlement.houses + " houses.");
    						break;
    					case 5:
							main.settlement.workshop = true;
							main.settlement.wood = main.settlement.wood - 20;
							System.out.println("You have built the workshop!");
    						break;
    					default:
    						break;
					}
					//#endregion
				}
				else
				{
					//#region Builder Tasks (Up to option 4)
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
							main.settlement.wood = main.settlement.wood + rand.nextInt(main.partySize * 2);
							System.out.println("You now have " + main.settlement.wood + " wood");
    						break;
    					case 3:
							randomNum = rand.nextInt(main.partySize * 2);
							System.out.println("You have mined " + randomNum + " metal!");
							main.settlement.metal = main.settlement.metal + randomNum;
							System.out.println("You now have " + main.settlement.metal + " metal");
    						break;
    					case 4:
							main.settlement.houses = main.settlement.houses + 1;
							main.settlement.wood = main.settlement.wood - 10;
							System.out.println("You have built another house. You now have " + main.settlement.houses + " houses.");
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
