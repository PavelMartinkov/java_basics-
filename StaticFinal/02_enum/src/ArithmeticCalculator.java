public class ArithmeticCalculator {

    private int value1;
    private int value2;
    private Operation operation;


    public ArithmeticCalculator(Operation operation) {
        this.operation = operation;
    }

    public ArithmeticCalculator(int number1, int number2) {
        this.value1 = number1;
        this.value2 = number2;
    }


    public void calculate(Operation operation) {
        if (value1 == 0 && value2 == 0) {
            System.out.println("Если оба числа равны 0, результат операции не изменится");
        } else if (operation == Operation.ADD) {
            System.out.println("Сложение:");
            System.out.println(value1 + value2);
        } else if (operation == Operation.SUBTRACT) {
            System.out.println("Вычитание:");
            System.out.println(value1 - value2);
        } else if (operation == Operation.MULTIPLY) {
            System.out.println("Умножение:");
            System.out.println(value1 * value2);
        }
    }
}
