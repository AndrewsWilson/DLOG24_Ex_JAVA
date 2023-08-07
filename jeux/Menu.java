package jeux;

import java.util.ArrayList;
import java.util.List;
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
                warriorMenu(specialization);
                break;
            case "wizzard":
                wizzardMenu(specialization);
                break;
            default:
                System.out.println("invalid choice");
                break;
        };
    }

    public Warrior createWarrior(String specialization) {
        System.out.println("Character name : ");
        String name = inputString();
        System.out.println("Choose HP quantity (5-10) : ");
        int life = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (5-10) : ");
        int attackPower = Integer.parseInt(inputString());


        Weapon weapon = new Weapon();
        Warrior warrior = new  Warrior(name, life, attackPower, weapon );
        System.out.println("Congratulation Warrior has been created ");


        return warrior;
    }

    public Wizzard CreateWizzard(String specialization) {
        System.out.println("Character name : ");
        String name = inputString();
        System.out.println("Choose HP quantity (3-6) : ");
        int life = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (8-15) : ");
        int attackPower = Integer.parseInt(inputString());


        Spell spell = new Spell();
        Wizzard wizzard = new Wizzard(name, spell, life, attackPower);
        System.out.println("Congratulation Wizzard has been created ");

        return wizzard;
    }

    public void warriorMenu(String specialization){
        Warrior warrior = createWarrior(specialization);
        System.out.println("Warrior menu : \n");
        String choiceUser;
        System.out.println("a - modify character\nb- Display information \nc- start game \nd- exit Warrior menu");
        choiceUser = inputString();
        warriorMenuList(specialization, choiceUser, warrior);

    }

    public void warriorMenuList(String specialization, String choiceUser, Warrior warrior) {
        switch (choiceUser) {
            case "a":
                warriorSetting(warrior);
                break;
            case "b":
                getWarriorInfos(warrior);
                break;
            case "c":
                System.out.println("Define the length of the board (0-64)");
                int nbCases = inputInt();
                Board board = new Board(nbCases);
                board.startGame();
                System.out.println("a- restart game \nb- exit game");
                choiceUser = ChoiceUser();
                while (choiceUser.equals("a")){
                    System.out.println("Define the length of the board (0-64)");
                    nbCases = inputInt();
                    board = new Board(nbCases);
                    board.startGame();
                    System.out.println("a- restart game \nb- exit game");
                    choiceUser = inputString();
                };
                break;
            case "d":
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
        ;
    }

    private String ChoiceUser() {
        String choiceUser;
        choiceUser = inputString();
        return choiceUser;
    }

    private void warriorSetting(Warrior warrior) {
        String name;
        int life;
        int forceAttack;
        System.out.println("New name : ");
        name = inputString();
        System.out.println("New life level: ");
        life = Integer.parseInt(inputString());
        System.out.println("New life level: ");
        forceAttack = Integer.parseInt(inputString());
        warrior.setName(name);
        warrior.setLife(life);
        warrior.setForceAttack(forceAttack);
    }

    public void wizzardMenu(String specialization){
        Wizzard wizzard = CreateWizzard(specialization);
        System.out.println();
        String choiceUser;
        System.out.println("\nWizzard menu : \na - modify character\nb- Display information \nc- start game \nd- exit Wizzard menu");
        choiceUser = inputString();
        wizzardMenuList(specialization, choiceUser, wizzard);
    }

    private void wizzardMenuList(String specialization, String choiceUser, Wizzard wizzard) {
        switch (choiceUser) {
            case "a":
                wizzardSetting(wizzard);
                break;
            case "b":
                getWizzardInfos(wizzard);
                break;
            case "c":
                System.out.println("Define the length of the board (0-64)");
                int nbCases = inputInt();
                Board board = new Board(nbCases);
                board.startGame();
                System.out.println("a- restart game \nb- exit game");
                choiceUser = ChoiceUser();
                while (choiceUser.equals("a")){
                    System.out.println("Define the length of the board (0-64)");
                    nbCases = inputInt();
                    board = new Board(nbCases);
                    board.startGame();
                    System.out.println("a- restart game \nb- exit game");
                    choiceUser = inputString();
                };
                break;
            case "d":
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
        ;
    }

    private void wizzardSetting(Wizzard wizzard) {
        String name;
        int life;
        int forceAttack;
        System.out.println("New name : ");
        name = inputString();
        System.out.println("New life level: ");
        life = Integer.parseInt(inputString());
        System.out.println("New life level: ");
        forceAttack = Integer.parseInt(inputString());
        wizzard.setName(name);
        wizzard.setLife(life);
        wizzard.setForceAttack(forceAttack);
    }

    public void getWarriorInfos(Warrior warrior){
        System.out.println(warrior.toString());
    }

    public void getWizzardInfos(Wizzard wizzard){
           System.out.println(wizzard.toString());
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


