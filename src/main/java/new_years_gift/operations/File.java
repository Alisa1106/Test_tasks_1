package new_years_gift.operations;

import new_years_gift.sweets.ChocolateCandy;
import new_years_gift.sweets.Lollipop;
import new_years_gift.sweets.Sweet;
import new_years_gift.sweets.Wafer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

public class File {

    private String name = "";
    private double price = 0;
    private int weight = 0;
    private int energyValue = 0;
    private String filling = "";
    Wafer sweet = new Wafer(name, price, weight, energyValue, filling);

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

    public void writeSweetsToFile(List<Sweet> gift) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/save_sweets"))) {
            for (Sweet sweet : gift) {
                writer.write(sweet.getName() + "\n");
                writer.write(sweet.getPrice() + "\n");
                writer.write(sweet.getWeight() + "\n");
                writer.write(sweet.getEnergyValue() + "\n");
                if (sweet instanceof Wafer) {
                    writer.write(((Wafer) sweet).getFilling() + "\n");
                } else if (sweet instanceof ChocolateCandy) {
                    writer.write(((ChocolateCandy) sweet).getAdditive() + "\n");
                } else if (sweet instanceof Lollipop) {
                    writer.write(((Lollipop) sweet).getTaste() + "\n");
                }
                writer.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}