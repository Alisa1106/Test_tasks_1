package new_years_gift.utils;

import new_years_gift.model.sweets.Sweet;
import new_years_gift.model.sweets.Wafer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class TxtReader extends BaseReader {
    private String name = "";
    private double price = 0;
    private int weight = 0;
    private int energyValue = 0;
    private String filling = "";
    Wafer sweet = new Wafer(name, price, weight, energyValue, filling);

    @Override
    public Sweet readSweetFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/add_sweets"))) {
            List<String> strings = reader.lines().collect(Collectors.toList());
            sweet.setName(strings.get(0));
            sweet.setPrice(Double.parseDouble(strings.get(1)));
            sweet.setWeight(Integer.parseInt(strings.get(2)));
            sweet.setEnergyValue(Integer.parseInt(strings.get(3)));
            sweet.setFilling(strings.get(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sweet;
    }
}