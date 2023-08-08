package fr.ecolenum.dd.menu;

import fr.ecolenum.dd.character.*;
import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.game.Board;

import java.util.Scanner;


public class Menu {

    public void start() {
        String specialization ="";
        String valueUser = "";
        while(valueUser != "c"){
            System.out.println("Welcome to the game !\nCreate new char PRESS : a\nExit PRESS C");
            valueUser = inputString();
            switch (valueUser) {
                case "a":
                    System.out.println("Choose class :\n- warrior \n- wizzard");
                    specialization = inputString();
                    ChoiceClassMenu(specialization);
                    break;
                case "c":
                    valueUser= "c";
                    System.out.println("Fin de partie à bientot !");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public void ChoiceClassMenu(String specialization) {
        switch (specialization) {
            case "warrior":
                characterMenu(specialization);
                break;
            case "wizzard":
                characterMenu(specialization);
                break;
            default:
                System.out.println("invalid choice");
                break;
        };
    }

    public Character createWarrior() {
        System.out.println("fr.ecolenum.dd.character.Character name : ");
        String name = inputString();
        System.out.println("Choose HP quantity (5-10) : ");
        int life = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (5-10) : ");
        int attackPower = Integer.parseInt(inputString());


        Weapon weapon = new Weapon();
        Character warrior = new Warrior(name, life, attackPower, weapon );
        System.out.println("Congratulation fr.ecolenum.dd.character.Warrior has been created ");


        return warrior;
    }

    public Character CreateWizzard() {
        System.out.println("fr.ecolenum.dd.character.Character name : ");
        String name = inputString();
        System.out.println("Choose HP quantity (3-6) : ");
        int life = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (8-15) : ");
        int attackPower = Integer.parseInt(inputString());


        Spell spell = new Spell();
        Character wizzard = new Wizzard(name, spell, life, attackPower);
        System.out.println("Congratulation fr.ecolenum.dd.character.Wizzard has been created ");

        return wizzard;
    }

    public void getCharacterInfos(Character character){
        System.out.println(character.toString());
    }

    private void characterSetting(Character character) {
        String name;
        int life;
        int forceAttack;
        System.out.println("New name : ");
        name = inputString();
        System.out.println("New life level: ");
        life = Integer.parseInt(inputString());
        System.out.println("New life level: ");
        forceAttack = Integer.parseInt(inputString());
        character.setName(name);
        character.setLife(life);
        character.setForceAttack(forceAttack);
    }

    public void characterMenu(String specialization){
        System.out.println();
        switch (specialization){
            case "wizzard" :
               Character wizzard = CreateWizzard();
               characterMenuList(wizzard);
                break;
            case "warrior" :
                Character warrior = createWarrior();
                characterMenuList(warrior);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    private void characterMenuList( Character character) {

        System.out.println("\nmenu : \na - modify character\nb- show information \nc- start game \nd- Exit character menu");
        String choiceUser;
        choiceUser = inputString();

        switch (choiceUser) {
            case "a":
                characterSetting(character);
                break;
            case "b":
                getCharacterInfos(character);
                break;
            case "c":
                while(choiceUser.equals("c")){
                    System.out.println("Define the length of the board (0-64)");
                    int nbCases = inputInt();
                    Board board = new Board(nbCases);
                    board.startGame();
                    System.out.println(" \nc - Restart \nv- Exit");
                    choiceUser = inputString();
                }
                break;
            case "d":
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
    }


    private String ChoiceUserString() {
        String choiceUser;
        choiceUser = inputString();
        return choiceUser;
    }

    private int ChoiceUserInt() {
        int choiceUser;
        choiceUser = inputInt();
        return choiceUser;
    }
    public String inputString(){
        Scanner clavier = new Scanner(System.in);
        return clavier.nextLine();
    }

    public int inputInt(){
        Scanner clavier = new Scanner(System.in);
        return clavier.nextInt();
    }
}
