public class Account {

    private long money;

    private String accNumber;

    private boolean isBlocked = false;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "Номер счета: " + accNumber + " Остаток на счету: " + money + " рублей";
    }
}
