public class TopManager implements Employee {

    private double fixTopManagerSalary = 50_000;
    private final double INCOME_COMPANY = 10_000_000;
    private final double BONUS_TOP_MANAGER = 1.5;
    private double moneyForCompanyByTopManager;


    public TopManager(double moneyForCompanyByTopManager) {
        this.moneyForCompanyByTopManager = moneyForCompanyByTopManager;
    }

    @Override
    public double getMonthSalary() {
        if (moneyForCompanyByTopManager >= INCOME_COMPANY) {
            fixTopManagerSalary += fixTopManagerSalary * BONUS_TOP_MANAGER;
        }
        return fixTopManagerSalary;
    }

    @Override
    public String toString() {
        return "TopManager {" + "topManagerSalary = " + getMonthSalary() + " руб." +'}';
    }
}
