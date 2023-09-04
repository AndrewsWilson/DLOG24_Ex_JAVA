package fr.ecolenum.dd.Case.Enemy;

/**
 * Goblins class used to create Globlins enemy
 */
public class Goblins extends Ennemy {
    /**
     * Goblins constructor
     * @param number used to define position of the object in board
     */
    public Goblins(int number){
        super(number, "Goblins", 1, 6);
    }
}
