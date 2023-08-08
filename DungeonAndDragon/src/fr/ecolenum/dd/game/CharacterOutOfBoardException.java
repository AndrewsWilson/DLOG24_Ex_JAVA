package fr.ecolenum.dd.game;

public class CharacterOutOfBoardException extends Exception{

    public CharacterOutOfBoardException(String message){
        super(message);
    }
}
