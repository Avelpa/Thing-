/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class MainLinked {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Thing[] things = {new Switch(100, 100), new Switch(300, 300)};
        Thing[] things = new Thing[100];
        for (int i = 0; i < things.length; i++)
        {
            things[i] = new Switch2(32+(i%10)*64, 32+(i/10)*64);
        }
        
        View view = new View(things);
        
        while (true)
        {
            if (view.clicked())
            {
                for (Thing thing: things)
                {
                    thing.click(view.getMouseClick());
                }
                view.unclick();
            }
            
            for (int i = 0; i < things.length; i ++)
            {
                if (things[i].hasStarted())
                {
                    things[i].go();
                }
                if (i < things.length-1)
                {
                    Switch2 pls = (Switch2)things[i];
                    if (pls.justFinished())
                    {
                        things[i+1].start();
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
