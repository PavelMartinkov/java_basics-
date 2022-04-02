public class Screen {

    private final double diagonal; //диагональ экрана, дюйм
    private final String type; //тип, (IPS, TN, VA)
    private final double weight; //вес, грамм

    public Screen(double diagonal, String type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\n" +
                "диагональ экрана - " + diagonal + " дюйм " + "\n" +
                "тип - " + type + "\n" +
                "вес - " + weight + " грамм ";
    }
}
