package jetclicker;

import java.time.Instant;
import java.time.Duration;

/**
 * Classe qui s'occupe des niveaux dans l'avancement du jeu.
 * Plus le niveau est élevé, plus il y aura d'avions privés à détruire.
 */

public class Gestionnaire_Niveau {
    private int nbNiv;
    private static Gestionnaire_Niveau gestionnaire_Niveau;
    private Tick tick;
    private Instant debut;
    private int tempmax;

    //privée car singleton
    private Gestionnaire_Niveau(){
        tempmax = 2000;
        nbNiv = 0;
        tick = new Tick(); 
        Thread x = new Thread(tick);
        Fenetre tab = new Fenetre();
        tab.setVisible(false); //pour actualiser la fenetre et avoir les limite de l'écran actualisé (c'est du bricolage)
        tab.setVisible(true);
        x.start();
    }

/**
 * Vérifie si un Gestionnaire_Niveau existe.
 * Si oui le renvoie.
 * Si non en créée un nouveau et le renvoi.
 * 
 * @return Un Gestionnaire_Niveau
 */

    //création du singleton
    public static Gestionnaire_Niveau getGestionnaire_Niveau(){
        if (gestionnaire_Niveau == null){
            gestionnaire_Niveau = new Gestionnaire_Niveau();
        }
        return gestionnaire_Niveau;
    }
/**
 * Va au niveau suivant si le joueur gagne, recommence sinon.
 */
    public void changerNiv(){
        tick.stop();
        nbNiv+= 1;
        if (nbNiv > 1) {
            Player.getPlayer().scoreUp();
        }
        niv(nbNiv);
    }

/**
 * Renvoie un booléen.
 * True si les jet privés doivent encore être affichés en rouge sur la carte.
 * False sinon.
 * Change selon les niveaux.
 * 
 * @return Un booléen
 */

    public boolean getDiffTemp(){
        Duration tempPasse = Duration.between(debut, Instant.now());
        return tempPasse.toMillis() < tempmax;
    }

/**
 * Renvoie un booléen.
 * True si les jet privés doivent encore être affichés en rouge sur la carte.
 * False sinon.
 * 
 * @return Un booléen
 */

    public boolean getTempCouleur(){
        Duration tempPasse = Duration.between(debut, Instant.now());
        return tempPasse.toMillis() < 500;
    }
/**
 * Utilisé quand la partie est perdue, relance donc le niveau.
 */
    public void perduDoncRestart(){
        tick.stop();
        Scene.getScene().getAvionAff().changerToutAvion();
        Player.getPlayer().scoreDown();
        niv(nbNiv);
    }

/**
 * Lance le jeu avec les paramètres du niveau actuel.
 * 
 * @param tempMaxTmp Le temps que les jets privés s'affichent en rouge au départ
 * @param nbAvions Le nombre d'avions total
 * @param nbJet Le nombre de jets privés parmi ces avions
 */

    public void templateNiv(int tempMaxTmp, int nbAvions, int nbJet){
        tempmax = tempMaxTmp;
        Scene.getScene().getAvionAff().creeAvions(nbAvions - Scene.getScene().getAvionAff().getListeAvion().size());
        Scene.getScene().getAvionAff().creeJet(nbJet);
        debut = Instant.now();
        tick.start();
    }
    
    
        
/**
 * S'occupe des paramètres de chaque niveaux.
 * Le nombre d'avions, le nombre de jets privés parmi les avions, et le temps donné pour voir les jets privés.
 * 
 * @param nb
 */
   
    public void niv(int nb){
        if (nb==1){
            templateNiv(2000,2,1);
        }
        if (nb==2){
            templateNiv(5000,10,2);
        }
        if (nb==3){
            templateNiv(5000,10,5);
        }

    }
    
}
