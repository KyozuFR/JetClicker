package jetclicker;

public class Tick implements Runnable{
    private final int pause = 41;

    @Override
    public void run(){
        while (true) {
            Scene.getScene().repaint();
            try{
                Thread.sleep(pause);
            } catch (InterruptedException e){}
            
        }
    }

}
