package new_years_gift.operations;

import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.exceptions.NegativeValueException;
import new_years_gift.gift.Gift;
import new_years_gift.utils.SweetUtils;

public class Operations {

    Gift gift = new Gift();

    public void createGift() {
        gift.createGift();
    }

    public void sort(SortingType sortingType) {
        try {
            switch (sortingType) {
                case WEIGHT:
                    System.out.println(gift.sortByWeight());
                    break;
                case PRICE:
                    System.out.println(gift.sortByPrice());
                    break;
                case ENERGY_VALUE:
                    System.out.println(gift.sortByEnergyValue());
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void filterByPrice() {
        try {
            System.out.println(gift.getChosenPriceSweetsList(SweetUtils.getMinimalPrice(), SweetUtils.getMaximalPrice()));
        } catch (NegativeValueException | EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printTotalWeight() {
        System.out.println(gift.getTotalWeight());
    }
}