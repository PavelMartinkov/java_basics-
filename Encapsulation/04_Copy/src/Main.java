public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(3,5,7);
        dimensions.setWidth(2);
        dimensions.setHeight(4);
        dimensions.setLength(6);
        Cargo cargo = new Cargo(dimensions,4.4,"г.Москва, ул.Ленинская, д.17");
        // some code

        cargo.setDimensions(dimensions);
        boolean a = cargo.getDimensions() == new Dimensions(2, 4, 6);
        cargo.setWeight(4.4);
        boolean b = cargo.getWeight() == 20.5;
        cargo.setDeliveryAddress("г.Москва, ул.Ленинская, д.17");
        boolean c = cargo.getDeliveryAddress() == "г.Минск, ул.Макаенка. д.24";
        System.out.println(cargo);
        Dimensions copy = new Dimensions (
                dimensions.getWidth(),
                dimensions.getHeight(),
                dimensions.getLength());
        Cargo copy1 = new Cargo(
                cargo.getDimensions(),
                cargo.getWeight(),
                cargo.getDeliveryAddress());
    }
}

