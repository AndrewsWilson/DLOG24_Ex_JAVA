package fr.ecolenum.dd.character;

public class Weapon {
    private String name;
    private String damage;

    public Weapon (){
        this.name = "masse";
        this.damage = "8-10";
    }

    //--------------------Degats-------------------
    //->GETTER<-
    public String getDamageWeapon(){
        return this.damage;
    }

    //--------------------Nom-------------------
    //->GETTER<-
    public String getNameWeapon(){
        return this.name;
    }
}



