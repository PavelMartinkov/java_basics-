import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private Map<String, Account> accounts = new LinkedHashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        synchronized (accounts.get(fromAccountNum).compareTo(accounts.get(toAccountNum)) > 0 ?
                        accounts.get(toAccountNum) : accounts.get(fromAccountNum)) {
            synchronized (accounts.get(fromAccountNum).compareTo(accounts.get(toAccountNum)) > 0 ?
                    accounts.get(fromAccountNum) : accounts.get(toAccountNum)) {
                if (!accounts.get(fromAccountNum).isBlocked() && !accounts.get(toAccountNum).isBlocked()) {
                    if (amount > 50000) {
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            blockedAcc(fromAccountNum);
                            blockedAcc(toAccountNum);
                            System.out.println("Вы перевели со счета №: " + fromAccountNum + " на счет №: " + toAccountNum +
                                    " сумму превышающую " + 50000 + " рублей" + " , поэтому дальнейшие операции по этим счетам - невозможны (оба счета заблокированы)" + System.lineSeparator());
                            return;
                        }
                    }
                    if (accounts.get(fromAccountNum).getMoney() < amount) {
                        System.out.println("На счете № " + fromAccountNum + " - недостаточно средств, невозможно выполнить операцию" + System.lineSeparator());
                        return;
                    }
                    accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                    accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                    System.out.println("Операция со счетами " + fromAccountNum + ", " + toAccountNum + " выполнена успешно" + System.lineSeparator() +
                            "Остаток на счету №: " + fromAccountNum + " равен " + getBalance(fromAccountNum) + System.lineSeparator() +
                            "Остаток на счету №: " + toAccountNum + " равен " + getBalance(toAccountNum) + System.lineSeparator());
                }
            }
        }
    }

    public Map<String, Account> createAccounts() {
        for (int i = 1; i <= 25; i++) {
            String name = "BY" + i;
            accounts.put(name, new Account(name, random.nextInt(100_000)));
        }
        return accounts;
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        AtomicLong atomicLong = new AtomicLong();
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            atomicLong.addAndGet(entry.getValue().getMoney());
        }
        System.out.println("Общая сумма на всех счетах: " + atomicLong + " рублей");
        return atomicLong.get();
    }

    public void blockedAcc(String accountNum) {
        accounts.get(accountNum).setBlocked(true);
    }
}
