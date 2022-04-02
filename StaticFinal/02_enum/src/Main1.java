public class Main1 {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(5, 9);
        calculator.calculate(Operation.ADD);
        calculator.calculate(Operation.SUBTRACT);
        calculator.calculate(Operation.MULTIPLY);
    }
}
