package homework.inheritance.shape;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("circle", 1);
        shapes[1] = new Square("square", 2, 3);
        shapes[2] = new Triangle("triangle", 1, 3);
        for (Shape shape : shapes) {
            System.out.println("Name is: '" + shape.getName() + "' : area is: " + shape.getArea());
        }
        // shapes[2] = new Triangle("triangle", 0,2);
        // shapes[2] = new Triangle("triangle", 1, 0);
        // shapes[2] = new Square("square", 1, 0);
        // shapes[2] = new Circle("square", 0);
    }
}
