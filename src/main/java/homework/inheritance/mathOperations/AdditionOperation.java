package homework.inheritance.mathOperations;

public class AdditionOperation implements MathOperation<Double> {


    @Override
    public Double compute(Double a, Double b) {
        return a + b;
    }
}
