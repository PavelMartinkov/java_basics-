import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BankTest extends TestCase {

    private Bank bank;

    @Before
    protected void setUp() throws Exception {
        bank = new Bank();
        bank.createAccounts();
    }


    @Test
    public void testTransfer() throws InterruptedException {

        Long actual = bank.getSumAllAccounts();

        bank.transfer("BY1", "BY2", 10_000);
        bank.transfer("BY2", "BY3", 50_000);
        bank.transfer("BY3", "BY4", 51_000);
        bank.transfer("BY4", "BY3", 2000);

        Long expected = bank.getSumAllAccounts();
        assertEquals(expected, actual);
    }

    @After
    protected void tearDown() throws Exception {
        System.out.println("Tests finished");
    }
}
