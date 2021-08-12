package new_years_gift.model.gift;

import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.model.sweets.Sweet;

import java.util.List;

public interface IGift {

    int getTotalWeight();

    List<Sweet> sortByPrice() throws EmptyCollectionException;

    List<Sweet> sortByWeight() throws EmptyCollectionException;

    List<Sweet> sortByEnergyValue() throws EmptyCollectionException;

    List<Sweet> getChosenPriceSweetsList(int startPrice, int finishPrice) throws EmptyCollectionException;
}