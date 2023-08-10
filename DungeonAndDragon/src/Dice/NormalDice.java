package Dice;

public class NormalDice implements DiceCanBeRoll{
    public int rollTheDice(){
        int dice = 0;
        dice = 1 + (int)(Math.random() * ((6 - 1) +1));
        return dice;
    }
}
