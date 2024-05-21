package jetclicker;

import java.util.Random;

public class Avion {
    boolean est_avion_api;
    boolean est_jet;
    String nom;
    double orientation;
    int vitesse;
    double x;
    double y;

    //#region Nom
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getOrientation() {
        return orientation;
    }
    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }
    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public boolean getPrivate() {
        return est_jet;
    }
    public void setPrivate(boolean est_avion_privee) {
        this.est_jet = est_avion_privee;
    }
    //#endregion

    //#region Coordonée
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    //#endregion
    public String choisirNom(){
        Random rand = new Random();
        int choixImage = rand.nextInt(7);
        String imagePath = "";
        
        switch (choixImage) {
            case 0:
                imagePath = "app/src/main/resources/avion/avion/";
                break;
			case 1:
                imagePath = "app/src/main/resources/avion/avion_airfrance/";
                break;
			case 2:
                imagePath = "app/src/main/resources/avion/avion_easyjet/";
                break;
			case 3:
                imagePath = "app/src/main/resources/avion/avion_iberia/";
                break;
			case 4:
                imagePath = "app/src/main/resources/avion/avion_lufthansa/";
                break;
			case 5:
                imagePath = "app/src/main/resources/avion/avion_Vueling/";
                break;
			case 6:
                imagePath = "app/src/main/resources/avion/avion_Wizzair/";
                break;
            default:
                break;
        }
        return imagePath;
    }
    public Avion(boolean IsPrivate, String nom, double orientation, int vitesse, double x, double y){
        this.est_jet = IsPrivate;
        this.nom = choisirNom();
        this.orientation = orientation;
        this.vitesse = vitesse;
        this.x = x;
        this.y = y;
    }

    public void changerAvion(boolean IsPrivate, String nom, double orientation, int vitesse, double x, double y){
        this.est_jet = IsPrivate;
        this.nom = choisirNom();
        this.orientation = orientation;
        this.vitesse = vitesse;
        this.x = x;
        this.y = y;
    }

    public void deplacement(){
        this.x += this.vitesse * Math.cos(orientation);
        this.y += this.vitesse * Math.sin(orientation);
    }

    public int positionX(){
        return (int) Math.round(x);
    }

    public int positionY(){
        return (int) Math.round(y);
    }
}