public class Operator implements Employee {

    private double operatorSalary;
    private int countPeople;

    public Operator(int countPeople) {
        this.countPeople = countPeople;
    }

    @Override
    public double getMonthSalary() {
        return operatorSalary;
    }
}
