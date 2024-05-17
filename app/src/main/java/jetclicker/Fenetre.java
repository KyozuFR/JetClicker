package jetclicker;

import javax.swing.JFrame;

public class Fenetre extends JFrame{

    //beaucoup de variable static car on a fait l'erreur au début de crée les classe directement dans d'autre classe au lieu de toutes les crée dans le main avec pour arguments les autres classes
    //Ce sera bientot réglé
    public Scene scene;
    public Player joueur;

    public Fenetre(){

        // Création de la fenetre
        super();
        this.setTitle("Jetclicker");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,800,800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        joueur = Player.getPlayer();
        this.addMouseListener(joueur);
        this.setVisible(true); //ligne pour définir les limites de l'écran
        

        
        // Implementation de la scene
        scene = Scene.getScene(this);
        this.setContentPane(scene);
    }
    public int getLongueur(){
        return this.getWidth();
    }
    public int getLargueur(){
        return this.getHeight();
    }

}
