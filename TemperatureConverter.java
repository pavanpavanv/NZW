import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Temperature Converter");
            System.out.println("Choose the source temperature scale:");
            System.out.println("1. Celsius (C)");
            System.out.println("2. Fahrenheit (F)");
            System.out.println("3. Kelvin (K)");
            System.out.println("4. Exit");

            int sourceChoice = 0;
            try {
                sourceChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }

            if (sourceChoice == 4) {
                System.out.println("Exiting the temperature converter. Goodbye!");
                break;
            }

            if (sourceChoice < 1 || sourceChoice > 4) {
                System.out.println("Invalid choice. Please choose a number between 1 and 4.");
                continue;
            }

            System.out.println("Choose the target temperature scale:");
            System.out.println("1. Celsius (C)");
            System.out.println("2. Fahrenheit (F)");
            System.out.println("3. Kelvin (K)");

            int targetChoice = 0;
            try {
                targetChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                continue;
            }

            if (targetChoice < 1 || targetChoice > 3) {
                System.out.println("Invalid choice. Please choose a number between 1 and 3.");
                continue;
            }

            double temperature = 0;
            try {
                System.out.print("Enter the temperature to convert: ");
                temperature = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid temperature value.");
                continue;
            }

            double convertedTemperature = 0;
            boolean validConversion = true;

            switch (sourceChoice) {
                case 1: // Celsius
                    convertedTemperature = convertFromCelsius(temperature, targetChoice);
                    break;
                case 2: // Fahrenheit
                    convertedTemperature = convertFromFahrenheit(temperature, targetChoice);
                    break;
                case 3: // Kelvin
                    convertedTemperature = convertFromKelvin(temperature, targetChoice);
                    break;
                default:
                    validConversion = false;
                    break;
            }

            if (validConversion) {
                String sourceScale = getScaleName(sourceChoice);
                String targetScale = getScaleName(targetChoice);
                System.out.printf("The converted temperature is: %.2f %s%n", convertedTemperature, targetScale);
            }
        }

        scanner.close();
    }

    private static double convertFromCelsius(double temperature, int targetChoice) {
        switch (targetChoice) {
            case 1: // to Celsius
                return temperature;
            case 2: // to Fahrenheit
                return (temperature * 9/5) + 32;
            case 3: // to Kelvin
                return temperature + 273.15;
            default:
                return Double.NaN;
        }
    }

    private static double convertFromFahrenheit(double temperature, int targetChoice) {
        switch (targetChoice) {
            case 1: // to Celsius
                return (temperature - 32) * 5/9;
            case 2: // to Fahrenheit
                return temperature;
            case 3: // to Kelvin
                return (temperature - 32) * 5/9 + 273.15;
            default:
                return Double.NaN;
        }
    }

    private static double convertFromKelvin(double temperature, int targetChoice) {
        switch (targetChoice) {
            case 1: // to Celsius
                return temperature - 273.15;
            case 2: // to Fahrenheit
                return (temperature - 273.15) * 9/5 + 32;
            case 3: // to Kelvin
                return temperature;
            default:
                return Double.NaN;
        }
    }

    private static String getScaleName(int choice) {
        switch (choice) {
            case 1:
                return "Celsius";
            case 2:
                return "Fahrenheit";
            case 3:
                return "Kelvin";
            default:
                return "";
        }
    }
}
