import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    private static int newWidth = 500;

    public static void main(String[] args) {

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер: " + cores);

        String srcFolder = "C:/src";
        String dstFolder = "C:/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int middle = files.length / cores;

        for (int i = 0; i < cores; i++) {
            File[] file = new File[middle];
            System.arraycopy(files, middle * i, file, 0, file.length);
            ImageResizer resizer = new ImageResizer(file, newWidth, dstFolder, start);
            resizer.start();
        }

        System.out.println();

        String originalPath = "C:/src/img.jpeg";
        String targetPath = "C:/src/img333.jpeg";
        int targetWidth = 2000;
        int targetHeight = 1500;

        resizeFile(originalPath, targetPath, targetWidth, targetHeight);
    }

    public static void resizeFile(String originalPath, String targetPath, int targetWidth, int targetHeight) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(originalPath));
            BufferedImage resizedImage = Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.AUTOMATIC, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);

            File resizedFile = new File(targetPath);
            ImageIO.write(resizedImage, "jpg", resizedFile);

            originalImage.flush();
            resizedImage.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
