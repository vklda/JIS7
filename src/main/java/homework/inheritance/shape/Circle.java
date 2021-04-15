package homework.inheritance.shape;

public class Circle extends AbstractShape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        validateSide(radius);
        this.radius = radius;
        this.setArea(calculateArea());
    }

    public double getRadius() {
        return radius;
    }

    @Override
    void validateSide(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius can not be equals or less 0");
        }
    }

    public double calculateArea() {
        return 3.14D * radius * radius;
    }


}
