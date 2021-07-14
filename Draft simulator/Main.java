import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public static class Main 
{
    public static void main(String[] args) 
    {
        setupGUI();
        setupPack();
        addCardsToGrid();
    }

    public class Card
    {
        String name;
        Icon image;
        public Card(String imagePath)
        {
            try
            {
                image = new Icon(imagePath);
            }
            catch(IOException ex){}
            
        }
    }

    static public ArrayList<Card> Pack = new ArrayList<Card>();
    
    static public JFrame GUI;

    static public void setupGUI()
    {
        GUI = new JFrame();
        GUI.setVisible(true);
        GridLayout gridLayout = new GridLayout(3,5);
        GUI.setLayout(gridLayout);
    }

    static void setupPack()
    {
        for(int i = 0;  i <= 15; i++)
        {
            Pack.add(new Card("P:/Desktop/8 values result"));
        }
    }

    static public void addCardsToGrid()
    {
        int i = 0;
        for(Card card : Pack)
        {
            GUI.add(new JButton("card " + i, Pack.get(i).image));
            i++;
        }
    }
}
