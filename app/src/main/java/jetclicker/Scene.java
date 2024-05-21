package jetclicker;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


import java.util.LinkedList;
import java.util.Queue;

public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond;
    public static Liste_Avion objListAv;
	public static Queue<Explosion> liste_Explosion;
    //private ImageIcon icotest;
    //private Image imgtest;
    //private int xtest;

    public Scene(Fenetre tab){
        //Variable initialisé
        super();
        icoFond = new ImageIcon("app/src/main/resources/CarteFrance.png");
        this.imgFond = this.icoFond.getImage();
        objListAv = new Liste_Avion(10, tab);
        //xtest = 1;
        liste_Explosion = new LinkedList<Explosion>();
    }

    public Image getChoixImage(Double orientation, String nom){
        ImageIcon icotest;
        String imagePath = "";
        double degrees = Math.toDegrees(orientation);
        degrees = (degrees + 360) % 360;
        imagePath = nom;

		if ((degrees >= 348.75 && degrees < 360) || (degrees >= 0 && degrees < 11.25)) {
            imagePath += "0d.png";
        } else if (degrees >= 11.25 && degrees < 33.75) {
            imagePath += "20d.png";
        } else if (degrees >= 33.75 && degrees < 56.25) {
            imagePath += "45d.png";
        } else if (degrees >= 56.25 && degrees < 78.75) {
            imagePath += "75d.png";
        } else if (degrees >= 78.75 && degrees < 101.25) {
            imagePath += "90d.png";
        } else if (degrees >= 101.25 && degrees < 123.75) {
            imagePath += "110d.png";
        } else if (degrees >= 123.75 && degrees < 146.25) {
            imagePath += "135d.png";
        } else if (degrees >= 146.25 && degrees < 168.75) {
            imagePath += "155d.png";
        } else if (degrees >= 168.75 && degrees < 191.25) {
            imagePath += "180d.png";
        } else if (degrees >= 191.25 && degrees < 213.75) {
            imagePath += "200d.png";
        } else if (degrees >= 213.75 && degrees < 236.25) {
            imagePath += "225d.png";
        } else if (degrees >= 236.25 && degrees < 258.75) {
            imagePath += "245d.png";
        } else if (degrees >= 258.75 && degrees < 281.25) {
            imagePath += "270d.png";
        } else if (degrees >= 281.25 && degrees < 303.75) {
            imagePath += "290d.png";
        } else if (degrees >= 303.75 && degrees < 326.25) {
            imagePath += "315d.png";
        } else if (degrees >= 326.25 && degrees < 348.75) {
            imagePath += "335d.png";
        }

        icotest = new ImageIcon(imagePath);
        Image imgtest = icotest.getImage();

        return imgtest;
    }

    public void paintComponent(Graphics g){
        // C'est ici que se dessine la scène
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        //xtest += 10;
        
        g2.drawImage(this.imgFond, -50, -50, null);
        
        ArrayList<Avion> listAvion = objListAv.getListeAvion();
        for (Avion avion : listAvion) {
            g2.drawImage(getChoixImage(avion.getOrientation(), avion.nom), avion.positionX(), avion.positionY(), null);
        }

        for (Explosion boom : liste_Explosion) {
            g2.drawImage(boom.changerImage(),boom.positionX() ,boom.positionY() , null);
            if (boom.getImage()>16){
                liste_Explosion.remove();
            }
            //System.out.println(boom.getX());
        }

        objListAv.bouger_Avions();
        //g2.drawImage(this.imgtest, 800,xtest, null);
        //System.out.println(xtest);

        //* A faire par la suite: Boucle Foreach d'avion qui les met avec un png et un position*/
    }

}
