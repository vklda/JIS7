package homework.classesAndObjects.product;

import org.apache.log4j.Logger;

public class Product {
    private static final Logger logger = Logger.getLogger(Product.class);

    private String name;
    private Double regularPrice;
    private Double discount;
    private Double actualPrice;

    public Product(String name) {
        this.name = name;
    }

    public Product() {
    }

    private void actualPrice() {
        actualPrice = regularPrice - (regularPrice * discount / 100);
    }

    public void printInformation() {
        this.actualPrice();
        logger.info(this.toString());
    }

    @Override
    public String toString() {
        return "Product : " +
                "name = \"" + name + "\"" +
                ", regular Price = " + regularPrice +
                " EUR, discount = " + discount +
                "%, actual Price = " + actualPrice +
                " EUR";
    }

    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
