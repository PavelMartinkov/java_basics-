import java.util.*;

public class Company {

    public double income;


    ArrayList<Employee> mainList = new ArrayList<>();


    public Company(double income) {
        this.income = income;
    }

    public boolean hire(Employee employee) {
        if (mainList.contains(employee)) {
            mainList.add(employee);
            System.out.println("Добро пожаловать в коллектив: " + employee);
        }
        return false;
    }

    public boolean hireAll(Collection<Employee> employees) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        if (employeeArrayList.contains(employees)) {
            employeeArrayList.add((Employee) employees);
        }
        return false;
    }

    public boolean fire(Employee employee) {
        if (mainList.contains(employee)) {
            mainList.remove(employee);
            System.out.println("Данный сотрудник уволен: " + employee);
        }
        return false;
    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> arrayList = new ArrayList<>(mainList);
        if (mainList.contains(count)) {
            Collections.sort(arrayList, Collections.reverseOrder());
            System.out.println("Список по убывнию заработной платы: ");
        }
        return arrayList;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> arrayList1 = new ArrayList<>(mainList);
        if (mainList.contains(count)) {
            System.out.println("Список по возрастанию заработной платы: ");
        }
        return arrayList1;
    }


}
