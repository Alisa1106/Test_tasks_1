package new_years_gift.database;

import lombok.Getter;
import new_years_gift.utils.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Getter
public class DataBaseClient {

    private Connection connect = null;
    private Statement statement = null;

    public void connect() {
        try {
            connect = DriverManager.getConnection(PropertyReader.getProperty("url"));
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }
}