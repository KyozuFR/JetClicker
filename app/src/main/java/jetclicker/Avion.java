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

/**
 * Renvoie le nom de l'avion.
 * 
 * @return Le nom de l'avion en String
 */

    public String getNom() {
        return nom;
    }

/**
 * Modifie le nom de l'avion.
 * 
 * @param nom Un String qui détermine le nom de l'avion
 */

    public void setNom(String nom) {
        this.nom = nom;
    }

/**
 * Renvoie l'orientation de l'avion.
 * 
 * @return L'orientation de l'avion en double
 */

    public double getOrientation() {
        return orientation;
    }

/**
 * Modifie l'orientation de l'avion.
 * 
 * @param orientation Un double qui détermine l'orientation de l'avion
 */

    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

/**
 * Renvoie la vitesse de l'avion.
 * 
 * @return La vitesse de l'avion en integer
 */

    public int getVitesse() {
        return vitesse;
    }

/**
 * Modifie la vitesse de l'avion.
 * 
 * @param vitesse Un integer qui détermine la vitesse de l'avion
 */

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

/**
 * Renvoie True si l'avion est un jet privé, False sinon.
 * 
 * @return Un booléen définissant si l'avion est un jet privé ou non
 */

    public boolean getPrivate() {
        return est_jet;
    }

/**
 * Fait que l'avion soit un jet privé.
 * 
 * @param est_avion_privee Un booléen qui détermine si un avion est privé ou non
 */

    public void setPrivate(boolean est_avion_privee) {
        this.est_jet = est_avion_privee;
    }
    public boolean isApi() {
        return est_avion_api;
    }
    public void setApi(boolean est_avion_api) {
        this.est_avion_api = est_avion_api;
    }
    //#endregion

    //#region Coordonée

/**
 * Renvoie la coordonnée X de l'avion.
 * 
 * @return La coordonnée X de l'avion en double
 */

    public double getX() {
        return x;
    }

/**
 * Modifie la coordonnée X de l'avion.
 * 
 * @param x Un double représentant la coordonnée X de l'avion
 */

    public void setX(double x) {
        this.x = x;
    }
    
/**
 * Renvoie la coordonnée Y de l'avion.
 * 
 * @return La coordonnée Y de l'avion en double
 */

    public double getY() {
        return y;
    }
    
/**
 * Modifie la coordonnée Y de l'avion.
 * 
 * @param y Un double représentant la coordonnée Y de l'avion
 */

    public void setY(double y) {
        this.y = y;
    }
    //#endregion

/**
 * Choisi le nom et la marque de la companie de l'avion aléatoirement.
 * 
 * @return L'image à utiliser pour modéliser l'avion
 */

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

/** 
 * Créée un avion ayant les paramètres donnés.
 *
 * @param IsPrivate Un booléen qui définit si l'avion est un jet privé 
 * @param nom Un String qui détermine le nom de l'avion
 * @param orientation Un double qui définit dans quelle direction l'avion est tourné
 * @param vitesse Un integer qui détermine la vitesse de l'avion
 * @param x Double qui détermine les coordonnées de départ de l'avion
 * @param y Double qui détermine les coordonnées de départ de l'avion
 */

    public Avion(boolean IsPrivate, String nom, double orientation, int vitesse, double x, double y){
        this.est_jet = IsPrivate;
        this.nom = choisirNom();
        this.orientation = orientation;
        this.vitesse = vitesse;
        this.x = x;
        this.y = y;
    }

/**
 * Méthode utilisée si un avion est détruit ou sort de la carte.
 * Il est alors réinitialisé et devient un nouvel avion avec de nouveaux paramètres.
 * 
 * @param IsPrivate Un booléen qui définit si l'avion est un jet privé 
 * @param nom Un String qui détermine le nom de l'avion
 * @param orientation Un double qui définit dans quelle direction l'avion est tourné
 * @param vitesse Un integer qui détermine la vitesse de l'avion
 * @param x Double qui détermine les coordonnées de départ de l'avion
 * @param y Double qui détermine les coordonnées de départ de l'avion
 */

    public void changerAvion(boolean IsPrivate, String nom, double orientation, int vitesse, double x, double y){
        this.est_jet = IsPrivate;
        this.nom = choisirNom();
        this.orientation = orientation;
        this.vitesse = vitesse;
        this.x = x;
        this.y = y;
    }

/**
 * Deplace l'avion en fonction de son orientation.
 * Change ses coordonnées par les coordonnées suivantes dans sa direction.
 */

    public void deplacement(){
        this.x += this.vitesse * Math.cos(orientation);
        this.y += this.vitesse * Math.sin(orientation);
    }

/**
 * Renvoie la coordonnée de l'avion en integer pour qu'elle puisse être utilisée dans la scène.
 * 
 * @return La coordonnée X transformée en integer
 */

    public int positionX(){
        return (int) Math.round(x);
    }

/**
 * Renvoie la coordonnée de l'avion en integer pour qu'elle puisse être utilisée dans la scène.
 * 
 * @return La coordonnée Y transformée en integer
 */

    public int positionY(){
        return (int) Math.round(y);
    }
}