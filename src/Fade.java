
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Fade extends Thing{

    private int width, height;
    private Color back;
    private Color front;
    private double frontAlpha = 0;
    private int startTimer = 0;
    private int startTime;
    
    
    public Fade(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        back = genRandomColor(false);
        front = back;
        started = true;
        startTime = (int)(Math.random()*200);
    }

    private Color genRandomColor(boolean transparent)
    {
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        
        Color color = null;
        if (transparent)
        {
            color = new Color(r, g, b, 0);
        }
        else
        {
            color = new Color(r, g, b, 255);
        }
        return color;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(back);
        g.fillRect(x, y, width, height);
        g.setColor(front);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void click(Point clickPoint) {
        if (clickPoint.getX() >= x && clickPoint.getX() <= x + width)
        {
            if (clickPoint.getY() >= y && clickPoint.getY() <= y + height)
            {
                start();
            }
        }
    }

    @Override
    protected void start() {
        back = new Color(front.getRed(), front.getGreen(), front.getBlue());
        front = genRandomColor(true);
        started = true;
        frontAlpha = 0;
        startTimer = startTime;
    }

    @Override
    public void go() {
        if (startTimer >= startTime)
        {
            frontAlpha += 0.2;
            if (frontAlpha >= 255)
            {
                frontAlpha = 255;
                back = front;
                start();
            }
            front = new Color(front.getRed(), front.getGreen(), front.getBlue(), (int)frontAlpha);
        }
        else
        {
            startTimer ++;
            if (startTimer >= startTime)
            {
                start();
            }
        }
    }
}
