package homework.inheritance.mathOperations;

public class DivisionOperation implements MathOperation<Double> {


    @Override
    public Double compute(Double a, Double b) {
        if (b != 0) {
            MathOperation<Double> division = (firstNumber, secondNumber) -> a / b;
            return division.compute(a, b);
        } else throw new ArithmeticException("division by zero");
    }
}
