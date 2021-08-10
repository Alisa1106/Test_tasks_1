package new_years_gift.utils;

import new_years_gift.model.gift.Gift;
import new_years_gift.model.sweets.*;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TxtWriter extends BaseWriter {

    @Override
    public void writeSweetsToFile(Gift gift) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/save_sweets"))) {
            for (Sweet sweet : gift.getSweets()) {
                writer.write(sweet.getName() + "\n");
                writer.write(sweet.getPrice() + "\n");
                writer.write(sweet.getWeight() + "\n");
                writer.write(sweet.getEnergyValue() + "\n");
                if (sweet instanceof Wafer) {
                    writer.write(((Wafer) sweet).getFilling() + "\n");
                    if (sweet instanceof VienneseWafer) {
                        writer.write(((VienneseWafer) sweet).getTypeOfDough() + "\n");
                    }
                } else if (sweet instanceof ChocolateCandy) {
                    writer.write(((ChocolateCandy) sweet).getAdditive() + "\n");
                    if (sweet instanceof ChocolateBar) {
                        writer.write(((ChocolateBar) sweet).getGlaze() + "\n");
                    }
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