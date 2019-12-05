package TestDB;

import libs.Database;
import libs.MySQL_Database;
import libs.UtilsForDB;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDB {

    private Database database;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @After
    public void  tearDown() throws SQLException {
        database.quit();
    }

    @Test
    public void testDataBace() throws SQLException, ClassNotFoundException {
        List<Map<String, String>>dataFromSelectedTable = database.selectTableAsMap("select * from seleniumTable where idNumber = 27");
        //logger.info(dataFromSelectedTable);
        //logger.info(dataFromSelectedTable.get(2));
        //database.changeTable("insert into seleniumTable values(55, 'G42Vetrichenko', 'pass')");
        //database.changeTable("delete from seleniumTable where login='G42Vetrichenko'");
        dataFromSelectedTable = database.selectTableAsMap("select * from seleniumTable where login='G42Vetrichenko'");
        logger.info(dataFromSelectedTable);

        UtilsForDB utilsForDB = new UtilsForDB();
        utilsForDB.getPassForLogin("G42Vetrichenko");
    }


}
