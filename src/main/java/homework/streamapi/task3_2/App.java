package homework.streamapi.task3_2;

import homework.streamapi.task3_2.model.Product;
import homework.streamapi.task3_2.service.ProductService;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Arrays;

public class App {
    private static final Logger log = Logger.getLogger(App.class);

    private static final String delimeter = "^_^_^_^_^_^_^_^_^_^_^_^__^_^_^_^_^_^_^_^_^_^_^_^";

    public static void main(String[] args) {
        var productService = new ProductService();
        var products = new Product[10];
        initialize(products);
        Arrays.stream(productService.findProductsWithoutDiscount(products)).forEach(log::info);
        log.info(delimeter);
        Arrays.stream(productService.sortProductByDiscountAndPrice(products)).forEach(log::info);
    }

    private static void initialize(Product[] products) {
        products[0] = new Product("Product 1", BigDecimal.TEN, 0);
        products[1] = new Product("Product 2", BigDecimal.valueOf(13), 10);
        products[2] = new Product("Product 3", BigDecimal.valueOf(50), 10);
        products[3] = new Product("Product 4", BigDecimal.valueOf(12), 0);
        products[4] = new Product("Product 5", BigDecimal.valueOf(5), 5);
        products[5] = new Product("Product 6", BigDecimal.valueOf(13.3), 4);
        products[6] = new Product("Product 7", BigDecimal.valueOf(9.3), 4);
        products[7] = new Product("Product 8", BigDecimal.valueOf(6.6), 20);
        products[8] = new Product("Product 9", BigDecimal.valueOf(3), 20);
        products[9] = new Product("Product 10", BigDecimal.valueOf(4), 0);
    }


}
