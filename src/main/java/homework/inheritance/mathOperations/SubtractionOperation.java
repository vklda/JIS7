package homework.inheritance.mathOperations;

public class SubtractionOperation implements MathOperation<Double> {


    @Override
    public Double compute(Double a, Double b) {
        return a - b;
    }
}
