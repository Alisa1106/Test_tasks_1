package new_years_gift.gift;

import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.sweets.Sweet;

import java.util.List;

public interface IGift {

    List<Sweet> createGift();

    int getTotalWeight(List<Sweet> gift);

    List<Sweet> sortByPrice(List<Sweet> gift) throws EmptyCollectionException;

    List<Sweet> sortByWeight(List<Sweet> gift) throws EmptyCollectionException;

    List<Sweet> sortByEnergyValue(List<Sweet> gift) throws EmptyCollectionException;

    List<Sweet> getChosenPriceSweetsList(List<Sweet> gift, int startPrice, int finishPrice) throws EmptyCollectionException;
}