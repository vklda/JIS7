package homework.inheritance.mathOperations;

public class SubtractionOperation implements MathOperation<Double> {


    @Override
    public Double compute(Double a, Double b) {
        MathOperation<Double> subtraction = (firstNumber, secondNumber) -> a - b;
        return subtraction.compute(a, b);
    }
}
