public class CompanyClient extends Client {

    protected final double COMMISSION = 0.01;

    public CompanyClient() {
    }

    @Override
    public void take(double amount) {
        super.take(amount);
        if (amount <= amountOfMoney || amount >= 100) {
            amountOfMoney -= amount * COMMISSION;
        }
        else {
            System.out.println("Возникла ошибка");
        }
    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}
