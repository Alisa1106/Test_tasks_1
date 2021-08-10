package new_years_gift;

import new_years_gift.model.constants.SortingType;
import new_years_gift.model.gift.Gift;
import new_years_gift.utils.JsonWriter;
import new_years_gift.utils.TxtWriter;

public class Runner {

    public static void main(String[] args) {

        Gift gift = new Gift();

        gift.createGift();
        gift.printTotalWeight();
        gift.sort(SortingType.ENERGY_VALUE);
        gift.filterByPrice();
        new JsonWriter().writeSweetsToFile(gift);
        new TxtWriter().writeSweetsToFile(gift);
    }
}