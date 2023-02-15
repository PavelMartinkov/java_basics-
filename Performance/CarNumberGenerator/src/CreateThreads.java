import java.io.PrintWriter;

public class CreateThreads extends Thread {

    private final int startRegion;
    private final int endRegion;
    private final String pathFile;

    public CreateThreads(int startRegion, int endRegion, String pathFile) {
        this.startRegion = startRegion;
        this.endRegion = endRegion;
        this.pathFile = pathFile;
    }

    @Override
    public void run() {
        try {
            long start = System.currentTimeMillis();

            PrintWriter writer = new PrintWriter(pathFile);

            char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            for (int regionCode = startRegion; regionCode <= endRegion; regionCode++) {
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
                writer.write(builder.toString());
            }
            writer.flush();
            writer.close();

            System.out.println("Parsing time for: " + Thread.currentThread().getName() + " - " + (System.currentTimeMillis() - start) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
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
