import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementTest {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String username = scanner.nextLine();
        System.out.print("请输入年龄: ");
        String userAge = scanner.nextLine();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        System.out.println("url=" + url + ", user=" + user + ", password=" + password+", driver=" + driver);
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select * from actor where name = ? AND age = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, userAge);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt("id"));
            System.out.println("name: " + resultSet.getString("name"));
            System.out.println("birth: " + resultSet.getDate("birth"));
            System.out.println("age: " + resultSet.getInt("age"));
            System.out.println("--------");
        }

    }
}
