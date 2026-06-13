import java.util.Scanner;

class ConverterEngine {

    public static final double USD_TO_INR = 83.0;
    public static final double EUR_TO_INR = 90.0;
    public static final double GBP_TO_INR = 105.0;

    public static double convert(int amount, String currencyType) {
        return convert((double) amount, currencyType);
    }

    public static double convert(double amount, String currencyType) {
       
        String currency = currencyType.toUpperCase();

        if (currency.equals("USD")) {
            return amount * USD_TO_INR;
        } else if (currency.equals("EUR")) {
            return amount * EUR_TO_INR;
        } else if (currency.equals("GBP")) {
            return amount * GBP_TO_INR;
        } else {
           
            return 0;
        }
    }

    public static void showSupportedCurrencies() {
        System.out.println("\n  Supported Currencies:");
        System.out.println("  +--------------+------+------------------+");
        System.out.println("  | Currency     | Code | Rate (per unit)  |");
        System.out.println("  +--------------+------+------------------+");
        System.out.println("  | US Dollar    | USD  | Rs. 83.00        |");
        System.out.println("  | Euro         | EUR  | Rs. 90.00        |");
        System.out.println("  | British Pound| GBP  | Rs. 105.00       |");
        System.out.println("  +--------------+------+------------------+");
    }
}

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
        
            System.out.println("\n======================================");
            System.out.println("     GLOBAL CURRENCY CONVERTER        ");
            System.out.println("======================================");
            System.out.println("--- MENU ---");
            System.out.println("1. Show Supported Currencies");
            System.out.println("2. Convert Currency to INR");
            System.out.println("3. Convert Multiple Amounts (same currency)");
            System.out.println("0. Exit");
            System.out.println("--------------------------------------");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                
                    ConverterEngine.showSupportedCurrencies();
                    break;

                case 2:
                    System.out.println("\n-- Currency Conversion --");
                    ConverterEngine.showSupportedCurrencies();

                    System.out.print("\nEnter Amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Enter Currency Code (USD / EUR / GBP): ");
                    String currency = sc.next();

                   
                    double result = ConverterEngine.convert(amount, currency);

                    if (result == 0) {
                        System.out.println("ERROR: Invalid currency type! Supported: USD, EUR, GBP");
                    } else {
                        System.out.println("\n--------------------------------------");
                        System.out.println("  Amount        : " + amount + " " + currency.toUpperCase());
                        System.out.println("  Converted INR : Rs. " + result);
                        System.out.println("--------------------------------------");
                    }
                    break;

                case 3:
                
                    System.out.println("\n-- Convert Multiple Amounts --");
                    System.out.print("Enter Currency Code (USD / EUR / GBP): ");
                    String curr = sc.next();

                    System.out.print("How many amounts to convert? ");
                    int n = sc.nextInt();

                    System.out.println("\n--------------------------------------");
                    int i = 1;
                    while (i <= n) {
                        System.out.print("  Enter Amount " + i + ": ");
                        double amt = sc.nextDouble();
                        double res = ConverterEngine.convert(amt, curr);

                        if (res == 0) {
                            System.out.println("  ERROR: Invalid currency! Supported: USD, EUR, GBP");
                            break;
                        } else {
                            System.out.println("  " + amt + " " + curr.toUpperCase() + " = Rs. " + res);
                        }
                        i++;
                    }
                    System.out.println("--------------------------------------");
                    break;

                case 0:
                    System.out.println("\nThank you for using Currency Converter!");
                    System.out.println("-- Mohit Kumar | ERP: 10837 --");
                    break;

                default:
                    System.out.println("ERROR: Invalid choice! Please enter 0-3.");
            }

        } while (choice != 0);

        sc.close();
    }
}
