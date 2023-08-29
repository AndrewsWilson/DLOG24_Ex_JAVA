package fr.ecolenum.dd.DataBase;

import fr.ecolenum.dd.character.Character;

import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class DataBaseMySql {
    public List<Character> getHereos(){
        List<Character> charArray = new ArrayList<Character>();
        try
        {
        //## ACCES BDD##
            //étape 1: chargement classe driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // étape 2 : récupération LOGIN &  PW dans le fichier .env
            Properties prop = new Properties();
            prop.load(new FileInputStream(".env"));
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String url = prop.getProperty("url");


            // cétape 3 : connexion à la BDD
            Connection conn = DriverManager.getConnection(url, username, password);
            //étape 3: Création de l'objet statement
            Statement stmt = conn.createStatement();
            //étape execution de la requette SQL et stocage du resultat dans res de type ResultSet
            ResultSet res = stmt.executeQuery("SELECT * FROM heroes");
            //étape 4: affichage des donnée stocker dans la propriété res

            //Etape 5 Création d'objects de type "Character"  a partir avec comme paramètres les données de la BDD
            while(res.next()) {
                Class<Character> className = (Class<Character>) Class.forName("fr.ecolenum.dd.character."+res.getString(2));
                Character character = className.getDeclaredConstructor
                        (
                            String.class, int.class,int.class
                        ).newInstance
                        (
                            res.getString("nom"),res.getInt("niveauvie"),res.getInt("niveauforce")
                        );
                charArray.add(character);
            }
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        // renvoie la list charArray dans menu
        return charArray;
    }
}
