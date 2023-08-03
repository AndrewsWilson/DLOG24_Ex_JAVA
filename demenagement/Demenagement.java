package demenagement;

import java.util.ArrayList;
import java.util.List;

public class Demenagement {
    public void lancement() {
        //->Liste ancienLocal -> d'instance d'objet carton avec pour valeur retour fonction créeCarton avec param 39 <-
        List<Carton> ancienLocal = creerCartons(39);
        //->Liste nouveauLocal ->  d'instance d'objet carton vide<-
        List<Carton> nouveauLocal = new ArrayList<Carton>();
        //->Liste camion -> d'instance d'objet carton vide<-
        List<Carton> camion = new ArrayList<Carton>();
        int capaciteCamion = 9;
        // ->TANTQUE ancien local n'est pas Empty<-
        while(!ancienLocal.isEmpty()) {
            // ->TANTQUE ancien local n'est pas Empty && taille de la liste camion est inférieur a la capacité camion<-
            while (!ancienLocal.isEmpty() && camion.size() < capaciteCamion) {
                // ->j'ajoute l'objet carton a l'index 0 dans camion qui a été remove de ancienLocal <-
                camion.add(ancienLocal.remove(0));
            }
            System.out.println("Camion Après chargement : "+ camion);
            System.out.println("Ancien local Après chargement : "+ ancienLocal);
            // ->TANTQUE liste camion n'est pas vide<-
            while(!camion.isEmpty()){
                // ->j'ajoute l'objet carton a l'index 0 dans nouveauLocal qui a été remove de camion <-
                nouveauLocal.add(camion.remove(0));
            }
            System.out.println("Camion Après déchargement : "+ camion);
            System.out.println("Nouveau local Après déchargement : "+ nouveauLocal);
            // -> SI ancienLocal est Empty ALORS <-
            if(ancienLocal.isEmpty()){
                System.out.println("Demenagement terminer ");
            }
        }
    }

    // -- >Methode Crée carton<--
    // 1. crée une Liste d'objet ne pouvant contenir que des instance de carton
    // 2. ne pouvant contenir que des instance d'objet Carton
    // 3. Boucle for pour création d'autant d'instance que dder en paramètres
    private static List<Carton> creerCartons(int nombreCartons) {
        List<Carton> cartons = new ArrayList<Carton>();
        for(int i = 0; i < nombreCartons; i++) {
            cartons.add(new Carton(i));
        }
        return cartons;
    }
}
