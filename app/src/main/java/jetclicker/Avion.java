package jetclicker;


public class Avion {
    boolean est_avion_privee;
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
        return est_avion_privee;
    }
    public void setPrivate(boolean est_avion_privee) {
        this.est_avion_privee = est_avion_privee;
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

    Avion(boolean IsPrivate, String nom, double orientation, int vitesse, double x, double y){
        this.est_avion_privee = IsPrivate;
        this.nom = nom;
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