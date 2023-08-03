package jeux;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeux {
    public void lancement() {
        String nom;
        String classe;


        Scanner clavier = new Scanner(System.in);
        System.out.println("Bienvenu !");
        System.out.println("Choissisez une classe : \n  - guerrier \n  - magicien (en charatère) ");
        classe = clavier.nextLine();
        System.out.println("Choissisez le nom de votre personnage : ");
        nom = clavier.nextLine();


        if(classe == "guerrier"){
            Arme arme = new Arme();
            Guerrier guerrier = new Guerrier(nom, arme);
            System.out.println("Infos personnage crée : \n"+ classe+"\n"+guerrier.getNom()+"\n"+guerrier.getArme());
        } else {
            Sort sort = new Sort();
            Magicien magicien = new Magicien(nom, sort);
            System.out.println("Infos personnage crée : \n"+ classe+"\n"+magicien.getNom()+"\n"+magicien.getSort());
        }



    }
}