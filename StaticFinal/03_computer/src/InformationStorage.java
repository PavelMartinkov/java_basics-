public class InformationStorage {

    private final String type; //тип, HDD,SSD
    private final int memory; //объем памяти, ГБ
    private final double weight; //вес, грамм

    public InformationStorage(String type, int memory, double weight) {
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
                "объем памяти - " + memory + " ГБ " + "\n" +
                "вес - " + weight + " грамм ";
    }
}
