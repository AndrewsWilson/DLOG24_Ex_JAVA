package jeux;
public class Warrior {
    private String name;
    private String defense = "Bouclier";
    private int life ;
    private int forceAttack;
    private Weapon weapon;

    public  Warrior(String characterName, Weapon characterWeapon, int characterLife, int characterForceAttack) {
        this.name = characterName;
        this.weapon = characterWeapon;
        this.life = characterLife;
        this.forceAttack = characterForceAttack;
    }



    //-----------------NOM-------------------
    //->GETTER<-
    public String getName(){
        return this.name;
    }
    //->SETTER<-
    public String setName(String name){
        return this.name = name;
    }

    //------------------VIE----------------------

    //->GETTER<-
    public int getLife(){
        return this.life;
    }
    //->SETTER<-
    public int setLife(int characterLife){
        return this.life = characterLife;
    }

    //--------------------ATTAQUE--------------------
    //->GETTER<-
    public int getForceAttack(){
        return this.forceAttack;
    }
    public int setForceAttack(int characterForceAttack){
        return this.forceAttack = characterForceAttack;
    }

    //--------------------Arme--------------------
    //->GETTER<-
    public String getArme(){
        return this.weapon.getNomArme();
    }
}


