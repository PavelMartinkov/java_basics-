import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class BankTest extends TestCase {

    private Bank bank;

    @Before
    protected void setUp() {
        bank = new Bank();
        bank.createAccounts();
    }

    @Test
    public void testTransfer() {

        Long actual = bank.getSumAllAccounts();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                    try {
                        bank.transfer("BY1", "BY2", 10_000);
                        bank.transfer("BY2", "BY1", 10_000);
                        bank.transfer("BY2", "BY3", 50_000);
                        bank.transfer("BY3", "BY4", 51_000);
                        bank.transfer("BY4", "BY2", 2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }));
        }
        threads.forEach(Thread::start);

        Long expected = bank.getSumAllAccounts();
        assertEquals(expected, actual);
    }

    @After
    protected void tearDown() {
        System.out.println("Tests finished");
    }
}
