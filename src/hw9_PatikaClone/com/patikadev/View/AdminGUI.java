package hw9_PatikaClone.com.patikadev.View;

import hw9_PatikaClone.com.patikadev.Helper.Config;
import hw9_PatikaClone.com.patikadev.Helper.Helper;
import hw9_PatikaClone.com.patikadev.Model.Admin;
import hw9_PatikaClone.com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tab_admin;
    private JLabel lbl_greeting;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_users;
    private JScrollPane scrl_users;
    private JTable tbl_users;
    private DefaultTableModel mdl_users;
    private Object[] row_users;

    private final Admin admin;

    public AdminGUI(Admin admin) {
        this.admin = admin;
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.setScreenCenter('x', getSize()), Helper.setScreenCenter('y', getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_greeting.setText("Hoşgeldin, " + admin.getName());
        // create user table
        mdl_users = new DefaultTableModel();
        Object[] col_users = {"ID", "ADI SOYADI", "KULLANICI ADI", "ŞİFRE", "ROL"};
        mdl_users.setColumnIdentifiers(col_users);
        for (User user : User.getList()) {
            mdl_users.addRow(user.getData());
        }
        tbl_users.setModel(mdl_users);
        tbl_users.getTableHeader().setReorderingAllowed(false);

    }

    public static void main(String[] args) {
        Helper.setLayout();

        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("Celal Gündoğdu");
        admin.setUsername("celal");
        admin.setPassword("123");
        admin.setType("admin");

        AdminGUI adminGUI = new AdminGUI(admin);
    }
}
