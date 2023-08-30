package fr.ecolenum.dd.game;

import fr.ecolenum.dd.Case.Case;
import fr.ecolenum.dd.Case.Empty.Empty;
import fr.ecolenum.dd.Case.Enemy.Dragon;
import fr.ecolenum.dd.Case.Enemy.Ennemy;
import fr.ecolenum.dd.Case.Enemy.Goblins;
import fr.ecolenum.dd.Case.Spell.Spell;
import fr.ecolenum.dd.Case.Weapon.Sword;
import fr.ecolenum.dd.Case.Weapon.Weapon;
import fr.ecolenum.dd.Case.potion.Potion;
import fr.ecolenum.dd.Case.potion.SmallPotion;
import fr.ecolenum.dd.DataBase.DataBaseMySql;
import fr.ecolenum.dd.DataBase.DbRequest;
import fr.ecolenum.dd.DataBase.DbRequest;
import fr.ecolenum.dd.Dice.DiceCanBeRoll;
import fr.ecolenum.dd.Dice.NormalDice;
import fr.ecolenum.dd.Dice.NormalDiceX2;
import fr.ecolenum.dd.Dice.PipiedDice;
import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.character.Wizzard;
import fr.ecolenum.dd.menu.Menu;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static fr.ecolenum.dd.DataBase.DataBaseMySql.getConnection;

public class Game {
    private Menu menu;
    private Character character;
    private List<Case> board;


//  MODIFICATION ARMES WARRIOR DONE // DO IT FOR WIZZARD AND SPELL
// PUT THE INTERACTION WITH USER INE MENU AND EXTRACT METHOD FOR CLEANING IT
    // AFTER GENERATE TAB OF 10 INDEX  :
        // POTION : SMALL / LARGE
        // ENEMY : GOBELIN / WITCH / DRAGON
        // SPELL : 1 / 2
       // WEAPON : 1 / 2
        // empty : 1
    // AND AFTER GENERATE RANDOM TAB FROM THIS DATA

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

    public String showMainMenu() {
        String valueUser;
        valueUser = menu.mainMenu();
        //<--- MainMenu Is a[Create character] OR b[Start game] OR c[Exit]--->
        switch (valueUser) {
            case "a":
                //<--- Create character + menu character + StartGame -->
                character = menu.createCharacter();
                CharacterGameMenu();
                break;
            case "b":
                //<--- Menu character + startGame --->
                character = new Warrior();
                character.setForceAttack(5 + ((Warrior) character).getWeaponDamage());
                CharacterGameMenu();
                break;
            case "c":
                //<--- ShowCharacter --->

                // Instanciation DbRequet
                DbRequest dataRequest = new DbRequest();
                // Stockage du retour de la méthode getHereos avec en paramètre l'objet Dbconnection
                List<Character > charArray = dataRequest.getHereos();
                System.out.println(charArray + "\nChoose your characther : ");
                for(int i = 0; i < charArray.size(); i++){
                    System.out.println((i)+ " - " + charArray.get(i));
                }
                character = charArray.get(menu.inputInt());
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
                        StartGame(nbCases, character);
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

    public void StartGame(int nbCases, Character character)  {
        List<Case> board = new ArrayList<Case>();
        board.add(new Empty(1));
        board.add(new Goblins(2));
        board.add(new Sword(3));
        board.add(new SmallPotion(4));

        int playerScore =0;
        DiceCanBeRoll dice = new PipiedDice();

        while(gameIsNotFinish(playerScore,nbCases) && playerIsAlive(character)){
            playerScore = playAround(nbCases, playerScore, dice, board, character);
        }

        if(playerScore+1 == nbCases){
            System.out.println("=========================================> !!!Congratulation you have finish the game!!! SCORE :" + (playerScore +1) +" <-=========================================\n");
        }

    }

    private int playAround(int nbCases, int playerScore, DiceCanBeRoll dice, List<Case> board, Character character) {
        System.out.println("\nSCORE : "+ (playerScore +1) + "\nRoll dice press A");
        String choicePlayer = menu.inputString();

        while(!choicePlayer.equals("a")){
            System.out.println("Wrong choice -> Roll dice press A");
            choicePlayer = inputString();
        }

        dice.rollTheDice();
        System.out.println("You roll the dice and get :" + dice.rollTheDice());
        playerScore = calculePlayerScore(playerScore, dice);


        try{
            movePayer(playerScore, nbCases);
            //DisplayBoard(movePayer(playerScore,nbCases));
        }
        catch (CharacterOutOfBoardException message){
            System.out.println(message);
            playerScore = nbCases;
        }

        if(board.get(playerScore) instanceof Ennemy){
            System.out.println("An enemy is here !\n " + board.get(playerScore) + "\nYou start the Fight");
            while(((Ennemy) board.get(playerScore)).getLifeEnemy() > 0 && playerIsAlive(character)){

                System.out.println(((Ennemy) board.get(playerScore)).getNameEnemy() + " He's attacking you receive " + ((Ennemy) board.get(playerScore)).getDamageEnemy() + " damage");
                character.setLife((character.getLife() - ((Ennemy) board.get(playerScore)).getDamageEnemy()));

                if(playerIsAlive(character)){
                    System.out.println("Strike back ! PRESS 1");
                    String rep = inputString();
                    while(!rep.equals("1")){
                        System.out.println("Bad choice for strike back ! PRESS 1");
                        rep = inputString();
                    }
                    System.out.println("You attack the ennemy and made him " + character.getForceAttack() +" Damage !");
                    ((Ennemy) board.get(playerScore)).setLifeEnemy(((Ennemy) board.get(playerScore)).getLifeEnemy() - character.getForceAttack());
                } else {
                    System.out.println("you die...");
                }

               if(((Ennemy) board.get(playerScore)).getLifeEnemy() <= 0) {
                   ((Ennemy) board.get(playerScore)).setLifeEnemy(0);
                   System.out.println("The Enemy is dead");
               }
                System.out.println("Your life level : "+ character.getLife()+"HP"+"\nThe enemy life level : " + ((Ennemy) board.get(playerScore)).getLifeEnemy()+"HP");
            }
        } else if (board.get(playerScore) instanceof Potion) {
            System.out.println("You find something !\n" + board.get(playerScore) + "\nThis is a potion !");

            if(character.getLife()< character.getMax_Life()){
                System.out.println("PRESS 1 TO USE IT OR 2 TO CONTINUE");
                String askPlayerWantUsePotion = inputString();
                while (!askPlayerWantUsePotion.equals("1") && !askPlayerWantUsePotion.equals("2")){
                    System.out.println("wrong choice");
                }

                if(askPlayerWantUsePotion.equals("1")){
                    if(character.getLife() + ((Potion) board.get(playerScore)).getHealingPotion() > character.getMax_Life()){
                        character.setLife(character.getMax_Life());
                    } else {
                        character.setLife(character.getLife()+((Potion) board.get(playerScore)).getHealingPotion());
                    }
                } else {
                    System.out.println("You put the potion down");
                }
                System.out.println("Your life level is now : "+ character.getLife() +"HP");
            } else {
                System.out.println("you already are full of life");
            }


        } else if (board.get(playerScore) instanceof Weapon) {
            if (character instanceof Warrior){
                System.out.println("You find something !\n " + board.get(playerScore) + " You take it");
                System.out.println("\nwould you like to equip it ?\n1 : YES\n2 : NO");
                String equipWeaponOrNo = inputString();
                if(equipWeaponOrNo.equals("1")){
                    ((Warrior) character).setWeapon((Weapon) board.get(playerScore));
                    character.setForceAttack(5 + ((Weapon) board.get(playerScore)).getDamageWeapon());
                    System.out.println("Your power is now : " + character.getForceAttack());
                } else {
                    System.out.println("you put the weapon down");
                }
            } else {
                System.out.println("This is not for you...");
            }
        } else if (board.get(playerScore) instanceof Spell) {
            if (character instanceof Wizzard){
                System.out.println("You find something !\n" + board.get(playerScore) + " You take it");
                System.out.println("\nwould you like to equip it ?\n1 : YES\n2 : NO");
                String equipSpellOrNo = inputString();
                if(equipSpellOrNo.equals("1")){
                    ((Warrior) character).setWeapon((Weapon) board.get(playerScore));
                } else {
                    System.out.println("you put the Spell down");
                }
            } else {
                System.out.println("This is not for you...");
            }
        } else {
            System.out.println(" there is nothing here.. \n" + board.get(playerScore) + "You can move on");
        }
        return playerScore;
    }

    private boolean playerIsAlive(Character character) {
        return character.getLife() > 0;
    }

    public boolean gameIsNotFinish(int playerScore, int nbCases) {
        return playerScore < (nbCases - 1);
    }

    public void movePayer(int playerScore, int nbCases) throws CharacterOutOfBoardException {
        //String[] gameBoard;
        //gameBoard = GenerateGameBoard(nbCases);
        if(playerScore+1 > nbCases){
            throw new CharacterOutOfBoardException("you are out of bound ");
        }
    }

    public int calculePlayerScore(int playerScore, DiceCanBeRoll dice) {
        playerScore += dice.rollTheDice();
        return playerScore;
    }

    public void DisplayBoard(String[] gameBoard) {
        System.out.print("\n######################################################\n");
        for (String Case : gameBoard) {
            System.out.print("[ " + Case + " ]");
        }
        System.out.print("\n######################################################\n");
    }

//    public  List<Case> GenerateGameBoard(int nbCases) {
//        int i= 0;
//        List<Case> boardGenerated = new ArrayList<Case>();
//        for(i=0 ; i < nbCases; i++){
//            boardGenerated.add(new Case(i));
//        }
//        return boardGenerated;
//    }

    public String inputString(){
        Scanner clavier = new Scanner(System.in);
        return clavier.nextLine();
    }

}

