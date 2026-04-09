import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcUtils_use {
    public static void main(String[] args) throws SQLException {
        new jdbcUtils_use().useJdbc();
    }

    public void useJdbc() throws SQLException {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        try {
            connect = jdbcUtils_test.connect();
            connect.setAutoCommit(false);
            String sql = "insert into test values (?)";
            preparedStatement = connect.prepareStatement(sql);
            for(int i = 0; i < 1000;i++){
                preparedStatement.setString(1,"name" + i);
                preparedStatement.addBatch();
                if(i % 200 == 0){
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();

            connect.commit();
        } catch (Exception e) {
            connect.rollback();
            e.printStackTrace();
        }finally {
            jdbcUtils_test.close(connect,preparedStatement,null);
        }
    }
}
