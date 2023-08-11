package fr.ecolenum.dd.character;

import fr.ecolenum.dd.Case.Weapon.Hammer;
import fr.ecolenum.dd.Case.Weapon.Weapon;

public class Warrior extends Character {
    private Weapon weapon;

    public  Warrior(String characterName, int characterLife, int characterForceAttack, Weapon characterWeapon) {
        super(characterName, 5, 5, "shield", 10, 10);
        this.weapon = characterWeapon;
    }

    public  Warrior() {
        super();
        this.weapon = new Hammer(1);
    }

    //--------------------Arme--------------------
    //->GETTER<-
    public String getArme(){
        return this.weapon.getNameWeapon();
    }
    public String toString(){
        return super.toString()+ "fr.ecolenum.dd.Case.Weapon.fr.ecolenum.dd.Case.Weapon : " + getArme() + "}";
    }
}

