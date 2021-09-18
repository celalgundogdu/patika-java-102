package hw9_PatikaClone.com.patikadev.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private Connection connection;

    public Connection connectToDB() {
        try {
            this.connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return this.connection;
    }

    public static Connection getInstance() {
        DBConnector dbConnector = new DBConnector();
        return dbConnector.connectToDB();
    }

}
