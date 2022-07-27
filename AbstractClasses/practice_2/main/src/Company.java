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

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> arrayList = new ArrayList<>(staff);
        if (staff.contains(count)) {
            Collections.sort(staff, Collections.reverseOrder());
            System.out.println("Список по убывнию заработной платы: ");
        }
        return arrayList;
        }

    public List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> arrayList1 = new ArrayList<>();
        if (staff.contains(count)) {
            System.out.println("Список по возрастанию заработной платы: ");
        }
        return staff;
    }
}
