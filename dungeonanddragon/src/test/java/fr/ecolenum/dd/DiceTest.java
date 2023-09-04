package fr.ecolenum.dd;

import fr.ecolenum.dd.Dice.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiceTest {
    @Test
    public void pipedDiceShouldAlwaysReturnOne(){
        DiceCanBeRoll dice = new Dice8Face();
        for(int i=0;i<1000;i++) {
            int result = dice.rollTheDice();
            assertTrue(result <= 8);
        }
    }
}
