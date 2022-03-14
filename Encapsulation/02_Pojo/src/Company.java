public class Company {

    private String name;
    private int personal;
    private double salary;
    private boolean vacation;

    public Company(String name, int personal) {
        this.name = name;
        this.personal = personal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public int getPersonal() {
        return personal;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setVacation(boolean vacation) {
        this.vacation = vacation;
    }

    public boolean getVacation() {
        return vacation;
    }
}
