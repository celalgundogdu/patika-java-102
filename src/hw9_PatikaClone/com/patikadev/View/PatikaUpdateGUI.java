package hw9_PatikaClone.com.patikadev.View;

import hw9_PatikaClone.com.patikadev.Helper.Config;
import hw9_PatikaClone.com.patikadev.Helper.Helper;
import hw9_PatikaClone.com.patikadev.Model.Patika;

import javax.swing.*;

public class PatikaUpdateGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_patika_name;
    private JButton btn_update;
    private Patika patika;

    public PatikaUpdateGUI(Patika patika) {
        this.patika = patika;
        add(wrapper);
        setSize(300, 150);
        setLocation(Helper.setScreenCenter('x', getSize()), Helper.setScreenCenter('y', getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        fld_patika_name.setText(patika.getName());
        btn_update.addActionListener(e -> {
            if (Helper.isTextFieldEmpty(fld_patika_name)) {
                Helper.showMessage("fill");
            } else {
                if (Patika.update(patika.getId(), fld_patika_name.getText())) {
                    Helper.showMessage("success");
                }
                dispose();
            }
        });
    }

}
