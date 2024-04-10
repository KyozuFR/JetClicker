package jetclicker;

import javax.swing.JFrame;

public class Fenetre extends JFrame{

    //beaucoup de variable static car on a fait l'erreur au début de crée les classe directement dans d'autre classe au lieu de toutes les crée dans le main avec pour arguments les autres classes
    //Ce sera bientot réglé
    public static Scene scene;
    public static Player joueur;

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
        joueur = new Player();
        this.addMouseListener(joueur);

        
        // Implementation de la scene
        scene = new Scene();
        this.setContentPane(scene);
    }
    public int getLongueur(){
        return this.getWidth();
    }
    public int getLargueur(){
        return this.getHeight();
    }

}
