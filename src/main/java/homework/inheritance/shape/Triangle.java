package homework.inheritance.shape;

public class Triangle extends AbstractShape {
    private double base;
    private double height;

    public Triangle(String name, double base, double height) {
        super(name);
        validateSide(base);
        validateHeight(height);
        this.base = base;
        this.height = height;
        this.setArea(calculateArea());
    }

    private void validateHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("height can not be equals or less 0");
        }
    }

    @Override
    void validateSide(double base) {
        if (base <= 0) {
            throw new IllegalArgumentException("base can not be equals or less 0");
        }
    }

    @Override
    public double calculateArea() {
        return this.getBase() * this.getHeight() / 2;
    }

    public Double getBase() {
        return base;
    }

    public Double getHeight() {
        return height;
    }
}
