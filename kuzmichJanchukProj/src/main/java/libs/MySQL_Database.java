package libs;

import org.aeonbits.owner.ConfigFactory;

import java.sql.SQLException;

public class MySQL_Database {
    private static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public static Database getDataBase() throws SQLException, ClassNotFoundException {
        return new Database(
                configProperties.MySQL()
                , configProperties.MySQL_DB()
                , configProperties.MySQL_DB_USER()
                , configProperties.MySQL_DB_PASSWORD());
    }
}
