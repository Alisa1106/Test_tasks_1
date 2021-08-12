package new_years_gift.utils.readers;

import new_years_gift.model.sweets.Sweet;
import new_years_gift.model.sweets.Wafer;
import new_years_gift.utils.PropertyReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class TxtReader implements IRead {

    @Override
    public Sweet readSweetFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PropertyReader.getProperty("txt_to_read_file_path")))) {
            List<String> strings = reader.lines().collect(Collectors.toList());
            String name = strings.get(0);
            double price = Double.parseDouble(strings.get(1));
            int weight = Integer.parseInt(strings.get(2));
            int energyValue = Integer.parseInt(strings.get(3));
            String filling = strings.get(4);
            return new Wafer(name, price, weight, energyValue, filling);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}