import java.util.Scanner;
public class Arithmetic {
    private int value1;
    private int value2;

    public Arithmetic (int number1, int number2) {
        value1 = number1;
        value2 = number2;
    }

    public static void main(String[] args) {
        Arithmetic pavel = new Arithmetic(0,0);
        pavel.summa();
        System.out.println();
        pavel.proizvedenie();
        System.out.println();
        pavel.maximum();
        System.out.println();
        pavel.minimum();
    }

    public void summa () {
        System.out.println("Введите первое число:");
        int number1 = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число:");
        int number2 = new Scanner(System.in).nextInt();
        int result = number1 + number2;
        System.out.println("Сумма чисел равна: " + result);
    }

    public void proizvedenie () {
        System.out.println("Введите первое число:");
        int number1 = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число:");
        int number2 = new Scanner(System.in).nextInt();
        int result = number1 * number2;
        System.out.println("Произведение чисел равно: " + result);
    }

    public void maximum () {
        System.out.println("Введите первое число:");
        int number1 = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число:");
        int number2 = new Scanner(System.in).nextInt();
        if (number1 > number2) {
            System.out.println("Максимальное число: " + number1);
        } else if (number1 < number2) {
            System.out.println("Максимальное число: " + number2);
        } else {
            System.out.println("Введенно неверное значение");
        }
    }

    public void minimum () {
        System.out.println("Введите первое число:");
        int number1 = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число:");
        int number2 = new Scanner(System.in).nextInt();
        if (number1 > number2) {
            System.out.println("Минимальное число: " + number2);
        } else if (number1 < number2) {
            System.out.println("Минимальное число: " + number1);
        } else {
            System.out.println("Введенно неверное значение");
        }
    }
}
