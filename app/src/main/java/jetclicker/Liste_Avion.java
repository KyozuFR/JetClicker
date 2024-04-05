package jetclicker;

import java.util.ArrayList;
import java.util.Random;    

public class Liste_Avion {
    private ArrayList<Avion> liste_avion = new ArrayList<Avion>();

    public Liste_Avion(){
        for (int i=0; i<10;i++) {
            Random rand = new Random();
            Avion n_avion = new Avion(true,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(20)+1,800.0,400.0);
            liste_avion.add(n_avion);
        }
        //System.out.println(liste_avion);
    }

    public ArrayList<Avion> getListeAvion(){
        return liste_avion;
    }

    public void bouger_Avions(){
        for (int i=0; i<10;i++) {
            //System.out.println(liste_avion.get(i) + " " + liste_avion.get(i).orientation + " " + liste_avion.get(i).vitesse);
            liste_avion.get(i).deplacement();
            //System.out.println(liste_avion.get(i).positionX() + " " + liste_avion.get(i).positionY());
        }
    }
}
