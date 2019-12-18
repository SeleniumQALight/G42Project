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
    public  void setUp() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @After
    public void tearDown() throws SQLException {
        database.quit();
    }

    @Test
    public void testDataBase() throws SQLException, ClassNotFoundException {
        List<Map<String, String>> dataFromSeleniumTable = database.selectTableAsMap("select * from seleniumTable where login='g42GuglyaTest'");
        logger.info(dataFromSeleniumTable);
       // logger.info(dataFromSeleniumTable.get(2).get("login")); //вывод строки и логина
      //  database.changeTable("INSERT INTO seleniumTable VALUES (33, 'g42GuglyaTest', 'PASS')"); // 33 - id, login, пароль
        database.selectTableAsMap("select * from seleniumTable where login='g42GuglyaTest'");
        logger.info(dataFromSeleniumTable);

        UtilsForDB utilsForDB = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("g42GuglyaTest"));
    }
}
