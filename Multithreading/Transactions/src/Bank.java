import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Bank extends Thread {

    private Map<String, Account> accounts = new LinkedHashMap<>();
    private Map<String, Account> deletedAcc = new LinkedHashMap<>();

    private final Random random = new Random();

    @Override
    public void run() {
//        synchronized (this) {
            try {
                sleep(1000);
                transfer("BY1", "BY2", 51000);
                transfer("BY3", "BY4", 2000);
                transfer("BY5", "BY6", 50000);
                transfer("BY7", "BY8", 50001);
                transfer("BY9", "BY10", 100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            notify();
//        }
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */

    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (getBalance(fromAccountNum) > amount) {
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
            System.out.println("Операция со счетами " + fromAccountNum + ", " + toAccountNum + " выполнена успешно" + System.lineSeparator() +
                    "Остаток на счету №: " + fromAccountNum + " равен " + getBalance(fromAccountNum) + System.lineSeparator() +
                    "Остаток на счету №: " + toAccountNum + " равен " + getBalance(toAccountNum) + System.lineSeparator());
            if (amount > 50000) {
                isFraud(fromAccountNum, toAccountNum, amount);
                    System.out.println("Вы перевели со счета №: " + fromAccountNum + " на счет №: " + toAccountNum +
                            " сумму превышающую " + 50000 + " рублей" + " , поэтому дальнейшие операции по этим счетам - невозможны (оба счета заблокированы)" + System.lineSeparator());
                    blockedAcc(fromAccountNum);
                    blockedAcc(toAccountNum);
                }
        } else {
            System.out.println("На счете № " + fromAccountNum + " - недостаточно средств, невозможно выполнить операцию" + System.lineSeparator());
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

    public Map<String, Account> blockedAcc(String accountNum) {
        deletedAcc.put(accountNum, accounts.get(accountNum));
        accounts.remove(accountNum);
        return deletedAcc;
    }
}
