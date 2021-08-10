package new_years_gift.utils;

import new_years_gift.exceptions.NegativeValueException;

import java.util.Scanner;

public class SweetUtil {

    static Scanner scanner = new Scanner(System.in);

    public static int choosePricesDiapason() {
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

    public static int getMinimalPrice() throws NegativeValueException {
        System.out.print("Enter minimal price for filter: ");
        int minimalPrise = choosePricesDiapason();
        if (minimalPrise >= 0) {
            return minimalPrise;
        } else {
            throw new NegativeValueException("Price can't be negative!");
        }
    }

    public static int getMaximalPrice() throws NegativeValueException {
        System.out.print("Enter maximal price for filter: ");
        int maximalPrice = choosePricesDiapason();
        if (maximalPrice >= 0) {
            return maximalPrice;
        } else {
            throw new NegativeValueException("Price can't be negative!");
        }
    }
}