public abstract class Client {

    protected double amountOfMoney;

    public Client() {
    }

    public Client(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void put(double amount) {
        if (amount < 0) {
            System.out.println("Сумма на счете: " + amountOfMoney);
        } else {
            amountOfMoney += amount;
            System.out.println("Сумма на счете: " + amountOfMoney);
        }
    }

    public void take(double amount) {
        if (amount > amountOfMoney) {
            System.out.println("Недостаточно средств" + '\n' + "Доступная сумма: " + amountOfMoney);
        } else {
            amountOfMoney -= amount;
            System.out.println("Сумма на счете: " + amountOfMoney);
        }
    }

    public abstract String getName();
}
