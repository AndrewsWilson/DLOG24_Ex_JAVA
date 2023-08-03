package jeux;

public class Wizzard {
    private String name;
    private String defense = "Philter";
    private int life ;
    private int forceAttack;
    private Spell spell;

    public Wizzard(String characterName, Spell characterSpell, int characterLife, int characterForceAttack) {
        this.name = characterName;
        this.spell = characterSpell;
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

    //--------------------ATTACK--------------------
    //->GETTER<-
    public int getForceAttack(){
        return this.forceAttack;
    }
    public int setForceAttack(int characterForceAttack){
        return this.forceAttack = characterForceAttack;
    }


//--------------------WEAPON--------------------
    //->GETTER<-
    public String getSort(){
        return this.spell.getNomSort();
    }

}





