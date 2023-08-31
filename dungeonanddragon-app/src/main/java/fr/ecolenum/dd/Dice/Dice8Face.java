package fr.ecolenum.dd.Dice;

public class Dice8Face implements DiceCanBeRoll{
    public int rollTheDice(){
        int dice = 0;
        dice = 1 + (int)(Math.random() * ((8 - 1) +1));
        return dice;
    }
}
