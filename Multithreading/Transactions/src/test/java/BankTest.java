import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BankTest extends TestCase {

//   private Map<String, Account> accounts;
   private Bank bank;

    @Before
    protected void setUp() throws Exception {
        bank = new Bank();
        bank.createAccounts();

//        Account account1 = new Account("BY1", 100_000);
//        Account account2 = new Account("BY2", 50_000);
//        Account account3 = new Account("BY3", 1000);
//        Account account4 = new Account("BY4", 80_000);
//        Account account5 = new Account("BY5", 500);
//
//        accounts.put("BY1", account1);
//        accounts.put("BY2", account2);
//        accounts.put("BY3", account3);
//        accounts.put("BY4", account4);
//        accounts.put("BY5", account5);
    }


    @Test
    public void testTransfer() throws InterruptedException {
//        Long actual = bank.getSumAllAccounts();
//        List<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            threads.add(new Thread(() -> {
//                try {
//                    bank.transfer("BY1", "BY2", 10_000);
//                    bank.transfer("BY2", "BY3", 15_000);
//                    bank.transfer("BY4", "BY5", 7000);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }));
//        }
        Long actual = bank.getSumAllAccounts();

        bank.transfer("BY1", "BY2", 10_000);
        bank.transfer("BY2", "BY3", 15_000);
        bank.transfer("BY4", "BY5", 7000);

        Long expected = bank.getSumAllAccounts();
        assertEquals(expected,actual);
    }

    @After
    protected void tearDown() throws Exception {
        System.out.println("Tests finished");
    }
}
