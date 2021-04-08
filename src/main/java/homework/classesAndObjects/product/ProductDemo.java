package homework.classesAndObjects.product;

public class ProductDemo {
    public static void main(String[] args) {
        Product cheese = new Product("Сыр");
        cheese.setRegularPrice(2.5D);
        cheese.setDiscount(3.2);
        cheese.printInformation();

        Product milk = new Product("Молоко");
        milk.setRegularPrice(0.5);
        milk.setDiscount(2D);
        milk.printInformation();

        Product snacks = new Product("Чипсы");
        snacks.setRegularPrice(1.1);
        snacks.setDiscount(0D);
        snacks.printInformation();
    }
}
