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

        System.out.println(company.getTopSalaryStaff(15));
        System.out.println(company.getLowestSalaryStaff(30));
//        company.fire()
        System.out.println(company.getTopSalaryStaff(15));
        System.out.println(company.getLowestSalaryStaff(30));

    }
}
