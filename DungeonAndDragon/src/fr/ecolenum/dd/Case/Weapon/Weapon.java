package fr.ecolenum.dd.Case.Weapon;

import fr.ecolenum.dd.Case.Case;

public abstract class Weapon extends Case {
    private String name;
    private int damage;

    public Weapon (int number,String weaponName, int weaponDamage){
        super(number, "weapon");
        this.name = weaponName;
        this.damage = weaponDamage;
    }

    //--------------------Degats-------------------
    //->GETTER<-
    public int getDamageWeapon(){
        return this.damage;
    }

    //--------------------Nom-------------------
    //->GETTER<-
    public String getNameWeapon(){
        return this.name;
    }
    public String toString(){
        return "[ N°CASE : " + getCaseNumber() + " ]\n" +
                "| TYPE : " + getCaseContent() + " |\n" +
                "| NAME : " + getNameWeapon() + " |\n" +
                "| POWER : " + getDamageWeapon() + " |";
    }
}



