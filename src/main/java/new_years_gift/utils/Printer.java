package new_years_gift.utils;

import new_years_gift.model.gift.Gift;
import new_years_gift.model.sweets.Sweet;

import java.util.List;

public class Printer {
    public static void printTotalWeight(Gift gift) {
        System.out.println(gift.getTotalWeight());
    }

    public static void printList(List<Sweet> sweetList) {
        System.out.println(sweetList);
    }
}