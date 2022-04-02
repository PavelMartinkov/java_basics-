public class Processor { //Процессор

    private final double frequency; //частота, ГГц
    private final int countCores; //кол-во ядер
    private final int performance; //производительность компьютера, %
    private final double weight; //вес, грамм

    public Processor(double frequency, int countCores, int performance, double weight) {
        this.frequency = frequency;
        this.countCores = countCores;
        this.performance = performance;
        this.weight = weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCountCores() {
        return countCores;
    }

    public int getPerformance() {
        return performance;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\n" +
                "частота - " + frequency + " ГГц " + "\n" +
                "количество ядер - " + countCores + "\n" +
                "производительность компьютера - " + performance + " % " + "\n" +
                "вес - " + weight + " грамм ";
    }
}