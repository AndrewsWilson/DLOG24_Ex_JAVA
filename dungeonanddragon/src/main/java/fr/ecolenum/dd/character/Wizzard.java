package fr.ecolenum.dd.character;

import fr.ecolenum.dd.Case.Spell.Lights;
import fr.ecolenum.dd.Case.Spell.Spell;

/**
 * Wizzard class used to create wizzard character
 */
public class Wizzard extends Character {
    private String defense;
    private Spell spell;

    /**
     * Default Constructor used when Wizzrd create by database
     * @param characterName name of the wizzard
     * @param characterLife life of the wizzard
     * @param characterForceAttack attack of the wizzard
     */
    public Wizzard(String characterName, int characterLife, int characterForceAttack) {
        super(characterName, characterLife, characterForceAttack, "Philter", 15,6);
        this.spell = new Lights(1);
    }

    /**
     * 2ND Constructor used when user want to create wizzard by himself
     * @param characterName name of the wizzard
     * @param characterSpell Spell of the wizzard
     */
    public Wizzard(String characterName, Spell characterSpell) {
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







