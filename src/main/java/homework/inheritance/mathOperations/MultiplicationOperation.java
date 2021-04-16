package homework.inheritance.mathOperations;

public class MultiplicationOperation implements MathOperation<Double> {


    @Override
    public Double compute(Double a, Double b) {
        return a * b;
    }
}
