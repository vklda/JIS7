package homework.inheritance.mathOperations;

public class MultiplicationOperation implements MathOperation<Double> {


    @Override
    public Double compute(Double a, Double b) {
        MathOperation<Double> multiplication = (firstNumber, secondNumber) -> a * b;
        return multiplication.compute(a,b);
    }
}
