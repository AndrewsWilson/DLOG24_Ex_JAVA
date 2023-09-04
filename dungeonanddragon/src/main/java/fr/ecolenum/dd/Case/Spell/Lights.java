package fr.ecolenum.dd.Case.Spell;

/**
 * Public class lights used to instantiate Spell object
 */
public class Lights extends Spell{
    /**
     * Lights constructor
     * @param number used to define position of the object in board
     */
    public Lights(int number){
        super(number, "Light", 2);
    }
}
