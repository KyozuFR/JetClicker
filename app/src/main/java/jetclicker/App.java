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
        Avion AvionTest = new Avion(true, "Gerar", Math.PI, 10, 0.0, 0.0);
        AvionTest.deplacement();

        System.out.println(AvionTest.positionX());
        System.out.println(AvionTest.positionY());

        Liste_Avion liste_AvionTest = new Liste_Avion();
        liste_AvionTest.bouger_Avions();
    }
}
