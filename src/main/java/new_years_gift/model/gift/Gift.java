package new_years_gift.model.gift;

import lombok.Getter;
import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.exceptions.NegativeValueException;
import new_years_gift.model.constants.SortingType;
import new_years_gift.model.sweets.Sweet;
import new_years_gift.utils.HelperClass;
import new_years_gift.utils.SweetUtil;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Gift implements IGift {

    private List<Sweet> sweets;

    public Gift() {
        this.sweets = new ArrayList<>();
    }

    public Gift(Sweet... sweets) {
        this.sweets = Arrays.asList(sweets);
    }

    public void addCandy(Sweet sweet) {
        sweets.add(sweet);
    }

    public void addCandies(Sweet... sweets) {
        this.sweets.addAll(Arrays.asList(sweets));
    }

    @Override
    public int getTotalWeight() {
        int totalWeight = 0;
        for (Sweet sweet : sweets) {
            totalWeight += sweet.weigh();
        }
        return totalWeight;
    }

    @Override
    public List<Sweet> sortByPrice() throws EmptyCollectionException {
        HelperClass.throwExceptionIfEmpty(sweets);
        return sweets.stream().sorted(Comparator.comparing(Sweet::getPrice)).collect(Collectors.toList());
    }

    @Override
    public List<Sweet> sortByWeight() throws EmptyCollectionException {
        HelperClass.throwExceptionIfEmpty(sweets);
        return sweets.stream().sorted(Comparator.comparing(Sweet::getWeight)).collect(Collectors.toList());
    }

    @Override
    public List<Sweet> sortByEnergyValue() throws EmptyCollectionException {
        HelperClass.throwExceptionIfEmpty(sweets);
        return sweets.stream().sorted(Comparator.comparing(Sweet::getEnergyValue)).collect(Collectors.toList());
    }

    @Override
    public List<Sweet> getChosenPriceSweetsList(int startPrice, int finishPrice) throws EmptyCollectionException {
        HelperClass.throwExceptionIfEmpty(sweets);
        return sweets.stream().filter(s -> s.getPrice() > startPrice).filter(s -> s.getPrice() < finishPrice).collect(Collectors.toList());
    }

    public List<Sweet> sort(SortingType sortingType) {
        try {
            switch (sortingType) {
                case WEIGHT:
                    return sortByWeight();
                case PRICE:
                    return sortByPrice();
                case ENERGY_VALUE:
                    return sortByEnergyValue();
                default:
                    throw new NoSuchElementException("No such sorting type!");
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Sweet> filterByPrice() {
        try {
            return getChosenPriceSweetsList(SweetUtil.getMinimalPrice(), SweetUtil.getMaximalPrice());
        } catch (NegativeValueException | EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}