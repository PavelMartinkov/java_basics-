public class Basket {

    private static int countBasket = 0;
    private static int totalPrice = 0;
    private static int countItemsInOneBasket = 0;
    private static int totalCountAllItemsInAllBasket = 0;
    private String items = "";
    private int limit;
    private double totalWeight = 0;


    public Basket() {
        increaseCountBasket(1);
        increaseTotalPrice();
        increaseCountItemsInOneBasket();
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static void increaseCountBasket(int countBasket) {
        Basket.countBasket = Basket.countBasket + countBasket;
    }

    public static int getCountBasket() {
        return countBasket;
    }

    public static void increaseTotalPrice() {
        Basket.totalPrice = Basket.totalPrice + totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public static void increaseCountItemsInOneBasket() {
        Basket.countItemsInOneBasket = Basket.countItemsInOneBasket + countItemsInOneBasket;
    }

    public int getCountItemsInOneBasket() {
        return countItemsInOneBasket;
    }

    public static void averagePriceItemsInAllBasket() {
        int averagePriceItemsInAllBasket = totalPrice / totalCountAllItemsInAllBasket;
        return;
    }

    public static void averagePriceBasket() {
        int averagePriceBasket = totalPrice / countBasket;
        return;
    }


    public void add(String name, int price) {
        add(name, price);
    }

    public void add(String name, int price, double weight, int countItemsInOneBasket) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + countBasket * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                price + " RUB - " + weight + " kg - " + "кол-во товара - " + countItemsInOneBasket + " шт.";
        totalPrice = totalPrice + countBasket * price;
        totalWeight = totalWeight + weight;
        totalCountAllItemsInAllBasket = totalCountAllItemsInAllBasket + countItemsInOneBasket;


    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalCountAllItemsInAllBasket = 0;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        System.out.println();
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общее количество товаров: " + totalCountAllItemsInAllBasket + " шт.");
            System.out.println("Общая цена: " + totalPrice + " RUB ");
        }
    }
}