import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Druid {
    public static void main(String[] args) throws Exception {
        /*
        第一种方法：读取配置文件
         */
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Druid.properties"));
        DruidDataSourceFactory druidDataSourceFactory = new DruidDataSourceFactory();
        DataSource dataSource = druidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功" +  connection);
        connection.close();
    }
}
