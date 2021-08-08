package new_years_gift.operations;

import new_years_gift.exceptions.NegativeValueException;
import new_years_gift.exceptions.EmptyCollectionException;
import new_years_gift.gift.Gift;

import java.util.Scanner;

public class Operations {

    Gift gift = new Gift();
    Scanner scanner = new Scanner(System.in);

    public int chooseSortType() {
        int choice;
        System.out.print("Choose type of sorting: 1 - by weight, 2 - by price, 3 - by energy value: ");
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.print("You entered not number! Try again: ");
            scanner.next();
            choice = chooseSortType();
        }
        while (choice < 1 || choice > 3) {
            System.out.print("You entered incorrect number! Try again: ");
            choice = scanner.nextInt();
        }
        return choice;
    }

    public void sort() {
        switch (chooseSortType()) {
            case 1:
                try {
                    System.out.println(gift.sortByWeight(gift.createGift()));
                } catch (EmptyCollectionException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    System.out.println(gift.sortByPrice(gift.createGift()));
                } catch (EmptyCollectionException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try {
                    System.out.println(gift.sortByEnergyValue(gift.createGift()));
                } catch (EmptyCollectionException e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    public int choosePricesDiapason() {
        int price;
        if (scanner.hasNextDouble()) {
            price = scanner.nextInt();
        } else {
            System.out.print("You entered not number! Try again: ");
            scanner.next();
            price = choosePricesDiapason();
        }
        return price;
    }

    public int getMinimalPrice() throws NegativeValueException {
        System.out.print("Enter minimal price for filter: ");
        int minimalPrise = choosePricesDiapason();
        if (minimalPrise >= 0) {
            return minimalPrise;
        } else {
            throw new NegativeValueException("Price can't be negative!");
        }
    }

    public int getMaximalPrice() throws NegativeValueException {
        System.out.print("Enter maximal price for filter: ");
        int maximalPrice = choosePricesDiapason();
        if (maximalPrice >= 0) {
            return maximalPrice;
        } else {
            throw new NegativeValueException("Price can't be negative!");
        }
    }

    public void filterByPrice() {
        try {
            System.out.println(gift.getChosenPriceSweetsList(gift.createGift(), getMinimalPrice(), getMaximalPrice()));
        } catch (NegativeValueException | EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
    }
}