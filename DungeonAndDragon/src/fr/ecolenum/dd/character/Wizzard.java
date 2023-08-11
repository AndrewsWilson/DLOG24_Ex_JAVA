package fr.ecolenum.dd.character;

import fr.ecolenum.dd.Case.Spell.Spell;

public class Wizzard extends Character {
    private String defense;
    private Spell spell;

    public Wizzard(String characterName, Spell characterSpell, int characterLife, int characterForceAttack) {
        super(characterName, 3, 8, "Philter", 15,6);
        this.spell = characterSpell;
    }

    //--------------------WEAPON--------------------
    //->GETTER<-
    public String getSpell(){
        return this.spell.getNameSpell();
    }
    public String toString(){
        return super.toString() +"fr.ecolenum.dd.Case.Spell.fr.ecolenum.dd.Case.Spell :" + getSpell() + "}";
    }

}







