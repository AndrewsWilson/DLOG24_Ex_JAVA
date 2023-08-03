public class Carton {
    private int numero;

    public Carton(int numeroCarton) {
        System.out.println("Création d'un carton");
        this.numero = numeroCarton;
    }

    @Override
    public String toString() {
        return "Carton{" +
                "numero=" + numero +
                '}';
    }
}
