import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbc_connect {

    public static void main(String[] args) throws Exception {
        jdbc_connect jdbc = new jdbc_connect();
        jdbc.connet1();   // 调用方法
        jdbc.connet2();
        jdbc.connect3();
        jdbc.connect4();
        jdbc.connect5();
    }

    public void connet1() throws SQLException {

        Driver driver = new Driver();

        String url = "jdbc:mysql://localhost:3306/jdbc";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);

//        String sql = "insert into actor values(null,'刘德华','男','2026-03-27','25')";
//        connect.createStatement().executeUpdate(sql);

        System.out.println("插入成功");
    }

    public void connet2() throws Exception {

        Class<?> claDriver = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) claDriver.newInstance();

        String url = "jdbc:mysql://localhost:3306/jdbc";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);

        System.out.println("connect2" + connect);
    }
    public void connect3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "123456";
        DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url, user, password);
        System.out.println("connect3" + connect);
    }
    public void connect4() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("connect4" + connection);
    }
    public void connect5() throws ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        System.out.println("url=" + url + ", user=" + user + ", password=" + password+", driver=" + driver);
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("connect5" + connection);
    }
}