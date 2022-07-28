public class Operator implements Employee, Comparable {

    private final double FIX_OPERATOR_SALARY = 50_000;
    private double moneyForCompanyByOperator;


    public Operator(double moneyForCompanyByOperator) {
        this.moneyForCompanyByOperator = moneyForCompanyByOperator;
    }

    @Override
    public double getMonthSalary() {
        return FIX_OPERATOR_SALARY;
    }

    @Override
    public String toString() {
        return "Operator {" + "operatorSalary = " + getMonthSalary() + " руб." + '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
