package fr.ecolenum.dd.Case.Enemy;

/**
 * Public class Witch used to create Witch object
 */
public class Witch extends Ennemy{
    /**
     * Witch constructor
     * @param number used to define position of the object in board
     */
    public Witch(int number){
        super(number, "Witch", 2, 9);
    }
}
