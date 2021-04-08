package homework.classesAndObjects.circle;

import org.apache.log4j.Logger;

public class CircleDemo {
    private static final Logger logger = Logger.getLogger(CircleDemo.class);

    public static void main(String[] args) {
        Circle circle = new Circle(1.0);
        logger.info("Радиус = " + Circle.calculateArea(circle.getRadius()));
        circle.setRadius(3D);
        logger.info("Радиус = " + Circle.calculateArea(circle.getRadius()));
        circle.setRadius(0D);
        logger.info("Радиус = " + Circle.calculateArea(circle.getRadius()));
    }
}
