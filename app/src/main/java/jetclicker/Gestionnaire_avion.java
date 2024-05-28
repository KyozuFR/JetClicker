package jetclicker;

import java.util.ArrayList;
import java.util.Random;    

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

/**
 * Déplace tout les avions, vérifie si des avions sont sortis de la carte et fais qu'il y ait une chance qu'un avion change aléatoirement d'orientation.
 */

    public void bouger_Avions(){
        ArrayList<Avion> tempavion = new ArrayList<Avion>(liste_avion);
        for (Avion avion : tempavion) {
            avion.deplacement();
            avionSorti(avion);
            randomOrientation(avion, liste_avion.size()*20);
        }
    }

/**
 * Vérifie si la souris à cliqué sur un avion.
 * Si oui, il est alors réinitialisé et devient un nouvel avion avec de nouveaux paramètres.
 * 
 * @param x La coordonnée x du click de la souris en double
 * @param y La coordonnée y du click de la souris en double
 */

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
