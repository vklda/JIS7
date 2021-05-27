package homework.streamapi.task3_2.service;

import homework.streamapi.task3_2.model.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Service {
    private Service() {
    }

    public static Product[] findProductsWithoutDiscount(Product[] products) {
        final var ZERO = 0;
        var list = Arrays.stream(products)
                .filter(product -> product.getDiscount().equals(ZERO))
                .collect(Collectors.toList());
        var filteredArray = new Product[list.size()];
        list.toArray(filteredArray);
        return filteredArray;
    }

    public static Product[] sortProductByDiscountAndPrice(Product[] products) {
        var list = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getDiscount)
                        .thenComparing(Product::getPrice))
                .collect(Collectors.toList());
        var sortedArray = new Product[list.size()];
        list.toArray(sortedArray);
        return sortedArray;
    }
}
