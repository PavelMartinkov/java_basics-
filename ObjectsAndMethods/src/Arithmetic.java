public class Arithmetic {
    private int value1;
    private int value2;

    public Arithmetic(int number1, int number2) {
        this.value1 = number1;
        this.value2 = number2;
    }

    public int summa() {
        int result = value1 + value2;
        System.out.println("Сумма чисел равна: " + result);
        return result;
    }

    public int multiplication() {
        int result = value1 * value2;
        System.out.println("Произведение чисел равно: " + result);
        return result;
    }

    public int maximum() {
        if (value1 > value2) {
            System.out.println("Максимальное число: " + value1);
            return value1;
        } else if (value1 < value2) {
            System.out.println("Максимальное число: " + value2);
            return value2;
        }
        return 0;
    }

    public int minimum() {
        if (value1 > value2) {
            System.out.println("Минимальное число: " + value2);
            return value2;
        } else if (value1 < value2) {
            System.out.println("Минимальное число: " + value1);
            return value1;
        }
        return 0;
    }
}