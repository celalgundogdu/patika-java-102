package hw9_PatikaClone.com.patikadev.View;

import hw9_PatikaClone.com.patikadev.Helper.Config;
import hw9_PatikaClone.com.patikadev.Helper.Helper;
import hw9_PatikaClone.com.patikadev.Model.Admin;
import hw9_PatikaClone.com.patikadev.Model.Patika;
import hw9_PatikaClone.com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class AdminGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tab_admin;
    private JLabel lbl_greeting;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_users;
    private JScrollPane scrl_users;
    private JTable tbl_users;
    private JPanel pnl_user_form;
    private JLabel lbl_user_name;
    private JTextField fld_user_name;
    private JLabel lbl_user_username;
    private JTextField fld_user_username;
    private JTextField fld_user_password;
    private JLabel lbl_user_password;
    private JLabel lbl_user_type;
    private JComboBox cbox_user_type;
    private JButton btn_user_add;
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JTextField fld_search_name;
    private JLabel fld_search_user_name;
    private JTextField fld_search_username;
    private JComboBox cbox_search_type;
    private JButton btn_user_search;
    private JPanel pnl_patika;
    private JScrollPane scroll_patika;
    private JTable tbl_patika_list;
    private JPanel pnl_patika_add;
    private JTextField fld_patika_name;
    private JButton btn_patika_add;
    private DefaultTableModel mdl_users;
    private DefaultTableModel mdl_patika_list;
    private JPopupMenu menu_patika;

    private final Admin admin;

    public AdminGUI(Admin admin) {
        this.admin = admin;
        add(wrapper);
        setSize(1000, 600);
        setLocation(Helper.setScreenCenter('x', getSize()), Helper.setScreenCenter('y', getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_greeting.setText("Hoşgeldin, " + admin.getName());
        // create user table
        mdl_users = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_users = {"ID", "ADI SOYADI", "KULLANICI ADI", "ŞİFRE", "ROL"};
        mdl_users.setColumnIdentifiers(col_users);
        loadUserModel();
        tbl_users.setModel(mdl_users);
        tbl_users.getTableHeader().setReorderingAllowed(false);

        // find user id in selected row
        tbl_users.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selectedUserId = tbl_users.getValueAt(tbl_users.getSelectedRow(), 0).toString();
                fld_user_id.setText(selectedUserId);
            } catch (Exception ex) {
                // prevent index out of bounds exception
            }
        });

        // change attributes using table
        tbl_users.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int id = Integer.parseInt(tbl_users.getValueAt(tbl_users.getSelectedRow(), 0).toString());
                String name = tbl_users.getValueAt(tbl_users.getSelectedRow(), 1).toString();
                String username = tbl_users.getValueAt(tbl_users.getSelectedRow(), 2).toString();
                String password = tbl_users.getValueAt(tbl_users.getSelectedRow(), 3).toString();
                String type = tbl_users.getValueAt(tbl_users.getSelectedRow(), 4).toString();

                if (User.update(id, name, username, password, type)) {
                    Helper.showMessage("success");
                }

                loadUserModel();
            }
        });

        // patika menu
        menu_patika = new JPopupMenu();
        JMenuItem menu_update = new JMenuItem("Düzenle");
        JMenuItem menu_delete = new JMenuItem("Sil");
        menu_patika.add(menu_update);
        menu_patika.add(menu_delete);

        menu_update.addActionListener(e -> {
            int selectedId = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
            PatikaUpdateGUI patikaUpdateGUI = new PatikaUpdateGUI(Patika.findById(selectedId));
            patikaUpdateGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPatikaModel();
                }
            });
        });

        menu_delete.addActionListener(e -> {
            if (Helper.confirm("decision")) {
                int selectedId = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
                if (Patika.delete(selectedId)) {
                    Helper.showMessage("success");
                    loadPatikaModel();
                } else {
                    Helper.showMessage("error");
                }
            }
        });

        // create patika table
        mdl_patika_list = new DefaultTableModel();
        Object[] col_patika = {"ID", "Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika);
        loadPatikaModel();
        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_patika_list.setComponentPopupMenu(menu_patika);

        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow = tbl_patika_list.rowAtPoint(point);
                tbl_patika_list.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });


        // add user
        btn_user_add.addActionListener(e -> {
            if (Helper.isTextFieldEmpty(fld_user_name) || Helper.isTextFieldEmpty(fld_user_username) || Helper.isTextFieldEmpty(fld_user_password)){
                Helper.showMessage("fill");
            } else {
                String name = fld_user_name.getText();
                String username = fld_user_username.getText();
                String password = fld_user_password.getText();
                String type = cbox_user_type.getSelectedItem().toString();
                if (User.add(name, username, password, type)){
                    Helper.showMessage("success");
                    loadUserModel();
                    fld_user_name.setText(null);
                    fld_user_username.setText(null);
                    fld_user_password.setText(null);
                    cbox_user_type.setSelectedIndex(0);
                }

            }
        });

        // delete user
        btn_user_delete.addActionListener(e -> {
            if (Helper.isTextFieldEmpty(fld_user_id)) {
                Helper.showMessage("fill");
            } else {
                if (Helper.confirm("decision")) {
                    if (User.delete(Integer.parseInt(fld_user_id.getText()))) {
                        Helper.showMessage("success");
                        loadUserModel();
                    } else {
                        Helper.showMessage("error");
                    }
                }
            }
        });

        // search user
        btn_user_search.addActionListener(e -> {
            String nameToSearch = fld_search_name.getText();
            String usernameToSearch = fld_search_username.getText();
            String userTypeToSearch = cbox_search_type.getSelectedItem().toString();
            String query = User.createSearchQuery(nameToSearch, usernameToSearch, userTypeToSearch);
            List<User> userListToSearch = User.search(query);
            loadUserModel(userListToSearch);
        });

        // logout
        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // add patika
        btn_patika_add.addActionListener(e -> {
            if (Helper.isTextFieldEmpty(fld_patika_name)) {
                Helper.showMessage("fill");
            } else {
                if (Patika.add(fld_patika_name.getText())) {
                    Helper.showMessage("success");
                    loadPatikaModel();
                    fld_patika_name.setText(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });
    }

    public void loadUserModel() {
        mdl_users.setRowCount(0);
        for (User user : User.getList()) {
            mdl_users.addRow(user.getData());
        }
    }

    public void loadUserModel(List<User> userList) {
        mdl_users.setRowCount(0);
        for (User user : userList) {
            mdl_users.addRow(user.getData());
        }
    }

    private void loadPatikaModel() {
        mdl_patika_list.setRowCount(0);
        for (Patika patika : Patika.getList()) {
            mdl_patika_list.addRow(patika.getData());
        }
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
