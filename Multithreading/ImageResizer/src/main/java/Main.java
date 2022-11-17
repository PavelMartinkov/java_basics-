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
        int middle = files.length / 4;

        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        resizer1.start();

        File[] files2 = new File[middle];
        System.arraycopy(files, middle, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        resizer2.start();

        File[] files3 = new File[middle];
        System.arraycopy(files, middle * 2, files3, 0, files3.length);
        ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder, start);
        resizer3.start();

        File[] files4 = new File[middle];
        System.arraycopy(files, middle * 3, files4, 0, files4.length);
        ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder, start);
        resizer4.start();

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
