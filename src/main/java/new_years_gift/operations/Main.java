package new_years_gift.operations;

import new_years_gift.gift.Gift;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Gift gift = new Gift();
        File file = new File();

        System.out.println(gift.getTotalWeight(gift.createGift()));
        operations.sort();
        operations.filterByPrice();
        file.writeSweetsToFile(gift.createGift());
    }
}