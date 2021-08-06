package calculator;

import java.util.Scanner;

public class Calculator {

    Scanner scanner = new Scanner(System.in);

    public double getNumber() {
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.print("You entered not number! Try again: ");
            scanner.next();
            number = getNumber();
        }
        return number;
    }

    public double getFirstNumber() {
        System.out.print("Enter first number: ");
        return getNumber();
    }

    public double getSecondNumber() {
        System.out.print("Enter second number: ");
        return getNumber();
    }

    public char getOperation() {
        System.out.print("Enter operation: addition - '+', subtraction - '-'" +
                ", multiplication - '*', division - '/': ");
        return scanner.next().charAt(0);
    }

    public void count() {
        switch (getOperation()) {
            case '+':
                System.out.println("Addition result: " + Operations.add(getFirstNumber(), getSecondNumber()));
                break;
            case '-':
                System.out.println("Subtraction result: " + Operations.subtract(getFirstNumber(), getSecondNumber()));
                break;
            case '*':
                System.out.println("Multiplication result: " + Operations.multiply(getFirstNumber(), getSecondNumber()));
                break;
            case '/':
                try {
                    System.out.println("Division result: " + Operations.divide(getFirstNumber(), getSecondNumber()));
                } catch (DivisionByZeroException e) {
                    System.out.println(e.getMessage());
                    count();
                }
                break;
            default:
                System.out.println("You entered incorrect operation! Try again: ");
                count();
                break;
        }
    }
}