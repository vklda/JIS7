package homework.inheritance.shape;

public abstract class AbstractShape implements Shape {
    private String name;
    private double area;

    protected AbstractShape(String name) {
        this.name = name;
    }

    abstract void validateSide(double side);

    abstract double calculateArea();

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return this.area;
    }
}
