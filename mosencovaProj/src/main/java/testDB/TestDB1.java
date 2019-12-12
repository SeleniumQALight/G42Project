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
    private Object UtilsForDB;

    @Before
    public void SetUp () throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }
    @After
    public void tearDown() throws SQLException {
        database.quit();
    }

    @Test
    public void testDataBase() throws SQLException, ClassNotFoundException {
        List<Map<String,String>>dataFromSeleniumTable =
                database.selectTableAsMap("select * from seleniumTable where login='g42MosentsovaTest'");
        logger.info(dataFromSeleniumTable);
       // logger.info(dataFromSeleniumTable.get(2).get("login"));
       // database.changeTable("INSERT INTO seleniumTable VALUES (78,'g42MosentsovaTest','Pass')");
        dataFromSeleniumTable=database.selectTableAsMap("select * from seleniumTable where login='g42MosentsovaTest'");
        logger.info(dataFromSeleniumTable);

        UtilsForDB  utilsForDB = new UtilsForDB();
        utilsForDB.getPassForLogin("g42Mosentsova") ;
        logger.info(utilsForDB.getPassForLogin("g42Mosentsova"));

    }


}
