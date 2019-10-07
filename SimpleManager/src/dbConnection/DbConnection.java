
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PLRAD2SIU
 */
public class DbConnection {
    
 static Connection connection = null;
 
 public static Connection getConnection(){
           try {
            Class.forName("com.mysql.jdbc.Driver");
           
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/simplemanager_db?autoReconnect=true&useSSL=false","root","Simplemanager123");
           // System.err.println("Połączonow z bazą danych ! ");
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//
//            }
        } catch (Exception ex) {

            System.err.println("Błąd połączenia z bazą danych ! ");

        }
 
 
  return connection;
 
 
 }
    
    
    
    
}
