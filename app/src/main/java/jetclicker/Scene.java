package jetclicker;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond;
    //private ImageIcon icotest;
    //private Image imgtest;
    //private int xtest;

    public Scene(){
        //Variable initialisé
        super();
        icoFond = new ImageIcon("app/src/main/resources/CarteFrance.png");
        this.imgFond = this.icoFond.getImage();
        //icotest = new ImageIcon("app/src/main/resources/bas.png");
        //this.imgtest = this.icotest.getImage();
        //xtest = 1;

    }

    public void paintComponent(Graphics g){
        // C'est ici que se dessine la scène
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        //xtest += 10;
        
        g2.drawImage(this.imgFond, -50, -50, null);
        //g2.drawImage(this.imgtest, 800,xtest, null);
        //System.out.println(xtest);

        //* A faire par la suite: Boucle Foreach d'avion qui les met avec un png et un position*/
    }

}
