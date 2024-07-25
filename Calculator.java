import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Simple Calculator");
            System.out.println("Choose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            if (choice == 5) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                continue;
            }

            double num1 = 0, num2 = 0;
            try {
                System.out.print("Enter the first number: ");
                num1 = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter the second number: ");
                num2 = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
                continue;
            }

            double result = 0;
            boolean validOperation = true;

            switch (choice) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("The result is: " + result);
            }
        }

        scanner.close();
    }
}
