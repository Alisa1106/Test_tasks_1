package new_years_gift.utils.writers;

import com.google.gson.Gson;
import new_years_gift.model.gift.Gift;
import new_years_gift.utils.PropertyReader;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter implements IWrite {

    @Override
    public void writeSweetsToFile(Gift gift) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(PropertyReader.getProperty("json_to_write_file_path"))) {
            gson.toJson(gift, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}