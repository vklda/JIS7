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

    }
}
