package new_years_gift.database;

import new_years_gift.model.sweets.Sweet;
import new_years_gift.model.sweets.Wafer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseService {

    DataBaseClient dataBaseClient;

    public DataBaseService(DataBaseClient dataBaseClient) {
        this.dataBaseClient = dataBaseClient;
    }

    public ResultSet select(String tableName) {
        try {
            return dataBaseClient.getStatement().executeQuery(String.format("select * from %s", tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Sweet getResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int weight = resultSet.getInt("weight");
                int energyValue = resultSet.getInt("energy_value");
                String filling = resultSet.getString("filling");
                return new Wafer(name, price, weight, energyValue, filling);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}