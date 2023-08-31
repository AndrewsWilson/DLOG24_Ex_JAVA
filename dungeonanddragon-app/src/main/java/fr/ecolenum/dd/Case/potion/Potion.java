package fr.ecolenum.dd.Case.potion;

import fr.ecolenum.dd.Case.Case;

public abstract class Potion extends Case {
    private int healing;
    private String namePotion;
    public Potion(int number, int healingCapacity, String name){
        super(number, "potion");
        this.healing = healingCapacity;
        this.namePotion = name;
    }

    public String getNamePotion(){
        return this.namePotion;
    }
    public int getHealingPotion(){
        return this.healing;
    }

    public String toString(){
        return "[ N°CASE : " + getCaseNumber() + " ]\n" +
                "| TYPE : " + getCaseContent() + " |\n" +
                "| NAME : " + getNamePotion() + " |\n" +
                "| Healing capacity : " + getHealingPotion() + " |";
    }
}
