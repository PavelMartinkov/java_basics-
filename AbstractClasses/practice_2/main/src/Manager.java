public class Manager implements Employee{

    private double managerSalary;
    private double moneyForCompanyByManager;
    private final double MIN_MONEY_FOR_COMPANY = 115000;
    private final double MAX_MONEY_FOR_COMPANY = 140000;
    private final double BONUS_MANAGER = 0.05;
    private int countPeople;


    public Manager(int countPeople) {
        this.countPeople = countPeople;
    }

    public Manager(double moneyForCompanyByManager) {
        this.moneyForCompanyByManager = moneyForCompanyByManager;
    }

    @Override
    public double getMonthSalary() {
        if (moneyForCompanyByManager >= MIN_MONEY_FOR_COMPANY || moneyForCompanyByManager <= MAX_MONEY_FOR_COMPANY) {
            managerSalary += moneyForCompanyByManager * BONUS_MANAGER;
        }
        return managerSalary;
    }
}
