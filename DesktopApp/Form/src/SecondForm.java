import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class SecondForm {

    private JPanel secondPanel;
    private JButton checkInformationExpand;
    private JLabel FIO;
    private JTextField textFieldFIO;
//    private MainForm mainForm;

    public SecondForm() {
        checkInformationExpand.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldFIO.getText().split(" ").length >= 2) {
                    Main.createMainForm();
                    Main.frameSecond.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(
                            secondPanel,
                            "Данные Фамилия и Имя должны быть заполнены обязательно",
                            "Возникла ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    public JPanel getSecondForm() {
        return secondPanel;
    }

    public JTextField getTextFieldFIO() {
        return textFieldFIO;
    }
}
