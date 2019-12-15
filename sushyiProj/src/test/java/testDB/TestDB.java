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

public class TestDB {
    private Database database;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUP() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @After
    public void tearDown() throws SQLException {
        database.quit();
    }
    // тест Получения данных
    @Test
    public  void  testDataBase() throws SQLException, ClassNotFoundException {
        List<Map<String,String>> dataFromSeleniumTable =
                database.selectTableAsMap("select * from seleniumTable where login='g42SushyiTest'");
        logger.info(dataFromSeleniumTable);
        //logger.info(dataFromSeleniumTable.get(2).get("login"));

        //database.changeTable("INSERT INTO seleniumTable VALUES (22, 'g42SushyiTest', 'PASS')");
         dataFromSeleniumTable =
                database.selectTableAsMap("select * from seleniumTable where login='g42SushyiTest'");
        logger.info(dataFromSeleniumTable);

        UtilsForDB utilsForDB = new UtilsForDB();
       logger.info(utilsForDB.getPassForLogin("g42SushyiTest"));

    }

}
