/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jetclicker;

import java.io.IOException;

import jetclicker.opensky.api.OpenSkyApi;
import jetclicker.opensky.api.OpenSkyApi.BoundingBox;
import jetclicker.opensky.model.OpenSkyStates;
import jetclicker.opensky.model.StateVector;

public class App {


    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        Gestionnaire_Niveau gest = Gestionnaire_Niveau.getGestionnaire_Niveau();
        gest.changerNiv();

        //Fenetre tab = new Fenetre();
        //tab.setVisible(false); //pour actualiser la fenetre et avoir les limite de l'écran actualisé (c'est du bricolage)
        //tab.setVisible(true);

        //Thread Tick = new Thread(new Tick());
        //Tick.start();

        //explosion one = queue.peek();

        //System.out.println(one.showPosition());

        //Liste_Avion liste_AvionTest = new Liste_Avion();
        //liste_AvionTest.bouger_Avions();

        try {
            OpenSkyApi api = new OpenSkyApi("Dystog", "@JetClicker02");
            OpenSkyStates os = api.getStates(0, null, new BoundingBox(45.8389, 47.8229, 5.9962, 10.5226)); // Utilisation directe de BoundingBox
            if (os.getStates() != null) {
                System.out.println("Nombre d'états récupérés : " + os.getStates().size());
                for (StateVector state : os.getStates()) {
                    System.out.println("ICAO24 : " + state.getIcao24() + " CALLSIGN : " + state.getCallsign());
                }
            } else {
                System.out.println("Aucune donnée d'état retournée.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
