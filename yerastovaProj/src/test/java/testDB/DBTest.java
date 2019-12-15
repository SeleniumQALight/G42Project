package testDB;

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

public class DBTest {
    private Database database;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp () throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @After
    public  void tearDown () throws SQLException {
        database.quit();
    }

    @Test
    public void testDataBase () throws SQLException, ClassNotFoundException {
        List <Map<String , String>> dataFromSeleniumTable = database.selectTableAsMap("select * from seleniumTable where login = 'G42YerastovaTest'");
        logger.info(dataFromSeleniumTable);
//        logger.info(dataFromSeleniumTable.get(2).get("login"));
//        logger.info(dataFromSeleniumTable.get(2));
//        database.changeTable("insert into seleniumTable values (115, 'G42YerastovaTest', 'bla')");

        dataFromSeleniumTable = database.selectTableAsMap("select * from seleniumTable where login = 'G42YerastovaTest'");
        logger.info(dataFromSeleniumTable);

        UtilsForDB utilsForDB = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("G42YerastovaTest"));


    }
}
