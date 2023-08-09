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

    public void startEngine() {
        // <--- Menu Start or Exit game --->
        String valueUser;
        valueUser =  menu.start();
        //<-- if use choose a[START GAME] b[EXIT PROGRAM]-->
        switch (valueUser){
            case "a":
                //<-- while User don't want Exit Main menu-->
                while(!valueUser.equals("c")) {
                    //<--- showMainMenu --->
                    valueUser = showMainMenu();
                }
            break;
            case "b":
                break;
            default:
                System.out.println("WRONG CHOICE CHOOSE (A) OR (B) ");
                break;
        }
    }

    private String showMainMenu() {
        String valueUser;
        valueUser = menu.mainMenu();
        //<--- MainMenu Is a[Create character] OR b[Start game] OR c[Exit]--->
        switch (valueUser) {
            case "a":
                //<--- Create character + menu character + StartGame -->
                this.character = menu.createCharacter();
                CharacterGameMenu();
                break;
            case "b":
                //<--- Menu character + startGame --->
                this.character = new Warrior();
                CharacterGameMenu();
                break;
            default:
                //<-- Exit game-->
                break;
        }
        return valueUser;
    }

    private void CharacterGameMenu() {
        String ChoiceUser = "a";
        //<-- while user don't want Exit characterGameMenu-->
        while(!ChoiceUser.equals("d")){
            ChoiceUser = menu.showCharacterGameMenu();
            switch (ChoiceUser){
                case "a":
                    menu.changeCharacterStats(character);
                    break;
                case "b":
                    menu.showCharacterStats(character);
                    break;
                case "c":
                    while(ChoiceUser.equals("c")){
                        int nbCases = menu.chooseNbOfCaseOfBoard();
                        StartGame(nbCases);
                        ChoiceUser = menu.askUserWantToReplayOrExit();
                    }
                    break;
                case "d":
                    // <-- Exite character Game Menu -->
                    break;
                default :
                    // <-- back to character game Menu -->
                    break;
            }
        }
    }

    public void StartGame(int nbCases)  {
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

