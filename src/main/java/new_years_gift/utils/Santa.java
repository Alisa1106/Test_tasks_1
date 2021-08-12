package new_years_gift.utils;

import new_years_gift.model.gift.Gift;
import new_years_gift.model.sweets.*;
import new_years_gift.utils.readers.IRead;
import new_years_gift.utils.readers.JsonReader;
import new_years_gift.utils.readers.TxtReader;
import new_years_gift.utils.writers.IWrite;
import new_years_gift.utils.writers.JsonWriter;
import new_years_gift.utils.writers.TxtWriter;

import java.util.ArrayList;
import java.util.List;

public class Santa {

    public Sweet assembleGift(IRead iRead) {
        return iRead.readSweetFromFile();
    }

    public void read() {
        List<IRead> readers = new ArrayList<>();
        readers.add(new JsonReader());
        readers.add(new TxtReader());
        for (IRead read : readers) {
            assembleGift(read);
        }
    }

    public void packGift(Gift gift) {
        gift.addCandies(
                new ChocolateCandy("Azorika", 15.99, 300, 335, "Cream"),
                new ChocolateCandy("Bellissimo", 14.00, 220, 340, "Creme-brulee"),
                new ChocolateCandy("Nuts", 18.00, 100, 460, "Nut"),
                new Lollipop("Chupa-chups", 12.50, 150, 280, "Strawberry"),
                new Lollipop("Mint", 9.99, 200, 269, "Mint"),
                new Wafer("Roshen", 12.99, 250, 335, "Chocolate"),
                new ChocolateBar("Snickers", 20.50, 140, 551, "Hazelnut", "Dark chocolate"),
                new JsonReader().readSweetFromFile(),
                new TxtReader().readSweetFromFile(),
                HelperClass.getSweetFromDataBase()
        );
    }

    public void sendGift(IWrite iWrite, Gift gift) {
        iWrite.writeSweetsToFile(gift);
    }

    public void write(Gift gift) {
        List<IWrite> writes = new ArrayList<>();
        writes.add(new JsonWriter());
        writes.add(new TxtWriter());
        for (IWrite write : writes) {
            sendGift(write, gift);
        }
    }
}