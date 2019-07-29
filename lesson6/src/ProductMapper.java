import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProductMapper {
    private final Connection connection;

    private Map<Integer, Product> identityMap = new HashMap<>();

    public ProductMapper(Connection connection) {
        this.connection = connection;
    }

    public Product findByID(int idProduct) throws SQLException{
        String insertSql = "SELECT IDPRODUCT, PRODUCTNAME FROM PRODUCT WHERE IDPRODUCT = ?";
        PreparedStatement statement = connection.prepareStatement(insertSql);
        statement.setInt(1, idProduct);

        if(identityMap.get(idProduct) != null) {    //получение из кэша, если есть
            return identityMap.get(idProduct);      //воизбежание использования базы
        }

        try(ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setIdProduct(resultSet.getInt(1));
                product.setProductName(resultSet.getString(2));
                return product;
            }
        }
        System.out.println("Продукт не найден");
        return null;
    }

    public void insert(Product product) {
        PreparedStatement stat = null;
        String insertSql = "INSERT into PRODUCT values(?, ?);";
        try {
            stat = this.connection.prepareStatement(insertSql);
            stat.setInt(1, product.getIdProduct());
            stat.setString(2, product.getProductName());
            stat.executeUpdate();
            identityMap.put(product.getIdProduct(), product);
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            }
        }
    }

    public void update(Product product) {
        PreparedStatement stat = null;
        String insertSql = "Update PRODUCT SET productname = ? WHERE idproduct = ?;";
        try {
            stat = this.connection.prepareStatement(insertSql);
            stat.setString(1, product.getProductName());
            stat.setInt(2, product.getIdProduct());
            stat.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            }
        }
    }

    public void delete(Product product) {
        identityMap.remove(product.getIdProduct());
        int result = -1;
        PreparedStatement stat = null;
        String insertSql = "DELETE from PRODUCT WHERE idproduct = ?;";
        try {
            stat = this.connection.prepareStatement(insertSql);
            stat.setInt(1, product.getIdProduct());
            int count = stat.executeUpdate();
            result = 0;
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            }
        }
    }
}
