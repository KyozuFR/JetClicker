package jetclicker;

import java.util.ArrayList;
import java.util.Random;    

public class Liste_Avion {
    private ArrayList<Avion> liste_avion = new ArrayList<Avion>();

    public Liste_Avion(int n){
        for (int i=0; i<n;i++) {
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
        for (Avion avion : liste_avion) {
            avion.deplacement();
        }
    }
}
