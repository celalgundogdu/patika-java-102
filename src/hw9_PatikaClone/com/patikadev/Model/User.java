package hw9_PatikaClone.com.patikadev.Model;

import hw9_PatikaClone.com.patikadev.Helper.DBConnector;
import hw9_PatikaClone.com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    private String type;

    public User() {
    }

    public User(int id, String name, String username, String password, String type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User tempUser;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = DBConnector.getInstance().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tempUser = new User();
                tempUser.setId(resultSet.getInt("id"));
                tempUser.setName(resultSet.getString("name"));
                tempUser.setUsername(resultSet.getString("username"));
                tempUser.setPassword(resultSet.getString("password"));
                tempUser.setType(resultSet.getString("type"));
                userList.add(tempUser);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return userList;
    }

    public static boolean add(String name, String username, String password, String type) {
        boolean isAdded = false;
        String query = "INSERT INTO user (name, username, password, type) VALUES (?, ?, ?, ?)";
        User tempUser = findByUsername(username);
        if (tempUser == null) {
            PreparedStatement statement = null;
            try {
                statement = DBConnector.getInstance().prepareStatement(query);
                statement.setString(1, name);
                statement.setString(2, username);
                statement.setString(3, password);
                statement.setString(4, type);
                if(statement.executeUpdate() != -1) {
                    isAdded = true;
                } else {
                    Helper.showMessage("error");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } else {
            Helper.showMessage("Bu kullanıcı adı zaten mecvut. Farklı bir kullanıcı adı belirleyiniz");
        }

        return isAdded;
    }

    public static boolean delete(int id) {
        boolean isDeleted = false;
        String query = "DELETE FROM user WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = DBConnector.getInstance().prepareStatement(query);
            statement.setInt(1, id);
            if (statement.executeUpdate() != -1) {
                isDeleted = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return isDeleted;
    }

    public static boolean update(int id, String name, String username, String password, String type) {
        boolean isUpdated = false;
        User tempUser = findByUsername(username);
        if (tempUser != null && tempUser.getId() != id ) {
            Helper.showMessage("Bu kullanıcı adı zaten mecvut. Farklı bir kullanıcı adı belirleyiniz");
        } else {
            List<String> userTypeList = getAllUserTypes();
            if (userTypeList.contains(type.trim().toLowerCase())){
                String query = "UPDATE user SET name = ?, username = ?, password = ?, type = ? WHERE id = ?";
                PreparedStatement statement = null;
                try {
                    statement = DBConnector.getInstance().prepareStatement(query);
                    statement.setString(1, name);
                    statement.setString(2, username);
                    statement.setString(3, password);
                    statement.setString(4, type.trim().toUpperCase());
                    statement.setInt(5, id);
                    if (statement.executeUpdate() != -1) {
                        isUpdated = true;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        statement.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            } else {
                Helper.showMessage("Lütfen mevcut üyelik tiplerinden birini giriniz");
            }
        }

        return isUpdated;
    }

    public static List<User> search(String query) {
        List<User> userList = new ArrayList<>();
        User tempUser;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = DBConnector.getInstance().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tempUser = new User();
                tempUser.setId(resultSet.getInt("id"));
                tempUser.setName(resultSet.getString("name"));
                tempUser.setUsername(resultSet.getString("username"));
                tempUser.setPassword(resultSet.getString("password"));
                tempUser.setType(resultSet.getString("type"));
                userList.add(tempUser);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return userList;
    }

    public static String createSearchQuery(String name, String username, String type) {
        String query = "SELECT * FROM user WHERE name LIKE '%{{name}}%' AND username LIKE '%{{username}}%'";
        query = query.replace("{{name}}", name);
        query = query.replace("{{username}}", username);
        if (!type.isEmpty()) {
            query += "AND type = '{{type}}'";
            query = query.replace("{{type}}", type);
        }
        return query;
    }

    public static User findByUsername(String username) {
        User user = null;
        String query = "SELECT * FROM user WHERE username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = DBConnector.getInstance().prepareStatement(query);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        
        return user;
    }

    public static List<String> getAllUserTypes() {
        List<String> userTypeList = new ArrayList<>();
        String query = "SELECT type FROM user GROUP BY type";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = DBConnector.getInstance().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                userTypeList.add(resultSet.getString(1).toLowerCase());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return userTypeList;
    }

    public Object[] getData() {
        Object[] data = {this.id, this.name, this.username, this.password, this.type};
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
