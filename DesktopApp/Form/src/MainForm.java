import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {

    private JPanel mainPanel;
    private JButton buttonCollapse;
    private JLabel surname;
    private JLabel name;
    private JLabel patronymic;
    private JTextField textFieldSurname;
    private JTextField textFieldName;
    private JTextField textFieldPatronymic;
    private boolean collapse;

    public MainForm() {
        buttonCollapse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (collapse) {
                    expand();
                } else {
                    collapse();
                }
            }
        });
    }

    private void collapse() {
        if (textFieldSurname.getText().equals("") || textFieldName.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Пожалуйста заполните все обязательные поля(*)",
                    "Возникла ошибка",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        collapse = true;
        String fio = textFieldSurname.getText().concat(" ")
                .concat(textFieldName.getText()).concat(" ")
                .concat(textFieldPatronymic.getText());
        surname.setText("Ф.И.О.");
        textFieldSurname.setText(fio);
        name.setVisible(false);
        textFieldName.setVisible(false);
        patronymic.setVisible(false);
        textFieldPatronymic.setVisible(false);

        buttonCollapse.setText("Expand");
    }

    private void expand() {
        collapse = false;
        String[] fio = textFieldSurname.getText().split(" ");
        if (fio.length < 2) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Данные Фамилия и Имя должны быть заполнены обязательно",
                    "Возникла ошибка",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        surname.setText("Фамилия:*");
        textFieldSurname.setText(fio[0]);
        name.setVisible(true);
        name.setText("Имя:*");
        textFieldName.setVisible(true);
        textFieldName.setText(fio[1]);
        patronymic.setVisible(true);
        patronymic.setText("Отчесвто:");
        textFieldPatronymic.setVisible(true);
        textFieldPatronymic.setText(fio[2]);

        buttonCollapse.setText("Collapse");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
