package jetclicker;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
    public Fenetre(){
        this.setTitle("Jetclicker");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,150,400,400);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
    }

}
