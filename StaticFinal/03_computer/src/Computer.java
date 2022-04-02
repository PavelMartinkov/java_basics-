public class Computer {

    private final String vendor; //производитель
    private final String name;
    private final Processor processor;
    private final Ram ram;
    private final InformationStorage informationStorage;
    private final Screen screen;
    private final KeyBoard keyBoard;


    public Computer(String vendor, String name, Processor processor, Ram ram, InformationStorage informationStorage, Screen screen, KeyBoard keyBoard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.informationStorage = informationStorage;
        this.screen = screen;
        this.keyBoard = keyBoard;
    }

    public Computer setVendor(String vendor) {
        return new Computer(vendor, name, processor, ram, informationStorage, screen, keyBoard);
    }

    public Computer setName(String name) {
        return new Computer(vendor, name, processor, ram, informationStorage, screen, keyBoard);
    }

    public Computer setProcessor(Processor processor) {
        return new Computer(vendor, name, processor, ram, informationStorage, screen, keyBoard);
    }

    public Computer setRam(Ram ram) {
        return new Computer(vendor, name, processor, ram, informationStorage, screen, keyBoard);
    }

    public Computer setInformationStorage(InformationStorage informationStorage) {
        return new Computer(vendor, name, processor, ram, informationStorage, screen, keyBoard);
    }

    public Computer setScreen(Screen screen) {
        return new Computer(vendor, name, processor, ram, informationStorage, screen, keyBoard);
    }

    public Computer setKeyBoard(KeyBoard keyBoard) {
        return new Computer(vendor, name, processor, ram, informationStorage, screen, keyBoard);
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Ram getRam() {
        return ram;
    }

    public InformationStorage getInformationStorage() {
        return informationStorage;
    }

    public Screen getScreen() {
        return screen;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public double totalWeightComputer() {
        return processor.getWeight() +
                ram.getWeight() +
                informationStorage.getWeight() +
                screen.getWeight() +
                keyBoard.getWeight();
    }

    public String toString() {
        return "Производитель: " + vendor + "\n" +
                "Название: " + name + "\n" +
                "Процессор: " + processor + "\n" +
                "Оперативная память: " + ram + "\n" +
                "Накопитель информации: " + informationStorage + "\n" +
                "Экран: " + screen + "\n" +
                "Клавиатура: " + keyBoard + "\n";
    }
}
