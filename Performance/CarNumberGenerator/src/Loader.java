import java.io.PrintWriter;

public class Loader extends Thread {

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер: " + cores + System.lineSeparator());

        for (int i = 1; i <= cores; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long start = System.currentTimeMillis();

                        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
                        for (int regionCode = 1; regionCode <= 4; regionCode++) {
                            PrintWriter writer = new PrintWriter("res/numbers" + regionCode + ".txt");
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
                            writer.write(builder.substring(0, builder.length()));
                            writer.flush();
                            writer.close();
                        }
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
