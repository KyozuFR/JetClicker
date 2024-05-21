package jetclicker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player implements MouseListener{
    private int score;
    private String nom;
    private static Player player;

    private Player(){
        this.score = 0;
        this.nom = "";
    }
    public static Player getPlayer(){
        if (player == null){
            player = new Player();
        }
        return player;
    }
    public void scoreUp(){
        this.score=this.score+10;
    }
    public void scoreDown(){
        this.score=this.score-1;
    }

    public int getScore(){
        return this.score;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public String getNom(){
        return this.nom;
    }

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