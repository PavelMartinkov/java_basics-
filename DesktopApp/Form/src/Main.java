import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frameMain = new JFrame();
        frameMain.setSize(500, 200);
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMain.setLocationRelativeTo(null);
        frameMain.add(new MainForm().getMainPanel());
    }
}
