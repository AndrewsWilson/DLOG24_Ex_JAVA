package fr.ecolenum.dd.menu;

import fr.ecolenum.dd.character.*;
import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.game.Game;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;


public class Menu {

    public String start() {
        String specialization;
        System.out.println("Welcome to the game !\nSTART GAME PRESS A\nEXIST GAME PRESS B");
        String valueUser = inputString();

        switch (valueUser) {
            case "a":
                break;
            case "b":
                System.out.println("END GAME SEE YOU SOON ... ! ");
        }
        return valueUser;
    }

    public String askUserWantToReplayOrExit() {
        String valueUser;
        System.out.println("\nCharacter game menu \nc - Restart \ne- Back to character Game Menu");
        valueUser = inputString();
        return valueUser;
    }


    public String WantToCreateCharacter(){
        System.out.println("\nCreate Character PRESS : A \n Start game : B\nExit PRESS : C");
        String valueUser = inputString();

        while(!valueUser.equals("a") && !valueUser.equals("b") && !valueUser.equals("c")){
            System.out.println("\nBAD CHOICE : Create Character PRESS A \n Start game B\nExit PRESS C");
            valueUser = inputString();
        }

        if(valueUser.equals("a")){
            return "a";
        } else if (valueUser.equals("b")) {
            return "b";
        } else {
            System.out.println("END GAME SEE YOU SOON");
            return "c" ;
        }
    }


    public Character createCharacter() {
        System.out.println("Choose specialisation\n- WARRIOR\n- WIZZARD");
        String TypeOfCharacter = inputString();

        if(TypeOfCharacter.equals("warrior")){
            Character warrior = createWarrior();
            return warrior;
        } else {
            Character wizzard = createWizzard();
            return wizzard;
        }


    }

    private Character createWizzard() {
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

    private Character createWarrior() {
        System.out.println("fr.ecolenum.dd.character.Character name : ");
        String name = inputString();
        System.out.println("Choose HP quantity (5-10) : ");
        int life = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (5-10) : ");
        int attackPower = Integer.parseInt(inputString());
        Weapon weapon = new Weapon();
        Character warrior = new Warrior(name, life, attackPower, weapon );
        System.out.println("Congratulation fr.ecolenum.dd.character.Wizzard has been created ");
        return warrior;
    }

    public void showCharacterStats(Character character){
        System.out.println(character.toString());
    }

    public void changeCharacterStats(Character character) {
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


    public String showCharacterGameMenu(){
        System.out.println("\na - modify character\nb- show information \nc- start game \nd- Exit character menu");
        return inputString();
    }

    public int chooseNbOfCaseOfBoard() {
        System.out.println("Define the length of the board (0-64)");
        return inputInt();
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
