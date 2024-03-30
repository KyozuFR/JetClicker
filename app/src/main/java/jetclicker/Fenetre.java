package jetclicker;

import javax.swing.JFrame;

public class Fenetre extends JFrame{

    private static Scene scene;

    public Fenetre(){

        // Création de la fenetre
        super();
        this.setTitle("Jetclicker");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,150,400,400);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);

        
        // Implementation de la scene
        scene = new Scene();
        this.setContentPane(scene);
    }

}
