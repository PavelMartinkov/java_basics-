public class Elevator {

    private int minFloor = -3;
    private int maxFloor = 26;
    private int currentFloor = 1;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ?
                currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ?
                currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        if (currentFloor == floor) {
            System.out.println("Лифт стоит на месте");
        } else if (floor < minFloor || floor > maxFloor) {
            System.out.println("Произошла ошибка");
        } else {
            while (currentFloor != floor)
                if (currentFloor < floor) {
                    moveUp();
                    System.out.println("Лифт поднимается на: " + currentFloor + " этаж");
                } else if (currentFloor > floor) {
                    moveDown();
                    System.out.println("Лифт спускается на: " + currentFloor + " этаж");
                }
        }
    }
}