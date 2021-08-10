package new_years_gift.database;

import new_years_gift.model.sweets.Sweet;
import new_years_gift.model.sweets.Wafer;
import new_years_gift.utils.PropertyReader;

import java.sql.*;

public class DataBaseConnection {

    private Connection connect = null;
    private Statement statement = null;
    private String name = "";
    private double price = 0;
    private int weight = 0;
    private int energyValue = 0;
    private String filling = "";
    Wafer sweet = new Wafer(name, price, weight, energyValue, filling);

    public void connect() {
        try {
            connect = DriverManager.getConnection(PropertyReader.getProperty("url"));
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet select(String tableName) {
        try {
            return statement.executeQuery(String.format("select * from %s", tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Sweet getResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                sweet.setName(resultSet.getString("name"));
                sweet.setPrice(resultSet.getDouble("price"));
                sweet.setWeight(resultSet.getInt("weight"));
                sweet.setEnergyValue(resultSet.getInt("energy_value"));
                sweet.setFilling(resultSet.getString("filling"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sweet;
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
