package new_years_gift.utils;

import com.google.gson.Gson;
import new_years_gift.model.gift.Gift;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter extends BaseWriter {

    @Override
    public void writeSweetsToFile(Gift gift) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("src/main/resources/save_sweets.json")) {
            gson.toJson(gift, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
