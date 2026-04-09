import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUtils_test{
    public static String user =null;
    public static String password =null;
    public static String url =null;
    public static String driver ="null";

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            driver = properties.getProperty("driver");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    public static void close(Connection connection, Statement statemet , Runnable runnable) {
        try{
            if(connection!=null){
                connection.close();
            }
            if(statemet!=null){
                statemet.close();
            }
            if(runnable!=null){
                runnable.run();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
