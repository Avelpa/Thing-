
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
public class Spin extends Thing{

    
    private final double restingAngle1;
    private Color color;
    private final double segmentLength;
    //private double angle1 = Math.toRadians(70), angle2 = Math.toRadians(110), angle3 = Math.toRadians(250), angle4 = Math.toRadians(290);
    private final double[] angles = new double[4];
    private double offset = 0d;
    private double speed;
    private final double minSpeed = 0.005;
    private final double maxSpeed = 0.05;
    private final double decrement = 999d/1000;
    
    int[] xs = new int[4];
    int[] ys = new int[4];
    
    public Spin(int x, int y, int width, int height) {
        super(x, y);
        
        segmentLength = Math.sqrt(Math.pow(width/2d,2) + Math.pow(height/2d, 2));
        setAngles(width/2d, height/2d);
        restingAngle1 = angles[0];
        updatePoints();
        
        color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(xs, ys, 4);
    }
    
    private void setAngles(double base, double height)
    {
        angles[0] = Math.atan2(height,base);
        angles[1] = Math.atan2(height,-base);
        angles[2] = Math.atan2(-height,-base);
        angles[3] = Math.atan2(-height,base);
    }

    @Override
    public void click(Point clickPoint) {
        
        {
            if (clickPoint.getX() >= getMin(xs) && clickPoint.getX() <= getMax(xs))
            {
                if (clickPoint.getY() >= getMin(ys) && clickPoint.getY() <= getMax(ys))
                {
                    start();
                }
            }
        }
    }
    
    private void updatePoints()
    {
        for (int i = 0; i < angles.length; i ++)
        {
            xs[i] = (int)(segmentLength*Math.cos(angles[i]+offset))+x;
            ys[i] = (int)(y-segmentLength*Math.sin(angles[i]+offset));
        }
    } 
           
    
    private int getMin(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        for (Integer i: nums)
        {
            if (i < min)
            {
                min = i;
            }
        }
        return min;
    }
    
    private int getMax(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        for (Integer i: nums)
        {
            if (i > max)
            {
                max = i;
            }
        }
        return max;
    }
    
    @Override
    protected void start() {
        started = true;
        speed = (Math.random()*maxSpeed+minSpeed);
    }

    @Override
    public void go() {
        if (speed > minSpeed)
        {
            offset += speed;
            speed *= decrement;
        }
        else if (offset%Math.toRadians(360) > minSpeed)
        {
            offset += minSpeed;
        }
        else
        {
            offset = 0;
            started = false;
        }
        updatePoints();
    }
    
}
