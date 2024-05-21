package jetclicker;


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
    public boolean isApi() {
        return est_avion_api;
    }
    public void setApi(boolean est_avion_api) {
        this.est_avion_api = est_avion_api;
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

    public Avion(boolean est_api,boolean IsPrivate, String nom, double orientation, int vitesse, double x, double y){
        this.est_avion_api = est_api;
        this.est_jet = IsPrivate;
        this.nom = nom;
        this.orientation = orientation;
        this.vitesse = vitesse;
        this.x = x;
        this.y = y;
    }

    public void changerAvion(boolean est_api, boolean IsPrivate, String nom, double orientation, int vitesse, double x, double y){
        this.est_avion_api = est_api;
        this.est_jet = IsPrivate;
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