package homework.inheritance.shape;

public class Square extends AbstractShape {
    private double a;
    private double b;


    public Square(String name, double a, double b) {
        super(name);
        validateSide(a);
        validateSide(b);
        this.a = a;
        this.b = b;
        this.setArea(calculateArea());
    }

    @Override
    void validateSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("side can not be equals or less 0");
        }
    }

    @Override
    public double calculateArea() {
        return this.getA() * this.getB();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
