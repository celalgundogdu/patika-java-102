package hw9_PatikaClone.com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setLayout() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static int setScreenCenter(char axis, Dimension size) {
        int center = 0 ;
        if (axis == 'x') {
            center = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
        } else {
            center = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
        }

        return center;
    }

}
