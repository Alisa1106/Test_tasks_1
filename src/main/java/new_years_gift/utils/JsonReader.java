package new_years_gift.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import new_years_gift.model.sweets.ChocolateBar;
import new_years_gift.model.sweets.Sweet;

import java.io.FileReader;
import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
@Data
public class JsonReader extends BaseReader {

    private String name = "";
    private double price = 0;
    private int weight = 0;
    @SerializedName("energy_value")
    private int energyValue = 0;
    private String additive = "";
    private String glaze = "";
    ChocolateBar sweet = new ChocolateBar(name, price, weight, energyValue, additive, glaze);

    @Override
    public Sweet readSweetFromFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/main/resources/add_sweets.json")) {
            sweet = gson.fromJson(reader, ChocolateBar.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sweet;
    }
}