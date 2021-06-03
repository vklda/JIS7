package homework.annotations.task1;

import homework.annotations.task1.model.Product;
import homework.annotations.task1.processors.MyProcessor;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;

@Log4j2
public class App {
    public static void main(String[] args) throws IllegalAccessException {
        var list = new ArrayList<Product>();
        list.add(new Product("product1", 2));
        list.add(new Product("product2", 3));
        list.add(new Product("product3", 10));
        list.add(new Product("product4", 5));
        list.add(new Product("product5", 6));
        log.info(new MyProcessor().process(list.get(0)));
        log.info(new MyProcessor().process(list.get(2)));

    }
}
