public class Main {
    public static void main(String[] args) {
        Processor processor = new Processor(2.3, 8, 20, 100.9);
        Ram ram = new Ram("DDR4", 16, 50.3);
        InformationStorage informationStorage = new InformationStorage("HDD", 8, 23.4);
        Screen screen = new Screen(15.6, "IPS", 507.2);
        KeyBoard keyBoard = new KeyBoard("Механическая", 313.5, true);
        Computer computer = new Computer("Acer", "Nitro 5", processor, ram, informationStorage, screen, keyBoard);
        System.out.println(computer);
        System.out.println("Суммарный вес всех комплектующих компьютера: " + computer.totalWeightComputer() + " грамм ");
    }
}
