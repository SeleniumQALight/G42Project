package testDB;

import libs.Database;
import libs.MySQL_Database;
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
    public void SetUp () throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }
    @After
    public void tearDown() throws SQLException {
        database.quit();
    }

    @Test
    public void testDataBase() throws SQLException {
        List<Map<String,String>>dataFromSeleniumTable =
                database.selectTableAsMap("select * from seleniumTable where login='oliynikTest'");
        logger.info(dataFromSeleniumTable);
       // logger.info(dataFromSeleniumTable.get(2).get("login"));
    }


}
