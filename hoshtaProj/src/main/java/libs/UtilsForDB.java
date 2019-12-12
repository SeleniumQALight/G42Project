package libs;


import org.apache.log4j.Logger;

import java.sql.SQLException;

public class UtilsForDB {
     private Logger log = Logger.getLogger(getClass());
     private Database dBMySQL;



    public String getPassForLogin(String login) throws SQLException, ClassNotFoundException {
        log.info("--- Conect MySQL DB --------");
        dBMySQL = MySQL_Database.getDataBase();
        log.info("--- Conected to MySQL --------");
        String tempPass = dBMySQL
                .selectValue(String.format("select passWord from seleniumTable " +
                        "where login = '%s'",login));

        dBMySQL.quit();
        return tempPass;

    }
}
