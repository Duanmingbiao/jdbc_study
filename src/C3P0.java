import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
public class C3P0 {
    public static void main(String[] args) throws PropertyVetoException, SQLException, IOException {
        new C3P0().test();
    }
    public void test() throws IOException, PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hello");
        /*
        第一种方法
         */
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("src\\mysql.properties"));
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//        String driver = properties.getProperty("driver");
//        String url = properties.getProperty("url");
//        comboPooledDataSource.setDriverClass(driver);
//        comboPooledDataSource.setJdbcUrl(url);
//        comboPooledDataSource.setUser(user);
//        comboPooledDataSource.setPassword(password);
//        comboPooledDataSource.setInitialPoolSize(10);
//        comboPooledDataSource.setMaxPoolSize(50);
//        Connection connection = comboPooledDataSource.getConnection();
//        System.out.println("连接成功" + connection.getMetaData().getDatabaseProductName());
//        connection.close();
        /*
        第二种方法
         */
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接成功: " + connection);
        connection.close();
    }
}
