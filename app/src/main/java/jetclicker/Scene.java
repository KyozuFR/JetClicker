package jetclicker;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond;

    public Scene(){
        //Variable initialisé
        super();
        icoFond = new ImageIcon("app/src/main/resources/CarteFrance.png");
        this.imgFond = this.icoFond.getImage();

    }

    public void paintComponent(Graphics g){
        // C'est ici que se dessine la scène
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        
        g2.drawImage(this.imgFond, -50, -50, null);

        //* A faire par la suite: Boucle Foreach d'avion qui les met avec un png et un position*/
    }

}
