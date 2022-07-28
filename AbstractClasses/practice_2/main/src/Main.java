import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            employees.add(new Operator(100_000));
        }

        for (int i = 0; i < 80; i ++) {
            employees.add(new Manager(135_000));
        }

        for (int i = 0; i < 10; i++) {
            employees.add(new TopManager(11_000_000));
        }

        company.hireAll(employees);
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println("Самые высокие зарплаты сотрудников: " + company.getTopSalaryStaff(10).get(i));
        }
        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.println("Самые низкие зарплаты сотрудников: " + company.getLowestSalaryStaff(30).get(i));
        }
        System.out.println();

        for (int i = 180; i > 90; i--) {
            employees.remove(i);
        }

        for (int i = 80; i > 40; i--) {
            employees.remove(i);
        }

        for (int i = 10; i > 5; i--) {
            employees.remove(i);
        }

        company.fireAll(employees);
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println("Самые высокие зарплаты сотрудников: " + company.getTopSalaryStaff(10).get(i));
        }
        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.println("Самые низкие зарплаты сотрудников: " + company.getLowestSalaryStaff(30).get(i));
        }
    }
}
