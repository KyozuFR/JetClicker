package jetclicker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe qui contrôle le Joueur, son nom et son score.
 */

public class Player implements MouseListener{
    private int score;
    private String nom;
    private static Player player;

/**
 * Créée un joueur avec un score de 0 et un nom à remplir après.
 */

    private Player(){
        this.score = 0;
        this.nom = "";
    }
    
/**
 * Renvoie le joueur actif.
 * 
 * @return
 */

    public static Player getPlayer(){
        if (player == null){
            player = new Player();
        }
        return player;
    }
    
/**
 * Augmente le score du joueur de 1.
 */

    public void scoreUp(){
        this.score=this.score+10;
    }
    
/**
 * Diminue le score du joueur de 1.
 */

    public void scoreDown(){
        this.score=this.score-1;
    }

/**
 * Renvoie le score du joueur.
 * 
 * @return Le score du joueur en integer
 */

    public int getScore(){
        return this.score;
    }

/**
 * Modifie le nom du joueur.
 * 
 * @param nom Le nom du joueur en String
 */

    public void setNom(String nom){
        this.nom=nom;
    }

/**
 * Renvoie le nom du joueur.
 * 
 * @return Le nom du joueur en String
 */

    public String getNom(){
        return this.nom;
    }

/**
 * Envoie la position du click de la souris pour vérifier si ce click a touché un avion.
 * 
 * @param e Le click de la souris
 */

    @Override
    public void mouseClicked(MouseEvent e) {
        Scene.getScene().getAvionAff().avionClicke(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}