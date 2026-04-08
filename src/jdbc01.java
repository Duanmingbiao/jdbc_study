import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 1.注册驱动
        Driver driver = new Driver();
//        2.得到链接
        String url = "jdbc:mysql://localhost:3306/jdbc";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        Connection connect = driver.connect(url, properties);
        String sql = "insert into actor values(null,'刘德华','男','2026-03-27','25')";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        statement.close();
        connect.close();
    }
}
