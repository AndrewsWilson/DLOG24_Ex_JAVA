package fr.ecolenum.dd.character;

import fr.ecolenum.dd.Case.Weapon.Hammer;
import fr.ecolenum.dd.Case.Weapon.Weapon;

/**
 * Warrior class used to create Warriot object
 */
public class Warrior extends Character {
    private Weapon weapon;

    /**
     * Default warrior constructor used when user want to create warrior himself
     * @param characterName Name of the Warrior
     * @param charactherLife Life of the Warrior
     * @param characterForceAttack Force attack of the Warrior
     */
    public  Warrior(String characterName, int charactherLife, int characterForceAttack) {
        super(characterName, charactherLife, characterForceAttack, "shield", 10, 10);
        this.weapon = new Hammer(1);
    }

    /**
     * 2nd constructor Warrior used when Warrior is instantiate by Database
     * @param characterName Name of the Warrior
     * @param characterWeapon Weapon of the Warrior
     */
    public  Warrior(String characterName, Weapon characterWeapon) {
        super(characterName, 5, 5, "shield", 10, 10);
        this.weapon = characterWeapon;
    }

    /**
     * 3rd Warrior constructor used when user want use default character to play
     *
     */
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


