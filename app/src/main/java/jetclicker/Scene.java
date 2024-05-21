package jetclicker;

import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond;
    public static Liste_Avion objListAv;
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
        
    }

    public Image getChoixImage(Double orientation){
        ImageIcon icotest;
        String imagePath = "";
        
        double degrees = Math.toDegrees(orientation);

        degrees = (degrees + 360) % 360;
    
        if ((degrees >= 337.5 && degrees <= 360) || (degrees >= 0 && degrees < 22.5)) {
            imagePath = "app/src/main/resources/droite.png";
        } else if (degrees >= 22.5 && degrees < 67.5) {
            imagePath = "app/src/main/resources/bas-droite.png";
        } else if (degrees >= 67.5 && degrees < 112.5) {
            imagePath = "app/src/main/resources/bas.png";
        } else if (degrees >= 112.5 && degrees < 157.5) {
            imagePath = "app/src/main/resources/bas-gauche.png";
        } else if (degrees >= 157.5 && degrees < 202.5) {
            imagePath = "app/src/main/resources/gauche.png";
        } else if (degrees >= 202.5 && degrees < 247.5) {
            imagePath = "app/src/main/resources/haut-gauche.png";
        } else if (degrees >= 247.5 && degrees < 292.5) {
            imagePath = "app/src/main/resources/haut.png";
        } else if (degrees >= 292.5 && degrees < 337.5) {
            imagePath = "app/src/main/resources/haut-droite.png";
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
        
        g2.drawImage(this.imgFond, 0, 0, null);
        
        ArrayList<Avion> listAvion = objListAv.getListeAvion();
        for (Avion avion : listAvion) {
            g2.drawImage(getChoixImage(avion.getOrientation()), avion.positionX(), avion.positionY(), null);
        }
        objListAv.bouger_Avions();
        //g2.drawImage(this.imgtest, 800,xtest, null);
        //System.out.println(xtest);

        //* A faire par la suite: Boucle Foreach d'avion qui les met avec un png et un position*/
    }

}
