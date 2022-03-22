public class Cargo {

    private final Dimensions dimensions; // габариты
    private final double weight; // тонны
    private final String deliveryAddress;
    private boolean flip = false; // можно ли переворачивать
    private String carNumber;
    private boolean brittleCargo = false; // хрупкий ли груз


    public Cargo(Dimensions dimensions, double weight, String deliveryAddress) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;

    }


    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions, weight, deliveryAddress);
    }

    public Cargo setWeight(double weight) {
        return new Cargo(dimensions, weight, deliveryAddress);
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress);
    }


    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }


    public String toString() {
        return "габариты груза: " + dimensions + "\n" +
                "вес груза: " + weight + " тонны " + "\n" +
                "адрес доставки: " + deliveryAddress;
    }
}