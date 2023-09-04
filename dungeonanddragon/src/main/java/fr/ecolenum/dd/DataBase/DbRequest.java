package fr.ecolenum.dd.DataBase;

import fr.ecolenum.dd.character.Character;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DbRequest class used to make request to the database
 */
// DAO = Data Access Object
public class DbRequest {
    /**
     * getHereos méthode is used to return collection of object of Character type
     * @return collection object of hereos
     */
    public List<Character> getHereos(){
        List<Character> charArray = new ArrayList<Character>();

        try
        {
            Connection conn = DataBaseMySql.getConnection();
            //étape 1: Création de l'objet statement
            Statement stmt = conn.createStatement();

            //étape 2: execution de la requette SQL et stocage du resultat dans res de type ResultSet
            ResultSet result = stmt.executeQuery("SELECT * FROM hero");

            //étape 3: stockage des données de la requette
            while(result.next()) {
                // stockate du type de charactère récupéré dans la column label "type"
                Class<Character> className = (Class<Character>) Class.forName("fr.ecolenum.dd.character."+result.getString("type"));
                // création d'un objet de type correspondant a la valeur de la column label "type" de la BDD soit Warrior soit Wizzard
                Character character = className.getDeclaredConstructor
                        (
                                // utilisation du constructor comprenant les paramètre dans l'ordre suivant
                                String.class, int.class,int.class
                        ).newInstance
                        (
                                // Valeur des paramètres a attribuer dans le constructeur de l'instance crée
                                result.getString("name"),result.getInt("life"),result.getInt("attack")
                        );
                charArray.add(character);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        // renvoie la list charArray dans menu
        return charArray;
    }
}
