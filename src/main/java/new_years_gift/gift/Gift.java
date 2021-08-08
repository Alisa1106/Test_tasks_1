package new_years_gift.gift;

import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.operations.File;
import new_years_gift.sweets.ChocolateCandy;
import new_years_gift.sweets.Lollipop;
import new_years_gift.sweets.Sweet;
import new_years_gift.sweets.Wafer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Gift implements IGift {

    File file = new File();

    @Override
    public List<Sweet> createGift() {
        List<Sweet> gift = new ArrayList<>();
        gift.add(new ChocolateCandy("Azorika", 15.99, 300, 335, "Cream"));
        gift.add(new ChocolateCandy("Bellissimo", 14.00, 220, 340, "Creme-brulee"));
        gift.add(new ChocolateCandy("Nuts", 18.00, 100, 460, "Nut"));
        gift.add(new Lollipop("Chupa-chups", 12.50, 150, 280, "Strawberry"));
        gift.add(new Lollipop("Mint", 9.99, 200, 269, "Mint"));
        gift.add(new Wafer("Roshen", 12.99, 250, 335, "Chocolate"));
        gift.add(file.readSweetFromFile());
        return gift;
    }

    @Override
    public int getTotalWeight(List<Sweet> gift) {
        int totalWeight = 0;
        for (Sweet sweet : gift) {
            totalWeight += sweet.getWeight();
        }
        return totalWeight;
    }

    @Override
    public List<Sweet> sortByPrice(List<Sweet> gift) throws EmptyCollectionException {
        if (!gift.isEmpty()) {
            return gift.stream().sorted(Comparator.comparing(Sweet::getPrice)).collect(Collectors.toList());
        } else {
            throw new EmptyCollectionException("Gift list is empty!");
        }
    }

    @Override
    public List<Sweet> sortByWeight(List<Sweet> gift) throws EmptyCollectionException {
        if (!gift.isEmpty()) {
            return gift.stream().sorted(Comparator.comparing(Sweet::getWeight)).collect(Collectors.toList());
        } else {
            throw new EmptyCollectionException("Gift list is empty!");
        }
    }

    @Override
    public List<Sweet> sortByEnergyValue(List<Sweet> gift) throws EmptyCollectionException {
        if (!gift.isEmpty()) {
            return gift.stream().sorted(Comparator.comparing(Sweet::getEnergyValue)).collect(Collectors.toList());
        } else {
            throw new EmptyCollectionException("Gift list is empty!");
        }
    }

    @Override
    public List<Sweet> getChosenPriceSweetsList(List<Sweet> gift, int startPrice, int finishPrice) throws EmptyCollectionException {
        if (!gift.isEmpty()) {
            return gift.stream().filter(s -> s.getPrice() > startPrice).filter(s -> s.getPrice() < finishPrice).collect(Collectors.toList());
        } else {
            throw new EmptyCollectionException("There aren't elements with such parameters!");
        }
    }
}