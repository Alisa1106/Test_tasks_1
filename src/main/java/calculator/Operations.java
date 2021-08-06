package calculator;

public class Operations {

    public static double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double divide(double firstNumber, double secondNumber) throws DivisionByZeroException {
        if (secondNumber != 0) {
            return firstNumber / secondNumber;
        } else {
            throw new DivisionByZeroException("You can't divide by zero! Try again: ");
        }
    }
}