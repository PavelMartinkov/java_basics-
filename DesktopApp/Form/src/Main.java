import javax.swing.*;

public class Main {

    public static JFrame frameMain = new JFrame();
    public static JFrame frameSecond = new JFrame();

    public static void main(String[] args) {
        createMainForm();
    }

    public static void createMainForm() {
        frameMain.setSize(500, 200);
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMain.setLocationRelativeTo(null);
        frameMain.add(new MainForm().getMainPanel());
    }

    public static void createSecondForm() {
        frameSecond.setSize(500, 200);
        frameSecond.setVisible(true);
        frameSecond.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameSecond.setLocationRelativeTo(null);
        frameSecond.add(new SecondForm().getSecondForm());
    }
}
