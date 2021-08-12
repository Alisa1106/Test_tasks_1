package new_years_gift;

import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.model.constants.SortingType;
import new_years_gift.model.gift.Gift;
import new_years_gift.utils.Printer;
import new_years_gift.utils.Santa;

public class Runner {
    public static void main(String[] args) throws EmptyCollectionException {
        Gift gift = new Gift();
        Santa santa = new Santa();
        santa.read();
        santa.packGift(gift);
        santa.write(gift);
        Printer.printTotalWeight(gift);
        gift.sort(SortingType.ENERGY_VALUE);
        Printer.printList(gift.filterByPrice());
        Printer.printList(gift.sortByPrice());
    }
}