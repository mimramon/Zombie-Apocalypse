package FrameExperiments;
import java.util.*;
import javax.swing.*;

public class Main {

	public static enum WinType
	{
		MENU,
		GAME
	}

	public static Map<WinType, JFrame> windows = new HashMap<>(); //creates a dictionary for my windows

	public Main()
	{
		createWindow(WinType.MENU);
		while(isActive())
		{
			
		}
		System.out.println("terminated");
		System.exit(0);
	}

	public static void main(String[] args) 
	{
		new Main();
	}

	public boolean isActive()
	{
		boolean isOpen = false;
			for(Map.Entry<WinType, JFrame> entry : windows.entrySet())
			{
				JFrame win = entry.getValue();
				isOpen = win.isVisible();
				if(isOpen){return isOpen;}
			}	
		
		return isOpen;
	}

	public static void createWindow(WinType winType)
	{
		if(windows.containsKey(winType) && windows.get(winType).isVisible()){return;}
		else
		{
			if(windows.get(winType) == null)
			{
				switch(winType)
				{
					case GAME:
						windows.put(winType, new GameWindow());
						break;
					case MENU:
						windows.put(winType, new MenuWindow());
						break;
				}
			}
			else
			{
				windows.get(winType).setVisible(true);
			}
		}
	}
}