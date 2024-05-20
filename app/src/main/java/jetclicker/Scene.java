package jetclicker;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe qui s'occupe de mettre tout ce dont il y a besoin dans la fenetre.
 */

public class Scene extends JPanel {

    private static Scene scene;
    private Image imgFond;
    private Gestionnaire_avion objListAv;
    private Fenetre fenetre;
    private boolean gagnePourCouleur;
    private boolean premierDemarage;
	public static Queue<Explosion> liste_Explosion;
    //private ImageIcon icotest;
    //private Image imgtest;
    //private int xtest;

    private Scene(Fenetre tab){
        //Variable initialisé
        super();
        BufferedImage originalImage;
        try {
            originalImage = ImageIO.read(new File("app/src/main/resources/CarteFrance.png"));
            if (originalImage != null) {
                ImageIcon imageIcon = new ImageIcon(originalImage.getScaledInstance(tab.getLongueur(), tab.getLargueur(), Image.SCALE_SMOOTH));

                imgFond = imageIcon.getImage();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        objListAv = new Gestionnaire_avion(100, tab);
        objListAv = new Gestionnaire_avion(0, tab);
        this.fenetre = tab;
        gagnePourCouleur = false;
        premierDemarage = true;
        //xtest = 1;
        liste_Explosion = new LinkedList<Explosion>();
    }

/**
 * Vérifie si une scène existe.
 * Si oui la renvoie.
 * Si non en créée une nouvelle et la renvoie.
 * 
 * @param tab
 * @return
 */

    public static Scene getScene(Fenetre tab){
        if (scene == null){
            scene = new Scene(tab);
        }
        return scene;
    }
    
/**
 * Renvoie la scène
 * 
 * @return La scène
 */

    public static Scene getScene(){
        return scene;
    }

    public Gestionnaire_avion getAvionAff(){
        return objListAv;
    }

/**
 * Choisie l'image à utiliser pour que l'avion soit de la bonne compagnie et face la direction dans laquelle il se dirige.
 * 
 * @param orientation La face vers laquelle l'avion est dirigé
 * @param nom La compagnie de l'avion
 * @return L'image à utiliser
 */

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

/**
 * Choisi la bonne image d'avion à afficher en fonction de l'orientation de l'avion pour que le nez de l'avion face la direction dans laquelle il se dirige.
 * 
 * @param orientation La face vers laquelle l'avion est dirigé
 * @return L'image à utiliser
 */

    public Image getChoixImage(Double orientation){
        ImageIcon icotest;
        String imagePath = "app/src/main/resources/avion/avion_rouge/";
        double degrees = Math.toDegrees(orientation);
        degrees = (degrees + 360) % 360;

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

/**
 * Dessine toute la scène en mettant les images d'avions sur la carte, affichant le score, affichant les explosions, passe le niveau si il est terminé et affiche les jets en rouge au départ.
 * 
 * @param g
 */

    public void paintComponent(Graphics g){
        // C'est ici que se dessine la scène
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        Font font=new Font("Arial",Font.PLAIN,50);
        //xtest += 10;
        
        g2.drawImage(this.imgFond, 0, 0, null);
        g2.setFont(font);
        g2.setColor(Color.BLACK);
        g2.drawString("Score: "+Player.getPlayer().getScore(),15,50);
        
        ArrayList<Avion> listAvion = objListAv.getListeAvion();
        int nbprivee = 0;
        for (Avion avion : listAvion) {
            if (Gestionnaire_Niveau.getGestionnaire_Niveau().getDiffTemp() && avion.getPrivate() == true) {
                g2.drawImage(getChoixImage(avion.getOrientation()), avion.positionX(), avion.positionY(), null);
            } else {
                g2.drawImage(getChoixImage(avion.getOrientation(), avion.nom), avion.positionX(), avion.positionY(), null);
            }
            if (avion.getPrivate() == true) {
                nbprivee += 1;
            }
        }
        if (nbprivee == 0) {
            Gestionnaire_Niveau.getGestionnaire_Niveau().changerNiv();
            gagnePourCouleur = true;
        }

        for (Explosion boom : liste_Explosion) {
            g2.drawImage(boom.changerImage(),boom.positionX() ,boom.positionY() , null);
            if (boom.getImage()>16){
                liste_Explosion.remove();
            }
            //System.out.println(boom.getX());
        }

        objListAv.bouger_Avions();
        if (Gestionnaire_Niveau.getGestionnaire_Niveau().getTempCouleur()) {
            if (gagnePourCouleur) {
                g2.setColor(new Color(0, 255, 0, 64));
                g2.fillRect(0, 0, fenetre.getLongueur(), fenetre.getLargueur());
            } else if (premierDemarage == false){
                g2.setColor(new Color(255, 0, 0, 64));
                g2.fillRect(0, 0, fenetre.getLongueur(), fenetre.getLargueur());
            }
        } else {
            gagnePourCouleur = false;
            premierDemarage = false;
        }
        //g2.drawImage(this.imgtest, 800,xtest, null);
        //System.out.println(xtest);

        //* A faire par la suite: Boucle Foreach d'avion qui les met avec un png et un position*/
    }

}
