package fr.ecolenum.dd;
import fr.ecolenum.dd.DataBase.DataBaseMySql;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;


public class DataBaseTest {
    @Test
    public void DataBaseAlwaysReturnDataBaseLink() throws SQLException {

        for (int i = 0; i < 2; i++){
            Connection connectToDatabase = DataBaseMySql.getConnection();
            assertNotNull(connectToDatabase);
            assertFalse(connectToDatabase.isClosed());
        }
    }
}
