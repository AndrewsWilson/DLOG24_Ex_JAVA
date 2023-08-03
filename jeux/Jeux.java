package jeux;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Jeux {
    public void lancement() {
        String specialization;
        String name;
        int life;
        int attackPower;
        List<Warrior> warriorCharacters = new ArrayList<>();
        List<Wizzard> wizzardCharacters = new ArrayList<>();
        int exit = 0;
        int valueUser = 0;

        Scanner clavier = new Scanner(System.in);
        System.out.println("Welcome to the game !");

        // -> BOUCLE TANTQUE EXIT = 0<-
        while(exit != 3){
            System.out.println("Create new char PRESS : 1 ");
            System.out.println("Modify character - PRESS : 2");
            System.out.println("Exit - PRESS : 3");
            valueUser = clavier.nextInt();



            if(valueUser == 1){
                //->Creation de personnage<-
                System.out.println("Choose class :\n (1) - warrior \n (2)- wizard");
                specialization = clavier.nextLine();
                clavier.nextLine();

                System.out.println("Character name warrior : ");
                name = clavier.nextLine();

                if(specialization == "warrior"){
                    System.out.println("Choose HP quantity (5-10) : ");
                    life = clavier.nextInt();
                    System.out.println("Choose Attack power (5-10) : ");
                    attackPower = clavier.nextInt();
                    Weapon weapon = new Weapon();
                    Warrior warrior = new  Warrior(name, weapon, life,attackPower );
                    warriorCharacters.add(warrior);
                    System.out.println("Congratulation ! new character have been create !");
                    System.out.println("current character info : \n"+ specialization+"\n"+warrior.getName()+"\n"+warrior.getArme()+"\n"+warrior.getLife()+"\n"+warrior.getForceAttack());
                } else {
                    System.out.println("Choose HP quantity (3-6) : ");
                    life = clavier.nextInt();
                    System.out.println("Choose Attack power (8-15) : ");
                    attackPower = clavier.nextInt();
                    Spell spell = new Spell();
                    Wizzard wizzard = new Wizzard(name, spell, life, attackPower);
                    wizzardCharacters.add(wizzard);
                    System.out.println("Congratulation ! new character have been create !");
                    System.out.println("current character info : \n" + specialization + "\n" + wizzard.getName() + "\n" + wizzard.getSort() + "\n" + wizzard.getLife() + "\n" + wizzard.getForceAttack());
                }
            } else if (valueUser == 2){
                System.out.println("Modification personnage ");
            } else {
                exit = 3;
            }

        }
        System.out.println("Fin de partie à bientot !");
    }
}