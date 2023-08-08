package fr.ecolenum.dd.game;

import java.util.Scanner;

public class Board {
    private int nbCase;

    public Board(int nbCases) {
        this.nbCase = nbCases;
    }

    public void startGame() {
        System.out.println("StartGame");
            boardGame();
    }

    public void boardGame()  {
        String []gameBoard = GenerateGameBoard(nbCase);
        int playerScore =0;
        gameBoard[playerScore] = "[[PLAYER]]";
        DisplayBoard(gameBoard);


        while(gameIsNotFinish(playerScore)){
            System.out.println("\nSCORE : "+ (playerScore +1) + "\nRoll dice press A");
            String choicePlayer = inputString();

            while(!choicePlayer.equals("a")){
                System.out.println("Wrong choice -> Roll dice press A");
                choicePlayer = inputString();
            }

            int dice = rollDice();
            System.out.println("You roll the dice and get :" + dice);
            playerScore = calculePlayerScore(playerScore, dice);


            try{
                movePayer(playerScore);
                DisplayBoard(movePayer(playerScore));
            }
            catch (CharacterOutOfBoardException message){
                System.out.println(message);
                playerScore = gameBoard.length-1;
            }

        }
            if(playerScore+1 == nbCase){
                System.out.println("=========================================> !!!Congratulation you have finish the game!!! SCORE :" + (playerScore +1) +" <-=========================================\n");
            }

    }

    public boolean gameIsNotFinish(int playerScore) {
        if(playerScore < (nbCase -1)){
            return true;
        }
        return false;
    }

    public String[] movePayer(int playerScore) throws CharacterOutOfBoardException {
        String[] gameBoard;
        gameBoard = GenerateGameBoard(nbCase);
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

    public  String[] GenerateGameBoard(int nbCase) {
        int i= 0;
        String[]gameBoard = new String[nbCase];
        for(i=0 ; i < nbCase; i++){
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

