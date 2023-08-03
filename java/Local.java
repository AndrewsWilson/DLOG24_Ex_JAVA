import java.util.List;

public class Local implements PeutSortirCarton, PeutChargerCarton {
    private List<Carton> cartons;

    public Local(List<Carton> cartons) {
        System.out.println("Création d'un local");
        this.cartons = cartons;
    }

    @Override
    public boolean contientCarton() {
        return ! this.cartons.isEmpty();
    }

    @Override
    public Carton sortirCarton() {
        return this.cartons.remove(0);
    }

    @Override
    public boolean aDeLaPlace() {
        return true;
    }

    public void chargerCarton(Carton carton) {
        this.cartons.add(carton);
    }

    @Override
    public String toString() {
        return "Local{" +
                "cartons=" + cartons +
                '}';
    }
}
