package jetclicker;

import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

import jetclicker.openskynetwork.api.OpenSkyApi;
import jetclicker.openskynetwork.api.OpenSkyApi.BoundingBox;
import jetclicker.openskynetwork.model.OpenSkyStates;
import jetclicker.openskynetwork.model.StateVector;    

public class Liste_Avion {
    private ArrayList<Avion> liste_avion = new ArrayList<Avion>();
    private Fenetre tab;
    private Random rand;

    public Liste_Avion(int nb_avion, double taux_avion_api, double taux_jet, Fenetre tabF){
        this.tab = tabF;
        if (taux_avion_api > 0.0) { // si le joueur veux des avions issues de l'api
            try {
                OpenSkyApi api = new OpenSkyApi("Dystog", "@JetClicker02");
                OpenSkyStates os = api.getStates(0, null, new BoundingBox(40.6, 50.0, -9.6, 17.4)); // carte europe = {A:{lat:40.6,lon:-9.6} B:{lat:50.0,lon:17.4}}
                if (os.getStates() != null && os.getStates().size() > nb_avion*taux_avion_api) { // si des avions sont présent sur la carte, et qu'il y a assez d'avion sur la zone
                    ArrayList<StateVector> liste_avions_api = new ArrayList<StateVector>();
                    int i = 0;
                    for (StateVector avion : os.getStates()) {
                        if (avion.getCallsign() != null && avion.getHeading() != null && (avion.getVelocity() != null && avion.getVelocity() > 100) && avion.getLongitude() != null && avion.getLatitude() != null) { // si l'avion à les informations nécessaire
                            liste_avions_api.add(avion);
                            i++;
                        }
                    }
                    System.out.println("nombre d'avion: "+i);
                    genererListeAvions(nb_avion, taux_avion_api, taux_jet, liste_avions_api);
                } else { // si il n'y a pas d'avion sur la carte
                    System.out.println("nombre d'avion: 0");
                    genererListeAvions(nb_avion, 0.0, taux_jet, null);
                }
            } catch (IOException e) { // si l'accèes à l'api renvoie une erreur
                System.out.println("nombre d'avion: 0 erreur: "+e);
                genererListeAvions(nb_avion, 0.0, taux_jet, null);
            }
        } else { // si le joueur ne veux pas d'avion issue de l'api
            genererListeAvions(nb_avion, taux_avion_api, taux_jet, null);
        }
    }

    public ArrayList<Avion> getListeAvion(){
        return liste_avion;
    }

    public void genererListeAvions(int nb_avion, double taux_avion_api, double taux_jet, ArrayList<StateVector> liste_avions_api){
        rand = new Random();
        for (int i=0; i<nb_avion;i++) {
            if (liste_avions_api != null && (double) i/nb_avion < taux_avion_api) {
                int indice_avion_api = rand.nextInt(liste_avions_api.size());
                genererAvion(true,(double) i/nb_avion < taux_jet, liste_avions_api.get(indice_avion_api));
                liste_avions_api.remove(indice_avion_api);
            } else {
                genererAvion(false,(double) i/nb_avion < taux_jet, null);
            }
        }
    }

    public void genererAvion(boolean is_api, boolean is_jet, StateVector avion) {
        if (is_api) {
            System.out.println(avion.getCallsign()+" ("+avion.getLongitude()+"="+(int)((avion.getLongitude()-(-9.6))*tab.getLongueur()/((17.4)-(-9.6)))+" "+avion.getLatitude()+"="+(int)(tab.getLargueur()-(avion.getLatitude()-40.6)*tab.getLargueur()/(50.0-40.6))+") "+avion.getVelocity()+"="+avion.getVelocity()/64+" "+avion.getHeading()+"="+avion.getHeading()*(Math.PI/180));
            Avion new_avion = new Avion(true,is_jet,avion.getCallsign(),Math.toRadians(avion.getHeading()),0,(int)((avion.getLongitude()-(-9.6))*tab.getLongueur()/((17.4)-(-9.6))),(int)(tab.getLargueur()-(avion.getLatitude()-40.6)*tab.getLargueur()/(50.0-40.6)));
            liste_avion.add(new_avion);
        } else {
            rand = new Random();
            Avion new_avion = new Avion(false,is_jet,"",Math.toRadians(rand.nextInt(361)),rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
            liste_avion.add(new_avion);
        }
    }

    public void bougerAvions(){
        ArrayList<Avion> tempavion = new ArrayList<Avion>(liste_avion);
        for (Avion avion : tempavion) {
            avion.deplacement();
            //avionSorti(avion);
            //randomOrientation(avion, liste_avion.size()*20);
        }
    }

    public void avionCliquer(int x, int y){
        ArrayList<Avion> tempavion = new ArrayList<Avion>(liste_avion);
        for (Avion avion : tempavion) {
            if (x >= avion.positionX()-5 && x <= avion.positionX() + 30 && y >= avion.positionY()-5 && y <= avion.positionY() + 30){
                avion.changerAvion(false,true,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
            }
        }

    }
    public void avionSorti(Avion avion){
        if (tab.getLongueur() < avion.positionX() || tab.getLargueur() < avion.positionY() || 0 > avion.positionX() || 0 > avion.positionY()) {
            avion.changerAvion(false,true,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
        }

    }

    public void randomOrientation(Avion avion, int chance){
        if (rand.nextInt(liste_avion.size()+chance) == 1){
            avion.setOrientation(rand.nextDouble()*2*Math.PI-Math.PI);
        }
    }
}
