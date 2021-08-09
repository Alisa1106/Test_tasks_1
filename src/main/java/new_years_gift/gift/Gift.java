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

    List<Sweet> sweets;
    File file = new File();

    public Gift() {
        this.sweets = new ArrayList<>();
    }

    @Override
    public List<Sweet> createGift() {
        sweets.add(new ChocolateCandy("Azorika", 15.99, 300, 335, "Cream"));
        sweets.add(new ChocolateCandy("Bellissimo", 14.00, 220, 340, "Creme-brulee"));
        sweets.add(new ChocolateCandy("Nuts", 18.00, 100, 460, "Nut"));
        sweets.add(new Lollipop("Chupa-chups", 12.50, 150, 280, "Strawberry"));
        sweets.add(new Lollipop("Mint", 9.99, 200, 269, "Mint"));
        sweets.add(new Wafer("Roshen", 12.99, 250, 335, "Chocolate"));
        sweets.add(file.readSweetFromFile());
        return sweets;
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
        throwExceptionIfEmpty();
        return sweets.stream().sorted(Comparator.comparing(Sweet::getPrice)).collect(Collectors.toList());
    }

    @Override
    public List<Sweet> sortByWeight() throws EmptyCollectionException {
        throwExceptionIfEmpty();
        return sweets.stream().sorted(Comparator.comparing(Sweet::getWeight)).collect(Collectors.toList());
    }

    @Override
    public List<Sweet> sortByEnergyValue() throws EmptyCollectionException {
        throwExceptionIfEmpty();
        return sweets.stream().sorted(Comparator.comparing(Sweet::getEnergyValue)).collect(Collectors.toList());
    }

    @Override
    public List<Sweet> getChosenPriceSweetsList(int startPrice, int finishPrice) throws EmptyCollectionException {
        throwExceptionIfEmpty();
        return sweets.stream().filter(s -> s.getPrice() > startPrice).filter(s -> s.getPrice() < finishPrice).collect(Collectors.toList());
    }

    public void throwExceptionIfEmpty() throws EmptyCollectionException {
        if (sweets.isEmpty()) {
            throw new EmptyCollectionException("Gift list is empty!");
        }
    }
}