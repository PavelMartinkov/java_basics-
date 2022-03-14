public class Country {

    private String name;
    private int countPeople;
    private int squareArea;  // km
    private String capitalName;
    private boolean accessSea = true;

    public Country(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setSquareArea(int squareArea) {
        this.squareArea = squareArea;
    }

    public int getSquareArea() {
        return squareArea;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setAccessSea(boolean accessSea) {
        this.accessSea = accessSea;
    }

    public boolean getAccessSea() {
        return accessSea;
    }
}

