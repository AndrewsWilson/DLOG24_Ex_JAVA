package jeux;

public class Magicien {
    private String nom;
    private String defense = "Philtre";
    private String vie = "3-6";
    private String forceAttaque = "5-10";
    private Sort sort;

    public Magicien(String nomDuPersonnage, Sort sortDuPersonnage) {
        this.nom = nomDuPersonnage;
        this.sort = sortDuPersonnage;
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
    public String getSort(){
        return this.sort.getNomSort();
    }

}





