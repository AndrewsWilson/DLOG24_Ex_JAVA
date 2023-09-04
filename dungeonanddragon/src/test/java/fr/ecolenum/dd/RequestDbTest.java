package fr.ecolenum.dd;

import fr.ecolenum.dd.DataBase.DataBaseMySql;
import fr.ecolenum.dd.DataBase.DbRequest;
import fr.ecolenum.dd.character.Character;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class RequestDbTest {
    @Test
    public void requestDbTestAlawaysReturnObjectCollection(){
        DbRequest request = new DbRequest();
        for(int i = 0; i < 2; i++){
            List<Character> result = request.getHereos();
            assertFalse(result.isEmpty());
            assertEquals(2,result.size());
        }
    }
    @Test
    public void dataBaseCanBeDisconnected() throws SQLException {
        Connection connectToDatabase = DataBaseMySql.getConnection();
        connectToDatabase.close();

        DbRequest request = new DbRequest();
        for(int i = 0; i < 2; i++){
            List<Character> result = request.getHereos();
            assertFalse(result.isEmpty());
            assertEquals(2,result.size());
        }
    }
}
