package new_years_gift.operations;

import new_years_gift.gift.Gift;

public class Main {

    public static void main(String[] args) {

        Operations operations = new Operations();
        Gift gift = new Gift();
        File file = new File();

        operations.createGift();
        operations.printTotalWeight();
        operations.sort(SortingType.ENERGY_VALUE);
        operations.filterByPrice();
        file.writeSweetsToFile(gift);
    }
}