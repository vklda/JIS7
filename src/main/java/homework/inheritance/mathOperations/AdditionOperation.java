package homework.inheritance.mathOperations;

public class AdditionOperation implements MathOperation<Double> {


    @Override
    public Double compute(Double a, Double b) {
        MathOperation<Double> addition = (firstNumber, secondNumber) -> a + b;
        return addition.compute(a, b);
    }
}
