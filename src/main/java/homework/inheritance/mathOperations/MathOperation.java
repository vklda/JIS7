package homework.inheritance.mathOperations;

@FunctionalInterface
public interface MathOperation<Double> {
    Double compute(Double a, Double b);
}
