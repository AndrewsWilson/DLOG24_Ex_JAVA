package jeux;
public class Guerrier {
    private String nom;
    private String defense = "Bouclier";
    private String vie = "5-10";
    private String forceAttaque = "5-10";
    private Arme arme;

    public Guerrier(String nomDuPersonnage, Arme armeDuPersonnage) {
        this.nom = nomDuPersonnage;
        this.arme = armeDuPersonnage;
    }



    //-----------------NOM-------------------
    //->GETTER<-
    public String getNom(){
        return this.nom;
    }
    //->SETTER<-
    public String setNom(String nom){
        return this.nom = nom;
    }

    //------------------VIE----------------------

    //->GETTER<-
    public String getVie(){
        return this.vie;
    }

    //--------------------ATTAQUE--------------------
    //->GETTER<-
    public String getForceAttaque(){
        return this.forceAttaque;
    }

    //--------------------Arme--------------------
    //->GETTER<-
    public String getArme(){
        return this.arme.getNomArme();
    }
}


