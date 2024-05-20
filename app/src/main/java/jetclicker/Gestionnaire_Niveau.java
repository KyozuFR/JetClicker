package jetclicker;

public class Gestionnaire_Niveau {
    private int nbNiv;
    private static Gestionnaire_Niveau gestionnaire_Niveau;
    private Tick tick;

    //privée car singleton
    private Gestionnaire_Niveau(){
        nbNiv = 0;
        tick = new Tick(); 
        Thread x = new Thread(tick);
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
        nbNiv+= 1;
        niv(nbNiv);
    }

    public void niv(int nb){
        if (nb==1){
            Fenetre tab = new Fenetre();
            tab.setVisible(false); //pour actualiser la fenetre et avoir les limite de l'écran actualisé (c'est du bricolage)
            tab.setVisible(true);
            Scene.getScene().objListAv.creeAvions(2);
            tick.start();
        }

    }
    
}
