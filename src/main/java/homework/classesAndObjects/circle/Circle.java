package homework.classesAndObjects.circle;

import org.apache.log4j.Logger;

public class Circle {
    private static final Logger logger = Logger.getLogger(CircleDemo.class);
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public static Double calculateArea(final Double radius) {
        Double pi = 3.14D;
        Double area = 2 * pi * radius;
        return area;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        if (radius <= 0) {
            logger.info("radius can not be <= 0");
            return;
        }
        this.radius = radius;
    }
}
