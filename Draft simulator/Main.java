import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Main 
{
    public static void main(String[] args) 
    {
        setupGUI();
        addCardsToGrid();
    }

    public class Card
    {
        String name;
        Icon image;
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

    static public void addCardsToGrid()
    {
        int i = 0;
        for(Card card : Pack)
        {
            GUI.add(new JButton("card " + i, Pack.get(i).image));
            i++;
        }
        GUI.pack();
    }
}
