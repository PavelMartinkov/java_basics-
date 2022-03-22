public class Dimensions {

    private final int width; //meters
    private final int height; //meters
    private final int length; //meters


    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }


    public Dimensions setWidth (int width) {
        return new Dimensions(width, height, length);
    }

    public Dimensions setHeight (int height) {
        return new Dimensions(width, height, length);
    }

    public Dimensions setLength (int length) {
        return new Dimensions(width, height, length);
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int volumeCargo() {
        int volume = width * length * height;
        System.out.println("Объем груза равен: " + volume);
        return volume;
    }

    public String toString() {
        return "\n" +
                "ширина: " + width + " метра " + "\n" +
                "высота: " + height + " метра " + "\n" +
                "длина: " + length + " метра ";
    }
}
