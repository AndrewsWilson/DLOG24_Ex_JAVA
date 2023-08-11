package fr.ecolenum.dd.Case.Spell;

import fr.ecolenum.dd.Case.Case;

public abstract class  Spell extends Case {
    private String name;
    private int damage;

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



