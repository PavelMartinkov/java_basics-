import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);

                if (tokens[0].equals("add")) {
                    executor.addCustomer(tokens[1]);
                    logger.info("Добавлен клиент: " + command.substring(4));
                } else if (tokens[0].equals("list")) {
                    executor.listCustomers();
                    logger.info("Список клиентов(вывод в консоль): ");
                } else if (tokens[0].equals("remove")) {
                    executor.removeCustomer(tokens[1]);
                    logger.info("Данный клиент удален: " + command.substring(7));
                } else if (tokens[0].equals("count")) {
                    logger.info("There are " + executor.getCount() + " customers");
                } else if (tokens[0].equals("help")) {
                    logger.info(helpText);
                } else {
                    System.out.println(COMMAND_ERROR);
                    logger.error("Возникла ошибка" , new IllegalArgumentException("Неверный формат"));
                }
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Допишите данные клиента");
            }
        }
    }
}
