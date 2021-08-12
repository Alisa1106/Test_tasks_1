package new_years_gift.utils.readers;

import com.google.gson.Gson;
import lombok.Data;
import new_years_gift.model.sweets.ChocolateBar;
import new_years_gift.model.sweets.Sweet;
import new_years_gift.utils.PropertyReader;

import java.io.FileReader;
import java.io.IOException;

@Data
public class JsonReader implements IRead {

    @Override
    public Sweet readSweetFromFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(PropertyReader.getProperty("json_to_read_file_path"))) {
            return gson.fromJson(reader, ChocolateBar.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}