package fr.ecolenum.dd.Case.potion;

/**
 * Public class SmallPotion used to instantiate SmallPotion Object
 */
public class SmallPotion extends Potion{
    /**
     * SmallPotion constructor
     * @param number used to define position of the object in board
     */
    public SmallPotion(int number){
        super(number, 2, "small potion");
    }
}
