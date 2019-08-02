import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DbObjects {
    public static void createObjects(Connection connection) {
        createTables(connection);
    }

    public static void dropObjects(Connection connection) {
        dropTable(connection);
    }

    private static void createTables(Connection conn) {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS PRODUCT ( idproduct integer PRIMARY KEY, productname varchar(32));";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTable(Connection conn) {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS PRODUCT;";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
