package new_years_gift.model.gift;

import lombok.Getter;
import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.exceptions.NegativeValueException;
import new_years_gift.model.sweets.*;
import new_years_gift.database.DataBaseConnection;
import new_years_gift.utils.*;
import new_years_gift.model.constants.SortingType;

import java.sql.ResultSet;
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

    @Override
    public List<Sweet> createGift() {
        sweets.add(new ChocolateCandy("Azorika", 15.99, 300, 335, "Cream"));
        sweets.add(new ChocolateCandy("Bellissimo", 14.00, 220, 340, "Creme-brulee"));
        sweets.add(new ChocolateCandy("Nuts", 18.00, 100, 460, "Nut"));
        sweets.add(new Lollipop("Chupa-chups", 12.50, 150, 280, "Strawberry"));
        sweets.add(new Lollipop("Mint", 9.99, 200, 269, "Mint"));
        sweets.add(new Wafer("Roshen", 12.99, 250, 335, "Chocolate"));
        sweets.add(new ChocolateBar("Snickers", 20.50, 140, 551, "Hazelnut", "Dark chocolate"));
        sweets.add(new JsonReader().readSweetFromFile());
        sweets.add(new TxtReader().readSweetFromFile());
        sweets.add(getSweetFromDataBase());
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

    public void addCandy(Sweet sweet) {
        sweets.add(sweet);
    }

    public Sweet getSweetFromDataBase() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connect();
        ResultSet resultSet = dataBaseConnection.select("wafer");
        Sweet sweet = dataBaseConnection.getResultSet(resultSet);
        dataBaseConnection.close();
        return sweet;
    }

    public void throwExceptionIfEmpty() throws EmptyCollectionException {
        if (sweets.isEmpty()) {
            throw new EmptyCollectionException("Gift list is empty!");
        }
    }

    public void sort(SortingType sortingType) {
        try {
            switch (sortingType) {
                case WEIGHT:
                    System.out.println(sortByWeight());
                    break;
                case PRICE:
                    System.out.println(sortByPrice());
                    break;
                case ENERGY_VALUE:
                    System.out.println(sortByEnergyValue());
                    break;
                default:
                    throw new NoSuchElementException("No such sorting type!");
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void filterByPrice() {
        try {
            System.out.println(getChosenPriceSweetsList(SweetUtil.getMinimalPrice(), SweetUtil.getMaximalPrice()));
        } catch (NegativeValueException | EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printTotalWeight() {
        System.out.println(getTotalWeight());
    }
}