package jetclicker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player implements MouseListener{
    private Integer score;
    private String nom;

    public void scoreUp(){
        this.score=this.score+1;
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
        Scene.objListAv.avionClicke(e.getX(), e.getY());
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