package hw9_PatikaClone.com.patikadev.Model;

import hw9_PatikaClone.com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Patika {

    private int id;
    private String name;

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Patika> getList() {
        List<Patika> patikaList = new ArrayList<>();
        Patika patika;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = DBConnector.getInstance().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM patika");
            while (resultSet.next()) {
                patika = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
                patikaList.add(patika);
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

        return patikaList;
    }

    public static boolean add(String name) {
        boolean isAdded = false;
        String query = "INSERT INTO patika (name) VALUES (?)";
        PreparedStatement statement = null;
        try {
            statement = DBConnector.getInstance().prepareStatement(query);
            statement.setString(1, name);
            if (statement.executeUpdate() != -1){
                isAdded = true;
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

        return isAdded;
    }

    public static boolean delete(int id) {
        boolean isDeleted = false;
        String query = "DELETE FROM patika WHERE id = ?";
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

    public static boolean update(int id, String name) {
        boolean isUpdated = false;
        String query = "UPDATE patika SET name = ? WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = DBConnector.getInstance().prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, id);
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

        return isUpdated;
    }

    public static Patika findById(int id) {
        Patika patika = null;
        String query = "SELECT * FROM patika WHERE id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = DBConnector.getInstance().prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                patika = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
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

        return patika;
    }

    public Object[] getData() {
        Object[] data = {this.id, this.name};
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
}
