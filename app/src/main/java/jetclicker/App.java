/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jetclicker;

public class App {


    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        Gestionnaire_Niveau gest = Gestionnaire_Niveau.getGestionnaire_Niveau();
        gest.changerNiv();

        Fenetre tab = new Fenetre();
        tab.setVisible(false); //pour actualiser la fenetre et avoir les limite de l'écran actualisé (c'est du bricolage)
        tab.setVisible(true);

        Thread Tick = new Thread(new Tick());
        Tick.start();
    }
}