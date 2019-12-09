package testDB;

import Libs.Database;
import Libs.MySQL_Database;
import Libs.UtilsForDB;
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
        database = MySQL_Database.getDataBase(); //alt+enter / add exception   database-тут будет обект, который будет уметь с нашей бд
    }

    @After
    public void tearDown() throws SQLException {
        database.quit(); //alt+enter / add exception
    }

    @Test
    public void testDataBase() throws SQLException, ClassNotFoundException { // получение данных из таблички
        List<Map<String, String>> dataFromSeleniumTable = database.selectTableAsMap("select * from seleniumTable where login = 'G42Perskaya'"); //alt+enter / add exception
        logger.info(dataFromSeleniumTable);
//        logger.info(dataFromSeleniumTable.get(1).get("login")); // получаем данные из бд
//        database.changeTable("INSERT INTO seleniumTable VALUES (79, 'G42Perskaya', 'PASS')");
        dataFromSeleniumTable =
                database.selectTableAsMap("select * from seleniumTable where login = 'G42Perskaya'");
        logger.info(dataFromSeleniumTable);

        UtilsForDB utilsForDB = new UtilsForDB();
        utilsForDB.getPassForLogin("G42Perskaya");
        logger.info(utilsForDB.getPassForLogin("G42Perskaya"));
    }


}
