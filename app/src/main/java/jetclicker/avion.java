package jetclicker;

import org.checkerframework.checker.units.qual.Angle;

public class avion {
    Boolean Private;
    String Nom;
    Integer Orientation;
    Integer Speed;
    Double x;
    Double y;

    //#region Nom
    public String getNom() {
        return Nom;
    }
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    public Integer getOrientation() {
        return Orientation;
    }
    public void setOrientation(Integer orientation) {
        this.Orientation = orientation;
    }
    public Integer getSpeed() {
        return Speed;
    }
    public void setSpeed(Integer speed) {
        this.Speed = speed;
    }
    public Boolean getPrivate() {
        return Private;
    }
    public void setPrivate(Boolean private1) {
        Private = private1;
    }
    //#endregion

    //#region Coordonée
    public Integer getX() {
        return x;
    }
    public void setX(Integer x) {
        this.x = x;
    }
    public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }
    //#endregion

    avion(Boolean IsPrivate, String LeNom, Integer LOrientation, Integer LaVitesse, Double LeX, Double LeY){
        this.Private = IsPrivate;
        this.Nom = LeNom;
        this.Orientation = LOrientation;
        this.Speed = LaVitesse;
        this.x = LeX;
        this.y = LeY;
    }

    public void moving(){
        this.x = this.Speed * Math.cos(Orientation);
        this.x = this.Speed * Math.sin(Orientation);
    }

}