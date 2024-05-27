package jetclicker;

import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

import jetclicker.openskynetwork.api.OpenSkyApi;
import jetclicker.openskynetwork.api.OpenSkyApi.BoundingBox;
import jetclicker.openskynetwork.model.OpenSkyStates;
import jetclicker.openskynetwork.model.StateVector;    

public class Gestionnaire_avion {
    private ArrayList<Avion> liste_avion = new ArrayList<Avion>();
    private Fenetre tab;
    private Random rand;

    // carte europe = {A:{lat:37.5,lon:-18.50} B:{lat:53.50,lon:23.00}}
    private final double Alat = 37.50;
    private final double Alon = -18.50;
    private final double Blat = 53.50;
    private final double Blon = 23.00;

/**
 * Créée n avions dans la fenetre tabF
 * 
 * @param n Le nombre d'avions à crééer
 * @param tabF La fenetre
 */
    public Gestionnaire_avion(int n, Fenetre tabF){
        this.tab = tabF;
    }

/**
 * Renvoie la liste d'avion.
 * 
 * @return la liste de n avions
 */

    public ArrayList<Avion> getListeAvion(){
        return liste_avion;
    }

    public ArrayList<StateVector> creeListeAvionApi() {
        try {
            OpenSkyApi api = new OpenSkyApi("Dystog", "@JetClicker02");
            OpenSkyStates os = api.getStates(0, null, new BoundingBox(Alat, Blat, Alon, Blon));
            if (os.getStates() != null) { // si des avions sont présent sur la carte, et qu'il y a assez d'avion sur la zone
                ArrayList<StateVector> liste_avions_api_utilisable = new ArrayList<StateVector>(); // Liste des avions retenu
                for (StateVector avion : os.getStates()) { // Parcours la liste des avions récuperé pour seulement garder ceux interressant
                    if (avion.getCallsign() != null && avion.getHeading() != null && (avion.getVelocity() != null && avion.getVelocity() > 100) && avion.getLongitude() != null && avion.getLatitude() != null) { // si l'avion à les informations nécessaire
                        liste_avions_api_utilisable.add(avion);
                    }
                }
                System.out.println("liste_avions_api_utilisable: "+liste_avions_api_utilisable.size());
                return liste_avions_api_utilisable;
            } else { // si il n'y a pas d'avion sur la carte IRL
                System.out.println("liste_avions_api_utilisable: null");
                return null;
            }
        } catch (IOException e) { // si l'accèes à l'api renvoie une erreur
            System.out.println("liste_avions_api_utilisable: null, erreur: "+e);
            return null;
        }
    }

    public void creeAvions(int nb_avion, ArrayList<StateVector> liste_avions_api_utilisable) {
        rand = new Random();
        for (int i=0; i<nb_avion;i++) {
            Avion new_avion;
            if (liste_avions_api_utilisable != null && liste_avions_api_utilisable.size() > 0) { // si il est possible d'avoir des avions api
                int indice_avion_api = rand.nextInt(liste_avions_api_utilisable.size()); // Récupere un avion aléatoire dans la liste d'avion api (pour pas avoir les même entre 2 game)
                StateVector avion = liste_avions_api_utilisable.get(indice_avion_api);
                new_avion = new Avion(false,"",Math.toRadians(avion.getHeading()+270),0,((int)((avion.getLongitude()-Alon)*tab.getLongueur()/(Blon-Alon)))-15,((int)(tab.getLargueur()-(avion.getLatitude()-Alat)*tab.getLargueur()/(Blat-Alat)))-15);
                liste_avions_api_utilisable.remove(indice_avion_api);
            } else {
                new_avion = new Avion(false,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
            }
            liste_avion.add(new_avion);
        }
    }

    public void bouger_Avions(){
        ArrayList<Avion> tempavion = new ArrayList<Avion>(liste_avion);
        for (Avion avion : tempavion) {
            avion.deplacement();
            //avionSorti(avion); J'ai enlevé ça pour bien vérifier si l'avion correspond à celui IRL
            //randomOrientation(avion, liste_avion.size()*20); Idem
        }
    }

    public void avionClicke(int x, int y){
        ArrayList<Avion> tempavion = new ArrayList<Avion>(liste_avion);
        for (Avion avion : tempavion) {
            if (x >= avion.positionX()-5 && x <= avion.positionX() + 30 && y >= avion.positionY()-5 && y <= avion.positionY() + 30){
                Explosion exp = new Explosion(avion.getX(), avion.getY());
                Scene.liste_Explosion.add(exp);
                if (avion.est_jet == false) {
                    Gestionnaire_Niveau.getGestionnaire_Niveau().perduDoncRestart();
                }
                avion.changerAvion(false,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
            }
        }

    }

/**
 * Vérifie si l'avion est sorti de la carte.
 * Si oui, il est alors réinitialisé et devient un nouvel avion avec de nouveaux paramètres.
 * 
 * @param avion L'avion en cours de vérification
 */

    public void avionSorti(Avion avion){
        if (tab.getLongueur() < avion.positionX() || tab.getLargueur() < avion.positionY() || 0 > avion.positionX() || 0 > avion.positionY()) {
            avion.changerAvion(avion.getPrivate(),"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
        }

    }

/**
 * Réinitialise tout les avions dans la liste d'avions en leur donnant de nouveaux paramètres aléatoires.
 */

    public void changerToutAvion(){
        for (Avion avion : liste_avion) {
            avion.changerAvion(false,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
        }
    }

/**
 * Rends n nombre d'avions privés dans la liste d'avions.
 * 
 * @param nombre Le nombre d'avions à modifier pour en faire des jets privés
 */

    public void creeJet(int nombre){
        for (int i = 0; i < nombre; i++) {
            liste_avion.get(i).setPrivate(true);
        }
    }

/**
 * L'avion a une certaine chance de changer d'orientation aléatoirement. 
 * Plus il y a d'avions sur la carte, plus cette chance est grande.
 * 
 * @param avion L'avion concerné
 * @param chance Taux de chance
 */

    public void randomOrientation(Avion avion, int chance){
        if (rand.nextInt(liste_avion.size()+chance) == 1){
            avion.setOrientation(rand.nextDouble()*2*Math.PI-Math.PI);
        }
    }
}
