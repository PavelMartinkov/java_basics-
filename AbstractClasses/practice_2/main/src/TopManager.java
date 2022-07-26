public class TopManager implements Employee {

    private double topManagerSalary;
    private double income;
    private final double INCOME_COMPANY = 10_000_000;
    private final double BONUS_TOP_MANAGER = 1.5;
    private int countPeople;

    public TopManager(int countPeople) {
        this.countPeople = countPeople;
    }

    public TopManager(double income) {
        this.income = income;
    }

    @Override
    public double getMonthSalary() {
        if (income >= INCOME_COMPANY) {
            topManagerSalary += topManagerSalary * BONUS_TOP_MANAGER;
        }
        return topManagerSalary;
    }
}
