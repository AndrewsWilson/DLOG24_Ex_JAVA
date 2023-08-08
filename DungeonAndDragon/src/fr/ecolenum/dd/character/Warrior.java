package fr.ecolenum.dd.character;

public class Warrior extends Character {
    private Weapon weapon;

    public  Warrior(String characterName, int characterLife, int characterForceAttack, Weapon characterWeapon) {
        super(characterName, characterLife, characterForceAttack, "shield");
        this.weapon = characterWeapon;
    }

    //--------------------Arme--------------------
    //->GETTER<-
    public String getArme(){
        return this.weapon.getNomArme();
    }

    public String toString(){
        return super.toString()+ "fr.ecolenum.dd.character.Weapon : " + getArme() + "}";
    }
}

