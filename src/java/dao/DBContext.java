package dao;

/**
 *
 * @author kminh
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

    private static DBContext instance = new DBContext();
    Connection connection;
    
    public static DBContext getInstance() {
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    private DBContext() {
        try {
            if (connection == null || connection.isClosed()) {
                String user = "sa";
                String password = "admin";
                String url = "jdbc:sqlserver://localhost:1433;databaseName=MTVR";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url, user, password);
            }
            
        } catch (Exception e) {
            connection = null;
        }
    }

}
