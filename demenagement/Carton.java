package demenagement;

public class Carton {
    private int numero;

    public Carton(int numeroCarton){
        this.numero = numeroCarton;
    }

    public int getNumero(){
        return this.numero;
    }

    public String toString(){
        return "Carton{"+
                "numero=" + getNumero() +
                '}';
    }

}