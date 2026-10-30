import java.util.Scanner;

// Custom exception
class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {

    public static double calculate(double a, double b, char operator)
            throws DivideByZeroException {

        switch (operator) {
            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a * b;

            case '/':
                if (b == 0) {
                    throw new DivideByZeroException(
                            "Cannot divide by zero.");
                }
                return a / b;

            default:
                throw new IllegalArgumentException(
                        "Invalid operator.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean success = false;

        while (!success) {

            try {
                System.out.print("Enter first number: ");
                String input1 = sc.nextLine();

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = sc.nextLine().charAt(0);

                System.out.print("Enter second number: ");
                String input2 = sc.nextLine();

                double a = Double.parseDouble(input1);
                double b = Double.parseDouble(input2);

                double result = calculate(a, b, operator);

                System.out.println("Result = " + result);

                success = true;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid number! Please enter valid numbers.");

            } catch (DivideByZeroException e) {

                System.out.println(
                        "Calculation error: " + e.getMessage());

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: " + e.getMessage());

            } finally {

                System.out.println(
                        "Attempt logged.");
            }
        }

        sc.close();
        System.out.println("Calculation completed.");
    }
}