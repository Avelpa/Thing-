
import java.awt.Dimension;
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
public class View extends JComponent{
    
    private JFrame window;
    private final int WIDTH = 640, HEIGHT = 480;
    
    public View()
    {
        window = new JFrame("sdfsdf");
        window.setVisible(true);
        window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(this);
    }
    
}
