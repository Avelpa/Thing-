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
        
//        Thing[] things = {new Spin(100, 100, 50, 100), 
//        new Spin(150, 100, 50, 100),
//        new Spin(200, 100, 50, 100),
//        new Spin(250, 100, 50, 100),
//        new Spin(420, 60, 50, 100),
//        new Spin(500, 362, 70, 25),
//        new Spin(100, 400, 45, 45),
//        };
        Thing[] things = new Thing[100];
        int startWidth = 450;
        int startHeight = 450;
        for (int i = 0; i < things.length; i ++)
        {
            things[i] = new Spin(350,350,startWidth,startHeight);
            startWidth -= 5;
            startHeight -= 5;
            if (startWidth <= 0 || startHeight <= 0)
            {
                break;
            }
        }
        
        View view = new View(things);
        
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
