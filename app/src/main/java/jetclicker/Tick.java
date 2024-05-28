package jetclicker;
/**
 * Classe qui s'occupe du tick du temps.
 */
public class Tick implements Runnable{
    private final int pause = 41;
    //Sans volatile, le changement de boolean n'est pas lu
    private volatile boolean tickstop = false;

    @Override
    public void run(){
        while (true) {
            if (tickstop) {
                Scene.getScene().repaint();
                try{
                    Thread.sleep(pause);
                } catch (InterruptedException e){}  
                //System.out.println("r");
            }
            
        }
    }
    public void start(){
        tickstop = true;
    }
    public void stop(){
        tickstop = false;
    }

}
