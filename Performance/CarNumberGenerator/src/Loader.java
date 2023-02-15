import java.io.PrintWriter;

public class Loader extends Thread {

    public static void main(String[] args) {

        for (int i = 1; i <= 2; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long start = System.currentTimeMillis();

                        PrintWriter writer1 = new PrintWriter("res/numbers1.txt");
                        PrintWriter writer2 = new PrintWriter("res/numbers2.txt");

                        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
                        for (int regionCode = 1; regionCode <= 100; regionCode++) {
                            StringBuilder builder = new StringBuilder();
                            for (int number = 1; number < 1000; number++) {
                                for (char firstLetter : letters) {
                                    for (char secondLetter : letters) {
                                        for (char thirdLetter : letters) {
                                            builder.append(firstLetter);
                                            builder.append(padNumber(number, 3));
                                            builder.append(secondLetter);
                                            builder.append(thirdLetter);
                                            builder.append(padNumber(regionCode, 2));
                                            builder.append("\n");
                                        }
                                    }
                                }
                            }
                            if (regionCode <= 50) {
                                writer1.write(builder.toString());
                            } else {
                                writer2.write(builder.toString());
                            }
                        }
                        writer1.flush();
                        writer2.flush();
                        writer1.close();
                        writer2.close();

                        System.out.println("Parsing time for: " + Thread.currentThread().getName() + " - " + (System.currentTimeMillis() - start) + " ms");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        while (numberStr.length() < numberLength) {
            numberStr = "0".concat(numberStr);
        }
        return numberStr;
    }
}
