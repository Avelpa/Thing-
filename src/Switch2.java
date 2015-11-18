
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
public class Switch2 extends Thing{

    private final int WIDTH = 64, HEIGHT = 10;
    private final double RESTING_ANGLE = Math.toRadians(25);
    private final double MAX_ANGLE = Math.toRadians(160);
    private double angle = RESTING_ANGLE;
    private final double RATE = 1.3;  
    private final double RADIUS = 50;
    
    private boolean justFinished = false;
    
    private final Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
    
    public Switch2(int x, int y)
    {
        super(x, y);
    }
    
    @Override
    public void draw(Graphics g) {
        //g.setColor(Color.RED);
        g.setColor(colors[(int)((angle-Math.toRadians(1))/MAX_ANGLE*colors.length)]);
        g.drawLine(x, y, x+(int)(RADIUS*Math.cos(angle)), y-(int)(RADIUS*Math.sin(angle)));
        g.fillOval(x+(int)(RADIUS*Math.cos(angle)-2), y-(int)(RADIUS*Math.sin(angle))-2, 4, 4);

        g.setColor(Color.BLACK);
        g.fillRect(x-WIDTH/2, y-HEIGHT/2, WIDTH, HEIGHT);
    }

    @Override
    public void click(Point clickPoint) {
        
        if (clickPoint.getY() <= y && clickPoint.getY() >= y-Math.sin(angle)*RADIUS)
        {
            if (Math.cos(angle) >= 0)
            {
                if (clickPoint.getX() >= x && clickPoint.getX() <= (x+Math.cos(angle)*RADIUS))
                {
                    start();
                }
            }
            else
            {
                if (clickPoint.getX() >= x+Math.cos(angle)*RADIUS && clickPoint.getX() <= x)
                {
                    start();
                }
            }
        }
    }
    
    @Override
    public void go() {
        angle -= Math.toRadians(RATE);
        if (angle < RESTING_ANGLE)
        {
            started = false;
            justFinished = true;
            angle = RESTING_ANGLE;
        }
    }
    public boolean justFinished()
    {
        if (justFinished)
        {
            justFinished = false;
            return true;
        }
        return false;
    }

    @Override
    protected void start() {
        angle = MAX_ANGLE;
        started = true;
        justFinished = false;
    }
    
}
