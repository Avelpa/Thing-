
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
    
    
    public Fade(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        back = genRandomColor();
        front = back;
    }

    private Color genRandomColor()
    {
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        
        Color color = new Color(r, g, b, 255);
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
        front = genRandomColor();
        started = true;
        frontAlpha = 255;
    }

    @Override
    public void go() {
        frontAlpha -= 0.2;
        if (frontAlpha <= 0)
        {
            frontAlpha = 0;
        }
        front = new Color(front.getRed(), front.getGreen(), front.getBlue(), (int)frontAlpha);
    }
}

