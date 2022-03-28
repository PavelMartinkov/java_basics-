public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(3,5,7);
        Dimensions a = dimensions.setWidth(2);
        Dimensions b = dimensions.setHeight(4);
        Dimensions c = dimensions.setLength(6);
        Cargo cargo = new Cargo(dimensions,4.4,"г.Москва, ул.Ленинская, д.17");
        // some code
        Cargo a1 = cargo.setDimensions(new Dimensions(2,4,6));
        Cargo b1 = cargo.setWeight(6.8);
        Cargo c1 = cargo.setDeliveryAddress("г.Минск, ул.Макаенка, д.8");
        Cargo cargo1 = new Cargo(new Dimensions(2,4,6), 6.8,"г.Минск, ул.Макаенка, д.8");
        System.out.println(cargo1);
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