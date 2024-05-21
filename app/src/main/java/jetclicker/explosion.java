package jetclicker;

public class explosion {
    
    private double x;
    private double y;
    private int image = -1;
    private String imagePath = "app/src/main/resources/explosion/16px/";

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
	
	
	public explosion(double x, double y){
        this.x = x;
        this.y = y;
    }

    public int changerImage(){
        image+=1;
        return image;
    }
}