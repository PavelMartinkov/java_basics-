
public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println(bank.createAccounts() + System.lineSeparator());
        System.out.println("Остаток на счете BY1: " + bank.getBalance("BY1") + " рублей");
        System.out.println("Остаток на счете BY3: " + bank.getBalance("BY3") + " рублей");
        System.out.println("Остаток на счете BY5: " + bank.getBalance("BY5") + " рублей");
        System.out.println("Остаток на счете BY7: " + bank.getBalance("BY7") + " рублей");
        System.out.println("Остаток на счете BY9: " + bank.getBalance("BY9") + " рублей"  + System.lineSeparator());
        bank.getSumAllAccounts();
        System.out.println();

        for (int i = 1; i <= 2; i++) {
            Thread thread = new Thread(bank);
            thread.start();
        }

//        bank.start


//        new Bank().start();
//        new Bank().start();
//        synchronized (bank) {
//            bank.wait();
//        }
    }
}
