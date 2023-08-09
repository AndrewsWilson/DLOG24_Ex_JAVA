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





    public String WantToCreateCharacter(){
        System.out.println("\nCreate Character PRESS A \n Start game B\nExit PRESS C");
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


    public Character ChoiceClassMenu() {
        System.out.println("Choose specialisation\n- WARRIOR\n- WIZZARD");
        String specialization = inputString();
        while(!specialization.equals("warrior")&&!specialization.equals("wizzard")){
            System.out.println("Error chose warrior OR wizzard please");
            specialization = inputString();
        }

        if(specialization.equals("warrior")){
            return createWarrior();
        } else {
            return CreateWizzard();
        }
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

    public void characterSetting(Character character) {
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


    public String characterMenuList(Character character) {
        System.out.println("\nmenu : \na - modify character\nb- show information \nc- start game \nd- Exit character menu");
        return inputString();
    }

    public int chooseNbOfCase() {
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
