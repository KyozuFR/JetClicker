package jetclicker;

import java.time.Instant;
import java.time.Duration;

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

    //création du singleton
    public static Gestionnaire_Niveau getGestionnaire_Niveau(){
        if (gestionnaire_Niveau == null){
            gestionnaire_Niveau = new Gestionnaire_Niveau();
        }
        return gestionnaire_Niveau;
    }

    public void changerNiv(){
        tick.stop();
        nbNiv+= 1;
        if (nbNiv > 1) {
            Player.getPlayer().scoreUp();
        }
        niv(nbNiv);
    }
    public boolean getDiffTemp(){
        Duration tempPasse = Duration.between(debut, Instant.now());
        return tempPasse.toMillis() < tempmax;
    }

    public boolean getTempCouleur(){
        Duration tempPasse = Duration.between(debut, Instant.now());
        return tempPasse.toMillis() < 500;
    }

    public void perduDoncRestart(){
        tick.stop();
        Scene.getScene().getAvionAff().changerToutAvion();
        Player.getPlayer().scoreDown();
        niv(nbNiv);
    }

    public void templateNiv(int tempMaxTmp, int nbAvions, int nbJet){
        tempmax = tempMaxTmp;
        Scene.getScene().getAvionAff().creeAvions(nbAvions - Scene.getScene().getAvionAff().getListeAvion().size());
        Scene.getScene().getAvionAff().creeJet(nbJet);
        debut = Instant.now();
        tick.start();
    }
    
    
    
    
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
