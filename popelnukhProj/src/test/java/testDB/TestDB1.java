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

public class TestDB1 {
    private Database database;
    private Logger logger = Logger.getLogger(getClass());
    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @After
    public void tearDown() throws SQLException {
        database.quit();
    }

    @Test
    public void testDataBase() throws SQLException, ClassNotFoundException {
        List<Map<String, String>> dataFromSeleniumTable =
                database.selectTableAsMap("select * from seleniumTable where login = 'g42PopelnukhTest'");
        logger.info(dataFromSeleniumTable);
//        logger.info(dataFromSeleniumTable.get(2).get("login"));
//        database.changeTable("INSERT INTO seleniumTable VALUES (1488, 'g42PopelnukhTest', 'Pass')");
        dataFromSeleniumTable =
        database.selectTableAsMap("select * from seleniumTable where login = 'g42PopelnukhTest'");
        logger.info(dataFromSeleniumTable);

        UtilsForDB utilsForDB = new UtilsForDB();
        utilsForDB.getPassForLogin("g42PopelnukhTest");
        logger.info(utilsForDB.getPassForLogin("g42PopelnukhTest"));
        String loginURL = utilsForDB.getPassForLogin("g42PopelnukhTest");
    }

}