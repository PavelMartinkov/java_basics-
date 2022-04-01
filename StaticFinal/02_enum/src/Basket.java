public class Basket {

    private static int totalCountBasket = 0;
    private static int totalPrice = 0;
    private static int countItemsInOneBasket = 0;
    private static int totalCountAllItemsInAllBasket = 0;
    private String items = "";
    private int limit;
    private double totalWeight = 0;


    public Basket() {
        increaseTotalCountBasket(0);
        increaseTotalPrice(0);
        increaseTotalCountAllItemsInAllBasket(0);
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

    public static void increaseTotalCountBasket(int countBasket) {
        Basket.totalCountBasket = Basket.totalCountBasket + countBasket;
    }

    public static int getTotalCountBasket() {
        return totalCountBasket;
    }

    public static void increaseTotalPrice(int price) {
        Basket.totalPrice = Basket.totalPrice + price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public static void increaseTotalCountAllItemsInAllBasket(int countItemsInOneBasket) {
        Basket.totalCountAllItemsInAllBasket = Basket.totalCountAllItemsInAllBasket + countItemsInOneBasket;
    }

    public int getTotalCountAllItemsInAllBasket() {
        return totalCountAllItemsInAllBasket;
    }

    public static void averagePriceItemsInAllBasket() {
        int averagePriceItemsInAllBasket = totalPrice / totalCountAllItemsInAllBasket;
        return;
    }

    public static void averagePriceBasket() {
        int averagePriceBasket = totalPrice / totalCountBasket;
        return;
    }


    public void add(String name, int price) {
        add(name, price);
    }

    public void add(String name, int price, double weight, int countNewItem) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + countNewItem * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                price + " RUB - " + weight + " kg ";
        totalCountBasket = totalCountBasket + countNewItem;
        totalPrice = totalPrice + countNewItem * price;
        totalCountAllItemsInAllBasket = totalCountAllItemsInAllBasket + countNewItem;
        totalWeight = totalWeight + weight;

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
            System.out.println("Общее количество корзин: " + totalCountBasket + " шт.");
            System.out.println("Общее количество товаров: " + totalCountAllItemsInAllBasket + " шт.");
            System.out.println("Общая цена: " + totalPrice + " RUB ");
            System.out.println("Средняя цена товара во всех корзинах: " + totalPrice / totalCountAllItemsInAllBasket + " RUB ");
            System.out.println("Средняя стоимость корзины: " + totalPrice / totalCountBasket + " RUB ");
        }
    }
}