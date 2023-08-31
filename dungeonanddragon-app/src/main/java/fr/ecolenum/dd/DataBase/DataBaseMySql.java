package fr.ecolenum.dd.DataBase;

import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class DataBaseMySql {
    // propriété de type objet connection
    private static Connection  DbConnection;
    // constructor qui instancie ma fonction DatabaseConnection et qui s'occupe dede généré l'objet connection
    private DataBaseMySql(){
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
            DbConnection = DriverManager.getConnection(url, username, password);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //methode getConnection qui s'occupe d'envoyer l'objet dbConnection ou de crée une instance de DataBaseMySql et retourne DbConnection
    public static Connection getConnection(){
        if(DbConnection == null){
            new DataBaseMySql();
        }
        return DbConnection;
    }
}
