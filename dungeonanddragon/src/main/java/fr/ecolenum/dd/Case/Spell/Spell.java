package fr.ecolenum.dd.Case.Spell;

import fr.ecolenum.dd.Case.Case;

/**
 * Abstract class Spell never instantiate used as a template for all Spell class
 */
public abstract class  Spell extends Case {
    private String name;
    private int damage;

    /**
     * Spell constructor
     * @param number used to define position of the object in board
     * @param spellName used to define name of the spell
     * @param spellDamage used to define damage caused by the spell
     */
    public Spell(int number,String spellName, int spellDamage){
        super(number, "weapon");
        this.name = spellName;
        this.damage = spellDamage;
    }


    //--------------------Degats-------------------
    //->GETTER<-
    public int getDamageSpell(){
        return this.damage;
    }

    //--------------------Sort-------------------
    //->GETTER<-
    public String getNameSpell(){
        return this.name;
    }

    public String toString(){
        return "[ N°CASE : " + getCaseNumber() + " ]\n" +
                "| TYPE : " + getCaseContent() + " |\n" +
                "| NAME : " + getNameSpell() + " |\n" +
                "| POWER : " + getDamageSpell() + " |";
    }
}



