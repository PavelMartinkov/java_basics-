public class KeyBoard {

    private final String type; //тип
    private final double weight; //вес, грамм
    private boolean backlight = true; //наличие подсветки

    public KeyBoard(String type, double weight, boolean backlight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\n" +
                "тип - " + type + "\n" +
                "вес - " + weight + " грамм ";
    }
}