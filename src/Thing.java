
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
public abstract class Thing {
    
    protected int x, y;
    protected boolean started;
    
    protected Thing(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public abstract void draw(Graphics g);
    
    public abstract void click(Point clickPoint);
    
    protected abstract void start();
    
    public boolean hasStarted()
    {
        return started;
    }
    
    public abstract void go();
    
}
