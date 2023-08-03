import java.util.ArrayList;
import java.util.List;

public class Demenagement {
    public static void main(String[] args) {
        System.out.println("début du demenagement");

        Camion camion = new Camion(9);
        Local ancienLocal = new Local(creerCartons(39));
        Local nouveauLocal = new Local(creerAucunCarton());

        while(ancienLocal.contientCarton()) {
            chargerCamion(camion, ancienLocal);

            camion.deplacer(nouveauLocal);

            dechargerCamion(camion, nouveauLocal);
        }

        System.out.println("fin du demenagement");
    }

    private static void dechargerCamion(Camion camion, Local nouveauLocal) {
        System.out.println("Avant déchargement");
        System.out.println(camion.toString());
        System.out.println(nouveauLocal.toString());

        while(camion.contientCarton()) {
            Carton carton = sortirCarton(camion);
            nouveauLocal.chargerCarton(carton);
        }

        System.out.println("Apres déchargement");
        System.out.println(camion.toString());
        System.out.println(nouveauLocal.toString());

    }

    private static Carton sortirCarton(PeutSortirCarton depuisQuelquePart) {
        return depuisQuelquePart.sortirCarton();
    }

    private static void chargerCamion(Camion camion, Local ancienLocal) {
        System.out.println("Avant chargement");
        System.out.println(camion.toString());
        System.out.println(ancienLocal.toString());

        while(camion.aDeLaPlace() && ancienLocal.contientCarton()) {
            Carton carton = sortirCarton(ancienLocal);
            camion.chargerCarton(carton);
        }

        System.out.println("Après chargement");
        System.out.println(camion.toString());
        System.out.println(ancienLocal.toString());
    }

    private static ArrayList<Carton> creerAucunCarton() {
        return new ArrayList<Carton>();
    }

    private static List<Carton> creerCartons(int nombreCartons) {
        List<Carton> cartons = new ArrayList<Carton>();
        for(int i = 1; i <= nombreCartons; i++) {
            cartons.add(new Carton(i));
        }
        return cartons;
    }


}
