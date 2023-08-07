package jeux;

public class Wizzard extends Character{
    private String defense;
    private Spell spell;

    public Wizzard(String characterName, Spell characterSpell, int characterLife, int characterForceAttack) {
        super(characterName, characterLife, characterForceAttack, "Philter");
        this.spell = characterSpell;
    }

    //--------------------WEAPON--------------------
    //->GETTER<-
    public String getSpell(){
        return this.spell.getNomSort();
    }
    public String toString(){
        return super.toString() +"Spell :" + getSpell() + "}";
    }

}







