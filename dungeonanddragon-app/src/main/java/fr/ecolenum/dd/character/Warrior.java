package fr.ecolenum.dd.character;

import fr.ecolenum.dd.Case.Weapon.Hammer;
import fr.ecolenum.dd.Case.Weapon.Weapon;

public class Warrior extends Character {
    private Weapon weapon;

    public  Warrior(String characterName, int charactherLife, int characterForceAttack) {
        super(characterName, charactherLife, characterForceAttack, "shield", 10, 10);
        this.weapon = new Hammer(1);
    }

    public  Warrior(String characterName, Weapon characterWeapon) {
        super(characterName, 5, 5, "shield", 10, 10);
        this.weapon = characterWeapon;
    }

    public  Warrior() {
        super();
        this.weapon = new Hammer(1);
    }

    //--------------------Arme--------------------
    //->GETTER<-
    public String getWeapon(){
        return this.weapon.getNameWeapon();
    }

    public void setWeapon(Weapon weapon){
         this.weapon = weapon;
    }

    public int getWeaponDamage(){
       return weapon.getDamageWeapon();
    }




    public String toString(){
        return super.toString()+ "fr.ecolenum.dd.Case.Weapon.fr.ecolenum.dd.Case.Weapon : " + getWeapon() + "}";
    }
}


