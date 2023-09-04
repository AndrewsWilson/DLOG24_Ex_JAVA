package fr.ecolenum.dd.menu;

import fr.ecolenum.dd.Case.Spell.Lights;
import fr.ecolenum.dd.Case.Weapon.Hammer;
import fr.ecolenum.dd.Case.Spell.Spell;
import fr.ecolenum.dd.Case.Weapon.Weapon;
import fr.ecolenum.dd.character.*;
import fr.ecolenum.dd.character.Character;

import java.util.Scanner;

/**
 * class used to make interaction with user
 */
public class Menu {
    /**
     * methode used tu show start menu to user
     * @return value selected by user
     */
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

    /**
     * method user to ask player want replay or exit
     * @return return value enter by user
     */
    public String askUserWantToReplayOrExit() {
        String valueUser;
        System.out.println("\nCharacter game menu \nc - Restart \ne- Back to character Game Menu");
        valueUser = inputString();
        return valueUser;
    }

    /**
     * method main menu usert to show player main menu
     * @return choice value of the user
     */
    public String mainMenu(){
        System.out.println("\nCreate Character PRESS : A \nStart game : B \nChoose Character C\nExit PRESS : D");
        String valueUser = inputString();

        while(!valueUser.equals("a") && !valueUser.equals("b") && !valueUser.equals("c") && !valueUser.equals("d")){
            System.out.println("\nCreate Character PRESS : A \nStart game : B \nChoose Character C\nExit PRESS : D");
            valueUser = inputString();
        }

        if(valueUser.equals("a")){
            return "a";
        } else if (valueUser.equals("b")) {
            return "b";
        } else if (valueUser.equals("c")) {
            return "c";
        } else {
            System.out.println("END GAME SEE YOU SOON");
            return "d" ;
        }
    }

    /**
     * createcharacter method user to show the create character menu to user
     * @return return choice value user
     */
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

    /**
     * method create wizzard
     * @return value wizzard object
     */
    private Character createWizzard() {
        System.out.println("fr.ecolenum.dd.character.Character name : ");
        String name = inputString();
        System.out.println("Choose HP quantity (3-6) : ");
        int life = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (8-15) : ");
        int attackPower = Integer.parseInt(inputString());


        Spell spell = new Lights(0);
        Character wizzard = new Wizzard(name, attackPower, life);
        System.out.println("Congratulation fr.ecolenum.dd.character.Wizzard has been created ");
        return wizzard;
    }

    /**
     * methode create warrior used to show create warrior menu to user and create object warrior
     * @return return object warrior
     */
    private Character createWarrior() {
        System.out.println("fr.ecolenum.dd.character.Character name : ");
        String name = inputString();
        System.out.println("Choose HP quantity (5-10) : ");
        int life = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (5-10) : ");
        int attackPower = Integer.parseInt(inputString());
        Weapon weapon = new Hammer(0);
        Character warrior = new Warrior(name, weapon );
        warrior.setForceAttack((warrior.getForceAttack() + weapon.getDamageWeapon()));
        System.out.println("Congratulation fr.ecolenum.dd.character.Wizzard has been created ");
        return warrior;
    }

    /**
     * method character stat used to show stat's character to user
     * @param character object character
     */
    public void showCharacterStats(Character character){
        System.out.println(character.toString());
    }

    /**
     * method used to modify character stat
     * @param character character object
     */
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

    /**
     * method user to show character game menu to user
     * @return user choice (string)
     */
    public String showCharacterGameMenu(){
        System.out.println("\nA - Modify character\nB - Show information \nC - Start game \nD - Exit character menu");
        return inputString();
    }

    /**
     * method used to show choice nbOfCAse menu to user
     * @return choice user (int)
     */
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
