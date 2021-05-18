package homework.streamapi.task3;

import homework.streamapi.task3.model.Product;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class App {
    private static final Logger log = Logger.getLogger(App.class);
    private static final Random random = new Random(System.currentTimeMillis());
    private static final String delimeter = "^_^_^_^_^_^_^_^_^_^_^_^__^_^_^_^_^_^_^_^_^_^_^_^";

    public static void main(String[] args) {
        var products = new Product[10];
        initializeArray(products);
        products[9].setDiscount(32);
        products[6].setDiscount(0);
        Arrays.stream(products).forEach(log::info);
        log.info(delimeter + " \nall products with discount >30% and price < 10.5");
        Arrays.stream(findProductsWithHighDiscountAndLowPrice(products)).forEach(log::info);
        log.info(delimeter + " \nhigh priced product without discount");
        log.info(findProductWithHighestPriceWithoutDiscount(products));
        log.info(delimeter + " \ncheapest product with highest discount is: ");
        log.info(findCheapestProductWithHighestDiscount(products));
    }

    private static void initializeArray(Product[] products) {
        for (var i = 0; i < products.length; i++) {
            products[i] = new Product(String.format("Product {%s}", i + 1),
                    BigDecimal.valueOf(15 * random.nextDouble()).setScale(2, RoundingMode.DOWN),
                    i * 4);
        }
    }

    private static Product findCheapestProductWithHighestDiscount(Product[] products) {
        Comparator<Product> comparatorByPrice = Comparator.comparing(Product::getPrice);
        Comparator<Product> comparatorByDiscount = (p1, p2) -> p2.getDiscount().compareTo(p1.getDiscount());
        return (Product) Arrays.stream(products)
                .min(comparatorByDiscount.thenComparing(comparatorByPrice))
                .orElse(null);
    }

    private static Product findProductWithHighestPriceWithoutDiscount(Product[] products) {
        final var ZERO = 0;
        return Arrays.stream(products)
                .filter(product -> product.getDiscount() == ZERO)
                .min((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
                .orElse(null);
    }

    private static Product[] findProductsWithHighDiscountAndLowPrice(Product[] products) {
        final var THIRTY = 30;
        final var MAX_PRICE = BigDecimal.valueOf(10.5);
        var list = Arrays.stream(products)
                .filter(product -> product.getDiscount() >= THIRTY &&
                        product.getPrice().compareTo(MAX_PRICE) <= 0)
                .collect(Collectors.toList());
        var filteredArray = new Product[list.size()];
        list.toArray(filteredArray);
        return filteredArray;
    }
}
