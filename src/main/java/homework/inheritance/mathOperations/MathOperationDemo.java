package homework.inheritance.mathOperations;

public class MathOperationDemo {
    public static void main(String[] args) {

        OperationExecutor executor = new OperationExecutor();
        MathOperation[] ops = {new AdditionOperation(),
                new SubtractionOperation(),
                new MultiplicationOperation(),
                new DivisionOperation()
        };
        executor.execute(ops, 2, 1);

        // my first experience at lambda expressions
        MathOperation<Double> addition = (a, b) -> a + b;
        System.out.println(addition.compute(5D, 4D));
        MathOperation<Double> division = (a, b) -> a / b;
        System.out.println(division.compute(5D, 4D));
        MathOperation<Double> multiplication = (a, b) -> a / b;
        System.out.println(multiplication.compute(5D, 4D));
        MathOperation<Double> subtraction = (a, b) -> a / b;
        System.out.println(subtraction.compute(5D, 4D));

    }
}
