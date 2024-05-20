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
/**
 * Créée n avions dans la fenetre tabF
 * 
 * @param n Le nombre d'avions à crééer
 * @param tabF La fenetre
 */
    public Gestionnaire_avion(int n, Fenetre tabF){
        this.tab = tabF;
        creeAvions(n);
    }

/**
 * Créé un nombre n d'avions avec chacun des paramètres aléatoires puis les ajoutent a la liste d'avionsà afficher.
 * 
 * @param n Un int représentant le nombre d'avions à crééer puis ajouter à la liste
 */

    public void creeAvions(int n){
        for (int i=0; i<n;i++) {
            rand = new Random();
            Avion n_avion = new Avion(false,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
            liste_avion.add(n_avion);
        }
    }

/**
 * Renvoie la liste d'avion.
 * 
 * @return la liste de n avions
 */

    public ArrayList<Avion> getListeAvion(){
        return liste_avion;
    }

    public ArrayList<StateVector> fetchApi(int nb_avion, double taux_avion_api, double taux_jet) {
        try {
            OpenSkyApi api = new OpenSkyApi("Dystog", "@JetClicker02");
            OpenSkyStates os = api.getStates(0, null, new BoundingBox(40.6, 50.0, -9.6, 17.4)); // carte europe = {A:{lat:40.6,lon:-9.6} B:{lat:50.0,lon:17.4}}
            if (os.getStates() != null && os.getStates().size() > nb_avion*taux_avion_api) { // si des avions sont présent sur la carte, et qu'il y a assez d'avion sur la zone
                ArrayList<StateVector> liste_avions_api = new ArrayList<StateVector>(); // Liste des avions retenu
                int i = 0;
                for (StateVector avion : os.getStates()) { // Parcours la liste des avions récuperé pour seulement garder ceux interressant
                    if (avion.getCallsign() != null && avion.getHeading() != null && (avion.getVelocity() != null && avion.getVelocity() > 100) && avion.getLongitude() != null && avion.getLatitude() != null) { // si l'avion à les informations nécessaire
                        liste_avions_api.add(avion);
                        i++;
                    }
                }
                System.out.println("nombre d'avion: "+i);
                return liste_avions_api;
            } else { // si il n'y a pas d'avion sur la carte
                System.out.println("nombre d'avion: 0");
                return null;
            }
        } catch (IOException e) { // si l'accèes à l'api renvoie une erreur
            System.out.println("nombre d'avion: 0 erreur: "+e);
            return null;
        }
    }

    public void creeListeAvions(int nb_avion, double taux_avion_api, double taux_jet, ArrayList<StateVector> liste_avions_api){
        rand = new Random();
        for (int i=0; i<nb_avion;i++) {
            if (liste_avions_api != null && (double) i/nb_avion < taux_avion_api) { // Vérifie si il y'a besoin d'avion issue de l'api
                int indice_avion_api = rand.nextInt(liste_avions_api.size()); // Récupere un aion aléatoire dans la liste d'avin api
                creeAvions(true,(double) i/nb_avion < taux_jet, liste_avions_api.get(indice_avion_api));
                liste_avions_api.remove(indice_avion_api);
            } else {
                creeAvions(false,(double) i/nb_avion < taux_jet, null);
            }
        }
    }

    public void creeAvions(boolean is_api, boolean is_jet, StateVector avion) {
        if (is_api) {
            System.out.println(avion.getCallsign()+" ("+avion.getLongitude()+"="+(int)((avion.getLongitude()-(-9.6))*tab.getLongueur()/((17.4)-(-9.6)))+" "+avion.getLatitude()+"="+(int)(tab.getLargueur()-(avion.getLatitude()-40.6)*tab.getLargueur()/(50.0-40.6))+") "+avion.getVelocity()+"="+avion.getVelocity()/64+" "+(avion.getHeading())+"="+Math.toRadians(avion.getHeading()-180)+"="+(Math.toDegrees(Math.toRadians(avion.getHeading()-180))+360)%360);
            Avion new_avion = new Avion(true,is_jet,avion.getCallsign(),Math.toRadians(avion.getHeading()-180),0,(int)((avion.getLongitude()-(-9.6))*tab.getLongueur()/((17.4)-(-9.6))),(int)(tab.getLargueur()-(avion.getLatitude()-40.6)*tab.getLargueur()/(50.0-40.6)));
            liste_avion.add(new_avion); // faudra penser à remettre la vitesse de l'avion
        } else {
            rand = new Random();
            Avion new_avion = new Avion(false,is_jet,"",rand.nextDouble()*2*Math.PI-Math.PI,rand.nextInt(2)+1,rand.nextInt((tab.getLongueur()-20)+10),rand.nextInt((tab.getLargueur()-20)+10));
            liste_avion.add(new_avion);
        }
    }

    public void bouger_Avions(){
        ArrayList<Avion> tempavion = new ArrayList<Avion>(liste_avion);
        for (Avion avion : tempavion) {
            avion.deplacement();
            //avionSorti(avion); J'ai enlevé ça pour bien vérifier si l'avion match celui IRL
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
