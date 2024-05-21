package jetclicker;

import javax.swing.ImageIcon;
import java.awt.Image;

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
	
	public int positionX(){
        return (int) Math.round(x);
    }

    public int positionY(){
        return (int) Math.round(y);
    }
	
    public String showPosition(){
        return ("X : "+this.x+" Y :"+this.y);
    }

    public Image changerImage(){
        image+=1;
        String imagePathTemp = imagePath + image+".png";
        ImageIcon imageTemp = new ImageIcon(imagePathTemp);
        Image imgtest = imageTemp.getImage();
        return imgtest;
    }
    public int getImage(){
        return image;
    }
}