package fr.ecolenum.dd.game;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.menu.Menu;

import java.util.Scanner;

public class Game {
    private Menu menu;
    private int nbCase;
    private Character character;

    public Game() {
        this.menu = new Menu();
    }

    public void startGame() {

        String valueUser;
        // <--- Start or Exit game --->
        valueUser =  menu.start();

        switch (valueUser){
            //<-- if a START GAME-->
            case "a":
                //<--- Create character OR Start game OR Exit--->
              valueUser = menu.WantToCreateCharacter();
                switch (valueUser){
                    case "a":
                        //<--- Create character + menu character + StartGame -->
                        this.character = menu.ChoiceClassMenu();
                        CharacterGameMenu();
                        break;
                    case "b" :
                        //<--- Menu character + startGame --->
                        this.character = new Warrior();
                        CharacterGameMenu();
                        break;
                    default :
                        //<--- exit --->
                        break;
                }
            break;
            case "b":
                break;
            default:
                System.out.println("WRONG CHOICE CHOOSE (A) OR (B) ");
                break;
        }
    }

    private void CharacterGameMenu() {
        String valueUser = "a";
        while(!valueUser.equals("d")){
            valueUser = menu.characterMenuList(character);
            switch (valueUser){
                case "a":
                    menu.characterSetting(character);
                    break;
                case "b":
                    menu.getCharacterInfos(character);
                    break;
                case "c":
                    while(valueUser.equals("c")){
                        int nbCases = menu.chooseNbOfCase();
                        boardGame(nbCases);
                        System.out.println("GAME menu \nc - Restart \ne- Exit");
                        valueUser = inputString();
                    }
                    break;
                case "d":
                    System.out.println("d- Exit game menu");
                    break;
                default :
                    System.out.println("Exit character  menu");
                    valueUser = menu.characterMenuList(character);
            }
        }
    }

    public void boardGame(int nbCases)  {
        String []gameBoard = GenerateGameBoard(nbCases);
        int playerScore =0;
        gameBoard[playerScore] = "[[PLAYER]]";
        DisplayBoard(gameBoard);

        while(gameIsNotFinish(playerScore,nbCases)){
            System.out.println("\nSCORE : "+ (playerScore +1) + "\nRoll dice press A");
            String choicePlayer = menu.inputString();

            while(!choicePlayer.equals("a")){
                System.out.println("Wrong choice -> Roll dice press A");
                choicePlayer = inputString();
            }

            int dice = rollDice();
            System.out.println("You roll the dice and get :" + dice);
            playerScore = calculePlayerScore(playerScore, dice);


            try{
                movePayer(playerScore,nbCases);
                DisplayBoard(movePayer(playerScore,nbCases));
            }
            catch (CharacterOutOfBoardException message){
                System.out.println(message);
                playerScore = gameBoard.length-1;
            }

        }
            if(playerScore+1 == nbCases){
                System.out.println("=========================================> !!!Congratulation you have finish the game!!! SCORE :" + (playerScore +1) +" <-=========================================\n");
            }

    }

    public boolean gameIsNotFinish(int playerScore, int nbCases) {
        return playerScore < (nbCases - 1);
    }

    public String[] movePayer(int playerScore, int nbCases) throws CharacterOutOfBoardException {
        String[] gameBoard;
        gameBoard = GenerateGameBoard(nbCases);
        if(playerScore > gameBoard.length-1){
            throw new CharacterOutOfBoardException("you are out of bound ");
        }
        gameBoard[playerScore] = "[[PLAYER]]";
        return gameBoard;
    }

    public int calculePlayerScore(int playerScore, int dice) {
        playerScore += dice;
        return playerScore;
    }

    public void DisplayBoard(String[] gameBoard) {
        System.out.print("\n######################################################\n");
        for (String Case : gameBoard) {
            System.out.print("[ " + Case + " ]");
        }
        System.out.print("\n######################################################\n");
    }

    public  String[] GenerateGameBoard(int nbCases) {
        int i= 0;
        String[]gameBoard = new String[nbCases];
        for(i=0 ; i < nbCases; i++){
            gameBoard[i] = "case n"+ (i+1);
        }
        return gameBoard;
    }

    public int rollDice(){
        int dice = 0;
        dice = 1 + (int)(Math.random() * ((6 - 1) +1));
        return dice;
    }

    public String inputString(){
        Scanner clavier = new Scanner(System.in);
        return clavier.nextLine();
    }

}

