public class Main1 {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(Operation.ADD,Operation.SUBTRACT,Operation.MULTIPLY);
        calculator.calculate(Operation.ADD);
        System.out.println("Сложение: " + calculator.getOperationAdd());
        calculator.calculate(Operation.SUBTRACT);
        System.out.println("Вычитание: " + calculator.getOperationSubtract());
        calculator.calculate(Operation.MULTIPLY);
        System.out.println("Умножение: " + calculator.getOperationMultiply());
    }
}
