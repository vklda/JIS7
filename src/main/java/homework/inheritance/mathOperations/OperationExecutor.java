package homework.inheritance.mathOperations;

import org.apache.log4j.Logger;

public class OperationExecutor {
    private static final Logger logger = Logger.getLogger(OperationExecutor.class);

    void execute(MathOperation<Double>[] operations, double a, double b) {
        if (operations.length > 0) {
            for (MathOperation<Double> operation : operations) {
                logger.info(operation.getClass().getName()
                        + " " + operation.compute(a, b));
            }
        }
    }
}
