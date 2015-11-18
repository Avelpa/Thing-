/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thing[] things = new Thing[300];
        
        int viewWidth = 700;
        int viewHeight = 700;
        
        things[0] = new Fade(0, 0, viewWidth, viewHeight);
        for (int i = 1; i < things.length; i ++)
        {
            int width = (int)(Math.random()*100 + 10);
            int height = (int)(Math.random()*100 + 10);
            int x = (int)(Math.random()*(viewWidth-width));
            int y = (int)(Math.random()*(viewHeight-height));
            things[i] = new Fade(x, y, width, height);
        }
        
        View view = new View(things, viewWidth, viewHeight);
        
        while (true)
        {
            if (view.clicked())
            {
                for (Thing thing: things)
                {
                    if (thing != null)
                    {
                        thing.click(view.getMouseClick());
                    }
                }
                view.unclick();
            }
            
            for (Thing thing: things)
            {
                if (thing != null)
                {
                    if (thing.hasStarted())
                    {
                        thing.go();
                    }
                }
            }
            view.repaint();
            
            try{
                Thread.sleep(1);
            }catch(Exception e){}
        }
        
    }
    
}
