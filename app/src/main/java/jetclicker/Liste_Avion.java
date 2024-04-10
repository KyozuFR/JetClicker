package jetclicker;

import java.util.ArrayList;
import java.util.Random;    

public class Liste_Avion {
    private ArrayList<Avion> liste_avion = new ArrayList<Avion>();
    private Fenetre tab;
    private Random rand;

    public Liste_Avion(int n, Fenetre tabF){
        this.tab = tabF;
        creeAvions(n);
    }
    public void creeAvions(int n){
        for (int i=0; i<n;i++) {
            rand = new Random();
            Avion n_avion = new Avion(true,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
            liste_avion.add(n_avion);
        }
    }

    public ArrayList<Avion> getListeAvion(){
        return liste_avion;
    }

    public void bouger_Avions(){
        ArrayList<Avion> tempavion = new ArrayList<Avion>(liste_avion);
        for (Avion avion : tempavion) {
            avion.deplacement();
            avionSorti(avion);
        }
    }

    public void avionClicke(int x, int y){
        ArrayList<Avion> tempavion = new ArrayList<Avion>(liste_avion);
        for (Avion avion : tempavion) {
            if (x >= avion.positionX()-5 && x <= avion.positionX() + 30 && y >= avion.positionY()-5 && y <= avion.positionY() + 30){
                avion.changerAvion(true,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
            }
        }

    }
    public void avionSorti(Avion avion){
        if (tab.getLongueur() < avion.positionX() || tab.getLargueur() < avion.positionY() || 0 > avion.positionX() || 0 > avion.positionY()) {
            avion.changerAvion(true,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
        }

    }
}
