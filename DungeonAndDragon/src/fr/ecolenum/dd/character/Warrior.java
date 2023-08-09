package fr.ecolenum.dd.character;

public class Warrior extends Character {
    private Weapon weapon;

    public  Warrior(String characterName, int characterLife, int characterForceAttack, Weapon characterWeapon) {
        super(characterName, characterLife, characterForceAttack, "shield");
        this.weapon = characterWeapon;
    }

    public  Warrior() {
        super();
        this.weapon = new Weapon();
    }

    //--------------------Arme--------------------
    //->GETTER<-
    public String getArme(){
        return this.weapon.getNameWeapon();
    }

    public String toString(){
        return super.toString()+ "fr.ecolenum.dd.character.Weapon : " + getArme() + "}";
    }
}

