import java.util.ArrayList;
import java.util.List;

public class Camion implements PeutSortirCarton, PeutChargerCarton {
    private List<Carton> cartons;
    private int capaciteMaximale;

    public Camion(int capaciteMaximale) {
        System.out.println("Création d'un camion");
        this.capaciteMaximale = capaciteMaximale;
        this.cartons = new ArrayList<Carton>();
    }

    @Override
    public boolean aDeLaPlace() {
        return this.capaciteMaximale > this.cartons.size();
    }

    @Override
    public void chargerCarton(Carton carton) {
        this.cartons.add(carton);
    }

    public void deplacer(Local destination) {
        System.out.println("Le camion roule... vroooooooooooum");
    }

    public boolean contientCarton() {
        return ! this.cartons.isEmpty();
    }

    public Carton sortirCarton() {
        return this.cartons.remove(0);
    }

    @Override
    public String toString() {
        return "Camion{" +
                "cartons=" + cartons +
                '}';
    }
}
