public class Main {

    public static void main(String[] args) {
        Basket pavel = new Basket();
        pavel.add("Milk", 120,1.5, 3);
        pavel.add("Cheese", 600, 2.4,6);
        pavel.add("Bread", 70, 0.9, 2);
        pavel.print("Корзина Павла:");
    }
}