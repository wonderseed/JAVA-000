package jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class DbConnection {
    private static final String url = "jdbc:postgresql://localhost:4505";
    private static final String username = "syria";
    private static final String password = "Cloud123";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e){
            log.error("can not find driver");
        }catch (SQLException sqlException){
            log.error("get connection failed");
        }
        return connection;
    }
}
