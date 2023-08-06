package jeux;
import java.util.Scanner;

public class WarriorGame {
    private int nbCase = 64;
    
    public WarriorGame() {}


    public void startGame(){
        System.out.println("StartGame");
        Game();
    }

    private void Game() {
        String []gameBoard = GenerateGameBoard(nbCase);
        int playerPosition =0;
        gameBoard[playerPosition] = "Warrior";
        DisplayBoard(gameBoard);


        while(playerPosition <(nbCase-1)){
            System.out.println("\nSCORE : "+ playerPosition + "\nRoll dice press A");
            String choicePlayer = inputString();

            while(!choicePlayer.equals("a")){
                System.out.println("Wrong choice -> Roll dice press A");
            }

            int dice = rollDice();
            System.out.println("You roll the dice and get :" + dice);
            playerPosition = movePlayer(playerPosition, dice, gameBoard);
            gameBoard = showPlayerPosition(playerPosition);
            DisplayBoard(gameBoard);
        }

        if(playerPosition == nbCase){
            System.out.println("Congratulation you have finish the game !");
        }
    }

    private String[] showPlayerPosition(int playerPosition) {
        String[] gameBoard;
        gameBoard = GenerateGameBoard(nbCase);
        gameBoard[playerPosition] = "[[WARRIOR]]";
        return gameBoard;
    }

    private int movePlayer(int playerPosition, int dice, String[] gameBoard) {
        playerPosition += dice;

        if(playerPosition > gameBoard.length){
            playerPosition = gameBoard.length;
        }
        return playerPosition;
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

