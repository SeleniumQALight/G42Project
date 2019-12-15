package testdb;

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
    private Logger log = Logger.getLogger(getClass());

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @Test
    public void testDataBase() throws SQLException, ClassNotFoundException {
        List<Map<String, String>> dataFromSeleniumTable =  database.selectTableAsMap("SELECT * FROM seleniumTable WHERE login = 'g42KuzmychTest'");
        log.info(dataFromSeleniumTable);
        //log.info(dataFromSeleniumTable.get(2).get("login"));
        //database.changeTable("INSERT INTO seleniumTable VALUES(39, 'g42KuzmychTest', 'log_in')");
        dataFromSeleniumTable =  database.selectTableAsMap("SELECT * FROM seleniumTable WHERE login = 'g42KuzmychTest'");
        log.info(dataFromSeleniumTable);

        UtilsForDB utilsForDB = new UtilsForDB();
        log.info(utilsForDB.getPassForLogin("g42KuzmychTest"));

    }

    @After
    public void tearDown() throws SQLException {
        database.quit();
    }
}
