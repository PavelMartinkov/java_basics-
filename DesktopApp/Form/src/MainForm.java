import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {

    private JPanel mainPanel;
    private JButton checkInformationCollapse;
    private JLabel surname;
    private JLabel name;
    private JLabel patronymic;
    private JTextField textFieldSurname;
    private JTextField textFieldName;
    private JTextField textFieldPatronymic;
//    private SecondForm secondForm;

    public MainForm() {
        checkInformationCollapse.addActionListener(new Action() {
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
                if (textFieldSurname.getText().equals("") || textFieldName.getText().equals("")) {
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "Пожалуйста заполните все обязательные поля(*)",
                            "Возникла ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    Main.createSecondForm();
                    Main.frameMain.setVisible(false);
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldPatronymic() {
        return textFieldPatronymic;
    }
}
