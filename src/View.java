
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class View extends JComponent implements MouseListener{
    
    private JFrame window;
    private final int WIDTH, HEIGHT;
    
    private Point clickPoint;
    
    private Thing[] things;
    
    public View(Thing[] things, int width, int height)
    {
        WIDTH = width;
        HEIGHT = height;
        window = new JFrame("sdfsdf");
        window.setVisible(true);
        window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(this);
        
        this.addMouseListener(this);
        
        this.things = things;
        
        clickPoint = new Point(-100, -100);
    }
    
    public int getViewWidth()
    {
        return WIDTH;
    }
    public int getViewHeight()
    {
        return HEIGHT;
    }
    
    public boolean clicked()
    {
        return window.contains(clickPoint);
    }
    
    public void unclick()
    {
        clickPoint.setLocation(-100, -100);
    }
    
    public Point getMouseClick()
    {
        return clickPoint;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        for (Thing thing: things)
        {
            if (thing != null)
            {
                thing.draw(g);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickPoint.setLocation(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
