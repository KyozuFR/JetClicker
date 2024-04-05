package jetclicker;

public class Tick implements Runnable{
    private final int pause = 300;

    @Override
    public void run(){
        while (true) {
            Fenetre.scene.repaint();
            try{
                Thread.sleep(pause);
            } catch (InterruptedException e){}
            
        }
    }

}
