import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.exit;

/**
 * Добавление товаров в БД
 *
 * Товар имеет: имя и ID
 */

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbConnector.getConnection();
        if (conn == null) {
            exit(0);
            System.out.println("Соединение не установлено");
        }

        DbObjects.dropObjects(conn);    //удаление базы данных, для успещного перезапуска программы

        DbObjects.createObjects(conn);
        ProductMapper productMapper = new ProductMapper(conn);

        Product product1 = new Product();
        product1.setProductName("Baklajan");
        product1.setIdProduct(1);
        productMapper.insert(product1);

        Product product2 = new Product();
        product2.setProductName("Kartofel");
        product2.setIdProduct(2);
        productMapper.insert(product2);

        System.out.println(productMapper.findByID(1).getProductName() + " найден");
        System.out.println(productMapper.findByID(2).getProductName() + " найден");

        System.out.println("________________________\nОбновление 2 продукта");
        product2.setProductName("Cesnok");
        productMapper.update(product2);

        System.out.println(productMapper.findByID(1).getProductName() + " найден");
        System.out.println(productMapper.findByID(2).getProductName() + " найден");

        System.out.println("________________________\nУдаление 2 продукта");
        productMapper.delete(product2);

        System.out.println(productMapper.findByID(1).getProductName() + " найден");
        System.out.println(productMapper.findByID(2).getProductName() + " найден");
    }
}
