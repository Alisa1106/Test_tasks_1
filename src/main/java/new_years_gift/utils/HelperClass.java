package new_years_gift.utils;

import new_years_gift.database.DataBaseClient;
import new_years_gift.database.DataBaseService;
import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.model.sweets.Sweet;

import java.sql.ResultSet;
import java.util.List;

public class HelperClass {

    public static Sweet getSweetFromDataBase() {
        DataBaseClient dataBaseClient = new DataBaseClient();
        dataBaseClient.connect();
        DataBaseService dataBaseService = new DataBaseService(dataBaseClient);
        ResultSet resultSet = dataBaseService.select("wafer");
        Sweet sweet = dataBaseService.getResultSet(resultSet);
        dataBaseClient.close();
        return sweet;
    }

    public static void throwExceptionIfEmpty(List<?> sweets) throws EmptyCollectionException {
        if (sweets.isEmpty()) {
            throw new EmptyCollectionException("Gift list is empty!");
        }
    }
}