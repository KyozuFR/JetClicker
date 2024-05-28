package jetclicker;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Classe qui s'occupe des explosions quand un avion est touché et détruit.
 */

public class Explosion {
    
    private double x;
    private double y;
    private int image = -1;
    private String imagePath = "app/src/main/resources/explosion/16px/";

	public Explosion(double x, double y){
        this.x = x;
        this.y = y;
    }

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

/**
 * Renvoie le x et y de l'explosion.
 * 
 * @return Le x et y de l'explosion
 */

    public String showPosition(){
        return ("X : "+this.x+" Y :"+this.y);
    }

/**
 * Anime l'explosion en changeant à chaque tick l'image.
 * 
 * @return L'image à envoyer afin d'animer
 */

    public Image changerImage(){
        image+=1;
        String imagePathTemp = imagePath + image+".png";
        ImageIcon imageTemp = new ImageIcon(imagePathTemp);
        Image imgtest = imageTemp.getImage();
        return imgtest;
    }

/**
 * Renvoie l'image à afficher pour changerImage()
 * 
 * @return L'image à afficher pour changerImage()
 */

    public int getImage(){
        return image;
    }
}