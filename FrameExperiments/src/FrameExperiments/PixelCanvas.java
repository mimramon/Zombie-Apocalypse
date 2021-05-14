package FrameExperiments;
import java.awt.*;

public class PixelCanvas extends Canvas
{
    public PixelCanvas()
    {

    }
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    @Override
    public void paint(Graphics g) 
    {
        for(int x = 0; x < WIDTH; x++) 
        {
            for(int y = 0; y < HEIGHT; y++) 
            {
                g.setColor(calculateColour());
                g.drawLine(x, y, x, y);
            }
        }
    } 
    
    Color calculateColour()
    {
        return new Color(100, 50, 75);
    }
}
