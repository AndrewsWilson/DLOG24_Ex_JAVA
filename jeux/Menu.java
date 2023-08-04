package jeux;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    public void start() {
        String specialization;
        List<Warrior> warriorCharactersContainer = new ArrayList<>();
        List<Wizzard> wizzardCharactersContainer = new ArrayList<>();
        String valueUser = "";



        System.out.println("Welcome to the game !");
        // -> BOUCLE TANTQUE EXIT = 0<-
        while(valueUser != "c"){
            System.out.println("Create new char PRESS : a \nModify character - PRESS : b \nExit - PRESS : c");
            valueUser = inputString();

            switch (valueUser) {
                case "a":
                    System.out.println("Choose class :\n- warrior \n- wizzard");
                    specialization = inputString();
                    switch (specialization) {
                        case "warrior":
                            Warrior warrior = createWarrior(specialization);
                            warriorCharactersContainer.add(warrior);
                            System.out.println("Congratulation ! new character have been create !");
                            getWarriorInfos(specialization, warrior);
                            break;
                        case "wizzard":
                            Wizzard wizzard = CreateWizzard(specialization);
                            wizzardCharactersContainer.add(wizzard);
                            System.out.println("Congratulation ! new character have been create !");
                            getWizzardInfos(specialization, wizzard);
                            break;
                        default:
                            System.out.println("invalid choice");
                            break;
                    };
                    break;
                case "b":
                    System.out.println("Modification personnage ");
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
    public Warrior createWarrior(String specialization) {
        int life;
        int attackPower;
        String name;
        System.out.println("Character name : ");
        name = inputString();
        System.out.println("Choose HP quantity (5-10) : ");
        life = Integer.parseInt(inputString());

        System.out.println("Choose Attack power (5-10) : ");
        attackPower = Integer.parseInt(inputString());

        Weapon weapon = new Weapon();
        Warrior warrior = new  Warrior(name, weapon, life,attackPower );
        return warrior;
    }

    public Wizzard CreateWizzard(String specialization) {
        int life;
        int attackPower;
        String name;
        System.out.println("Character name : ");
        name = inputString();
        System.out.println("Choose HP quantity (3-6) : ");
        life = Integer.parseInt(inputString());

        System.out.println("Choose Attack power (8-15) : ");
        attackPower = Integer.parseInt(inputString());

        Spell spell = new Spell();
        Wizzard wizzard = new Wizzard(name, spell, life, attackPower);

        return wizzard;
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