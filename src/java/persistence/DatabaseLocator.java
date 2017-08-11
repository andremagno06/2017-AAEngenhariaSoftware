package persistence;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 08023674617
 */
public class DatabaseLocator {
    private static DatabaseLocator instance = new DatabaseLocator();
    
    public static DatabaseLocator getInstance(){
        return instance;
    }
    
    private DatabaseLocator(){}
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn =  (Connection) DriverManager.getConnection("jdbc:mysql://172.18.10.31/11962413683", "11962413683", "100%Sucesso");
        return conn;
    }
}