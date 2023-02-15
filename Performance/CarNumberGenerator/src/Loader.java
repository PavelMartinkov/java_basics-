public class Loader extends Thread {

    public static void main(String[] args) {

        CreateThreads threads1 = new CreateThreads(1, 25, "res/numbers1.txt");
        threads1.start();
        CreateThreads threads2 = new CreateThreads(26, 50, "res/numbers2.txt");
        threads2.start();
        CreateThreads threads3 = new CreateThreads(51, 75, "res/numbers3.txt");
        threads3.start();
        CreateThreads threads4 = new CreateThreads(76, 100, "res/numbers4.txt");
        threads4.start();
    }
}
