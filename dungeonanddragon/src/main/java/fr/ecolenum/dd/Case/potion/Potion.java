package fr.ecolenum.dd.Case.potion;

import fr.ecolenum.dd.Case.Case;

/**
 * Abstract class position never instantiate, used as a template for all potion class
 */
public abstract class Potion extends Case {
    private int healing;
    private String namePotion;

    /**
     * Potion constructor
     * @param number used to define position of object in board
     * @param healingCapacity used to define the healing capacity of the potion object
     * @param name used to define the name of the object
     */
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
