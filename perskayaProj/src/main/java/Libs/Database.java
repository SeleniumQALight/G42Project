package Libs;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 *  Database class provides methods for working with database.
 */
public class Database {
   private Connection connection;
   private String url;
   static Logger log = Logger.getLogger(Database.class);

   /*
     *  Constructor opens connection to database using connection string from config.properties file.
     *  Note in config.properties, please, that username and password for access to the database should be named as
     *  relevant connection string including "_USER"  and "_PASSWORD"
     */
    public Database(String dbDriver, String bdUrl, String user_name, String user_pass) throws ClassNotFoundException, SQLException {

        // Load driver for JDBC class
        Class.forName(dbDriver); // подключиение нужной б-ки в процессе выполнения программы; эта строка подтягивает импорт
                
        // Create a connection to the database
        connection= DriverManager.getConnection(bdUrl,user_name,user_pass);
        
    }

    /*
     *  That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query as parameter and returns result as String
     */
    public String selectValue(String query) throws SQLException { // query - запрос; возвращает одно значение
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm=connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta=rSet.getMetaData();
        
        // Retrieve value from ResultSet
        String value="";

        if (rSet.next()){
            if (rSet.getObject(1)!=null){
                value=rSet.getObject(1).toString();

                if(meta.getColumnType(1)==93){
                    value=value.substring(0,value.length()-2);
                }
            }
        }

        stm.close();
        //System.out.println(query);
        value=value.trim();
        return value;
    }


    /*
     *  That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query as parameter and returns result set as List of Strings
     */
    public List selectResultSet(String query) throws SQLException { // возвращает лист, одну строку
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm=connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);

        // Get ResultSet's meta data
        ResultSetMetaData meta=rSet.getMetaData();

        List<String> resultSet=new ArrayList<>();

        while (rSet.next()){
            String value="";

            if (rSet.getObject(1)!=null){
                value=rSet.getObject(1).toString();

                if(meta.getColumnType(1)==93){
                    value=value.substring(0,value.length()-2);
                }
            }

            value=value.trim();
            resultSet.add(value);
        }

        // Close the statement
        stm.close();
        //System.out.println(query);
        return resultSet;
    }


    /*
     *  That method gets SQL [Select COLUMN_NAME_1,COLUMN_NAME_2 from TABLE_NAME where ...] query as parameter and returns result set as List of Strings
     */
    public ArrayList<ArrayList<String>> selectTable(String query) throws SQLException { // возвращает список списков, т.е. несколько строк и одну и одно значение
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm=connection.createStatement();
        //System.out.println(query);
        ResultSet rSet = stm.executeQuery(query); // м-д который возвращает значение

        // Get ResultSet's meta data
        ResultSetMetaData meta=rSet.getMetaData(); // дай нам всю мета инфу
        int columnNumber=meta.getColumnCount(); // getColumnCount - узнаем кол-во колонок

        ArrayList<ArrayList<String>> resultTable= new ArrayList<>();

        // Add column_name's values in the result table header
        ArrayList<String> columnNameSet=new ArrayList<>(); // columnNameSet - создаем список названия колонок
        columnNameSet.add("");
        for(int i=0;i<columnNumber;i++){ // проходим по названиям колонкам и записываем их имена
            columnNameSet.add(meta.getColumnName(i+1));
        }
        resultTable.add(columnNameSet); // сюда записываются имена колонок

        // Add result rows in the result table
        int resultSize=0; // нумерация строк

        while (rSet.next()){
            ArrayList<String> resultSet=new ArrayList<>();
            resultSize++;
            resultSet.add(String.valueOf(resultSize));

            for (int k=1;k<(columnNumber+1);k++){
                String value="";

                if (rSet.getObject(k)!=null){
                    value=rSet.getObject(k).toString();

                    if(meta.getColumnType(k)==93){
                        value=value.substring(0,value.length()-2); // обрезаются 2 милисекунды
                    }
                }

                value=value.trim(); // удаление пробелов
                resultSet.add(value); // добавляем в лист
            }

            resultTable.add(resultSet);
        }

        // Close the statement
        stm.close(); // закрываем сессию
        //System.out.println(query);
        return resultTable; // возвращаем таблицу
    }

    /*
     *  That method gets SQL [Select COLUMN_NAME_1,COLUMN_NAME_2 from TABLE_NAME where ...] query as parameter and returns result set as List<Map>
     */
    public ArrayList<Map<String, String>> selectTableAsMap(String query) throws SQLException { // возвращает список мапок
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm=connection.createStatement();
        //System.out.println(query);
        ResultSet rSet = stm.executeQuery(query);

        // Get ResultSet's meta data
        ResultSetMetaData meta=rSet.getMetaData();
        int columnNumber=meta.getColumnCount();

        ArrayList<Map<String, String>> resultTable = new ArrayList<>();

        while (rSet.next()){
            HashMap<String, String> resultSet = new HashMap<>();

            for (int k=1;k<(columnNumber+1);k++){
                String value="";

                if (rSet.getObject(k)!=null){
                    value=rSet.getObject(k).toString();

                    if(meta.getColumnType(k)==93){
                        value=value.substring(0,value.length()-2);
                    }
                }

                value=value.trim();
                resultSet.put(meta.getColumnName(k), value);
            }

            resultTable.add(resultSet);
        }

        // Close the statement
        stm.close();
        //System.out.println(query);
        return resultTable;
    }

    /**
     * Method for Update, Insert and Delete
     * @param query
     * @return number of effected rows
     */
    public int changeTable(String query) throws SQLException {
        Statement statement = connection.createStatement();
        int effectedRows = statement.executeUpdate(query);
        statement.close();
        return effectedRows;
    }


    /*
     *  Close connection to the database
     */
    public void quit() throws SQLException {
        connection.close();
    }









}
