
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
public class Bounce extends Thing{

    private double width, height;
    private final int ORIGINAL_WIDTH;
    private final int ORIGINAL_HEIGHT;
    private double downRate = 0;
    private double jumpRate = 0;
    private double dy, dx;
    private final int initialFloor;
    private boolean landed = false;
    
    public Bounce(int x, int y, int width, int height) {
        super(x, y);
        ORIGINAL_WIDTH = width;
        ORIGINAL_HEIGHT = height;
        this.width = width;
        this.height = height;
        dy = y;
        dx = x;
        initialFloor = y + height;
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect((int)dx, (int)dy, (int)width, (int)height);
    }

    @Override
    public void click(Point clickPoint) {
        if (!started)
        {
            start();
        }
    }

    @Override
    protected void start() {
        started = true;
        downRate = 0.997;
    }

    @Override
    public void go() {
        
        if (height <= ORIGINAL_HEIGHT*2d/3)
        {
            downRate = 1.01;
        }
        if (height >= ORIGINAL_HEIGHT*1.1)
        {
            if (jumpRate == 0)
            {
                jumpRate = -1;
            }
            //started = false;
        }
        else
        {
            dy += height-height*downRate;
            height *= downRate;
            dx -= (width-width*downRate)/2;
            width *= (2-downRate);
        }
        if (dy+height > initialFloor && jumpRate != 0)
        {
            dy = initialFloor - height;
            started = false;
        }
        if (dy+height <= initialFloor && !landed)
        {
            dy += jumpRate;
            if (jumpRate != 0)
            {
                jumpRate += 0.004;
            }
        }
    }
}
