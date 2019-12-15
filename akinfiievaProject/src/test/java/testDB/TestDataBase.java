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

public class TestDataBase {
    private Database database;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @After
    public void turnDown() throws SQLException {
        database.quit();
    }

    @Test
    public void testDataBase() throws SQLException, ClassNotFoundException {
        List<Map<String,String>> dataFromSeleniumTable = database.selectTableAsMap("select * from seleniumTable");
   //     List<Map<String,String>> dataFromSeleniumTable = database.selectTableAsMap("select * from seleniumTable where login='g42AkinfiievaTest'");
    //    logger.info(dataFromSeleniumTable);
      //  logger.info(dataFromSeleniumTable.get(2).get("login"));
       // List<Map<String,String>> dataFromSeleniumTableSpecified = database.selectTableAsMap("select * from seleniumTable where login='oliynikTest'");
      //  logger.info(dataFromSeleniumTableSpecified);
      //  database.changeTable("INSERT INTO seleniumTable VALUES (9, 'g42AkinfiievaTest', 'lol1234567')");
      //  logger.info(dataFromSeleniumTable.get(8).get("login"));
        UtilsForDB utilsForDB  = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("g42RadulenkoTest"));
    }
}
