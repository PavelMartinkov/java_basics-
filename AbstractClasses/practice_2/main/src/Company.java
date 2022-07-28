import java.util.*;

public class Company{

    public double income;

    private List<Employee> staff;

    public Company() {
        staff = new ArrayList<>();
        income++;
    }

    public void hire(Employee employee) {
        staff.add(employee);
        System.out.println("Добавлен один сотрудник: " + employee);
    }

    public void hireAll(Collection<Employee> employees) {
        staff.addAll(employees);
        System.out.println("Список сотрудников: ");
        System.out.println(employees);
    }

    public void fire(Employee employee) {
        staff.remove(employee);
        System.out.println("Данный(ые) сотрудник(и) уволен(ы): " + employee);
    }

    public void fireAll(Collection<Employee> employees) {
        staff.remove(employees);
        System.out.println("Список уволенных сотрудников: ");
        System.out.println(employees);
    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {

        ArrayList <Employee> topSalaryStaff = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            topSalaryStaff.add(staff.get(i));
        }
        Collections.sort(topSalaryStaff, Collections.reverseOrder());
        return topSalaryStaff;
    }

    public List<Employee> getLowestSalaryStaff(int count) {

        ArrayList <Employee> lowSalaryStaff = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lowSalaryStaff.add(staff.get(i));
        }
        return lowSalaryStaff;
    }
}
