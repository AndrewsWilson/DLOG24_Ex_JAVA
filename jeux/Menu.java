package jeux;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    public void start() {
        String specialization ="";
        String valueUser = "";

        while(valueUser != "c"){
            System.out.println("Welcome to the game !\nCreate new char PRESS : a\n Exit PRESS C");
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
                    System.out.println("Invalid choice");;
                    break;
            }
        }
    }








    private void ChoiceClassMenu(String specialization) {
        switch (specialization) {
            case "warrior":
                warriorMenu(specialization);
                break;
            case "wizzard":
                CreateWizzard(specialization);
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
        ;
    }

    public Warrior createWarrior(String specialization) {
        int life;
        int attackPower;

        System.out.println("Character name : ");
        String name = inputString();
        System.out.println("Choose HP quantity (5-10) : ");
        life = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (5-10) : ");
        attackPower = Integer.parseInt(inputString());


        Weapon weapon = new Weapon();
        Warrior warrior = new  Warrior(name, weapon, life,attackPower );
        System.out.println("Congratulation Warrior has been created ");


        return warrior;
    }

    public Wizzard CreateWizzard(String specialization) {
        int life;
        int attackPower;
        String name;


        name = inputString();
        System.out.println("Character name : ");
        life = Integer.parseInt(inputString());
        System.out.println("Choose HP quantity (3-6) : ");
        attackPower = Integer.parseInt(inputString());
        System.out.println("Choose Attack power (8-15) : ");

        Spell spell = new Spell();
        Wizzard wizzard = new Wizzard(name, spell, life, attackPower);
        System.out.println("Congratulation Wizzard has been created ");

        return wizzard;
    }

    public void warriorMenu(String specialization){
        Warrior warrior = createWarrior(specialization);
        System.out.println("Warrior menu : \n");
        String choiceUser;
        System.out.println("a - modify character\n b- Display information \nc- exite Warrior menu");
        choiceUser = inputString();

        warriorMenuList(specialization, choiceUser, warrior);

    }

    private void warriorMenuList(String specialization, String choiceUser, Warrior warrior) {
        switch (choiceUser) {
            case "a":
                warriorSetting(warrior);
                break;
            case "b":
                getWarriorInfos(specialization, warrior);
                break;
            case "c":
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
        ;
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
        System.out.println("Wizzard menu : \n");
        String choiceUser = "";
        System.out.println("a - Modify character\n b - Display information \nc- exite Wizzard menu");
        wizzardMenuList(specialization, choiceUser, wizzard);

    }

    private void wizzardMenuList(String specialization, String choiceUser, Wizzard wizzard) {
        switch (choiceUser) {
            case "a":
                wizzardSetting(wizzard);
                break;
            case "b":
                getWizzardInfos(specialization, wizzard);
                break;
            case "c":
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


    public void getWarriorInfos(String specialization, Warrior warrior){
        System.out.println("current character info : \n"
                +"Spécialization : "+specialization+"\n"
                +"Name : "+warrior.getName()+"\n"
                +"Weapon : "+warrior.getArme()+"\n"
                +"HP : "+warrior.getLife()+"\n"
                +"Force Attack : "+warrior.getForceAttack()
        );
    }

    public void getWizzardInfos(String specialization, Wizzard wizzard){
        System.out.println("current character info : \n"
                +"Spécialization : "+ specialization + "\n"
                +"Name : "+ wizzard.getName() + "\n"
                +"Spell : "+ wizzard.getSort() + "\n"
                +"HP : "+ wizzard.getLife() + "\n"
                +"Force Attack : "+ wizzard.getForceAttack());
    }




    public String inputString(){
        Scanner clavier = new Scanner(System.in);
        return clavier.nextLine();
    }
}