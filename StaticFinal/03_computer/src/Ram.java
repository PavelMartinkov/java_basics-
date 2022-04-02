public class Ram {

    private final String type; //тип
    private final int memory; //объем, ГБ
    private final double weight; //вес, грамм

    public Ram(String type, int memory, double weight) {
        this.type = type;
        this.memory = memory;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getMemory() {
        return memory;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\n" +
                "тип - " + type + "\n" +
                "объем - " + memory + " ГБ " + "\n" +
                "вес - " + weight + " грамм ";
    }
}
