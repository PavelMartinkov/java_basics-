public class Main {

    public static void main(String[] args) {
        Basket pavel = new Basket();
        pavel.add("Milk", 120, 1.5, 2);
        pavel.add("Cheese", 600, 2.4, 1);
        pavel.add("Bread", 70, 0.9, 2);
        pavel.increaseTotalCountBasket(5);
        pavel.increaseTotalPrice(50);
        pavel.increaseTotalCountAllItemsInAllBasket(3);
        pavel.averagePriceItemsInAllBasket();
        pavel.averagePriceBasket();
        pavel.print("Корзина Павла:");
    }
}