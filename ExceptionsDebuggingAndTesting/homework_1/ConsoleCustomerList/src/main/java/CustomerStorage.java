import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer (String data) {

            final int INDEX_NAME = 0;
            final int INDEX_SURNAME = 1;
            final int INDEX_EMAIL = 2;
            final int INDEX_PHONE = 3;

            String[] components = data.split("\\s+");
            if (components.length != 4) {
                throw new IllegalArgumentException("Неверное количество компонентов");
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

            String regexNumber = "\\+[7][9][\\d]{9}";
            String regexEmail = "[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}";

            Pattern pattern = Pattern.compile(regexNumber);
            Matcher matcher = pattern.matcher(components[3]);

            Pattern pattern1 = Pattern.compile(regexEmail);
            Matcher matcher1 = pattern1.matcher(components[2]);

            if (!matcher.find()) {
                throw new IllegalArgumentException("Неверный формат номера телефона");
            }
            if (!matcher1.find()) {
                throw new IllegalArgumentException("Неверный формат email");
            }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}