package fr.ecolenum.dd.Dice;

public class NormalDiceX2 implements DiceCanBeRoll{
    public int rollTheDice(){
        int dice = 0;
        for (int i=0; i<2;i++){
            dice += 1 + (int)(Math.random() * ((6 - 1) +1));
        }
        return dice;
    }
}
