public class Manager implements Employee{

    private double fixManagerSalary = 50_000;
    private double moneyForCompanyByManager;
    private final double MIN_MONEY_FOR_COMPANY = 115_000;
    private final double MAX_MONEY_FOR_COMPANY = 140_000;
    private final double BONUS_MANAGER = 0.05;

    public Manager(double moneyForCompanyByManager) {
        this.moneyForCompanyByManager = moneyForCompanyByManager;
    }

    @Override
    public double getMonthSalary() {
        if (moneyForCompanyByManager >= MIN_MONEY_FOR_COMPANY || moneyForCompanyByManager <= MAX_MONEY_FOR_COMPANY) {
            fixManagerSalary += moneyForCompanyByManager * BONUS_MANAGER;
        }
        return fixManagerSalary;
    }

    @Override
    public String toString() {
        return "Manager {" + "managerSalary = " + getMonthSalary() + " руб." + '}';
    }
}
