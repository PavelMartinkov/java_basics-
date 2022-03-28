public class ArithmeticCalculator {

    private int value1 = 9;
    private int value2 = 4;


    public ArithmeticCalculator(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public ArithmeticCalculator(Operation operationAdd, Operation operationSubtract, Operation operationMultiply) {
        operationAdd = Operation.ADD;
        operationSubtract = Operation.SUBTRACT;
        operationMultiply = Operation.MULTIPLY;
    }

    public int getOperationAdd() {
        return value1 + value2;
    }

    public int getOperationSubtract() {
        return value1 - value2;
    }

    public int getOperationMultiply() {
        return value1 * value2;
    }

    public void calculate(Operation operation) {

    }
}

//        Второе решение(если мы хотим, чтобы пользователь задавал сам числа)
//        while (true) {
//            System.out.println("Введите первое число:");
//            int value1 = new Scanner(System.in).nextInt();
//            System.out.println("Введите второе число:");
//            int value2 = new Scanner(System.in).nextInt();
//            int result = value1 + value2;
//            System.out.println("Сложение: " + result);
//            int result1 = value1 - value2;
//            System.out.println("Вычитание: " + result1);
//            int result2 = value1 * value2;
//            System.out.println("Умножение: " + result2);
//            System.out.println();
//        }