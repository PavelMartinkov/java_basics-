public class IndividualEntrepreneurClient extends Client {

    protected final double COMMISSION1PERCENT = 0.01;
    protected final double COMMISSION0_5PERCENT = 0.005;

    public IndividualEntrepreneurClient() {
    }

    @Override
    public void put(double amount) {
        super.put(amount);
        if (amount < 1000) {
            amountOfMoney -= amount * COMMISSION1PERCENT;
        } else if (amount >= 1000) {
            amountOfMoney -= amount * COMMISSION0_5PERCENT;
        }
    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}
