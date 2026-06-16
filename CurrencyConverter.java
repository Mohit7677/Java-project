File: CurrencyConverter.java

import java.util.*;

class Currency {

private String code;
private double rate;

public Currency(String code, double rate) {
    this.code = code.toUpperCase();
    this.rate = rate;
}

public String getCode() {
    return code;
}

public double getRate() {
    return rate;
}

}

class ConverterEngine {

private static ArrayList<String> history = new ArrayList<>();

public static double convert(double amount, Currency currency) {
    return amount * currency.getRate();
}

public static double convertToForeign(double inr, Currency currency) {
    return inr / currency.getRate();
}

public static void saveHistory(String record) {
    history.add(record);
}

public static void showHistory() {

    if (history.isEmpty()) {
        System.out.println("No conversion history.");
        return;
    }

    System.out.println("\n===== Conversion History =====");

    for (String s : history) {
        System.out.println(s);
    }
}

public static void showCurrencies() {

    System.out.println("\nSupported Currencies");
    System.out.println("-------------------------");
    System.out.println("USD → Rs.83");
    System.out.println("EUR → Rs.90");
    System.out.println("GBP → Rs.105");
}

public static Currency getCurrency(String code) {

    code = code.toUpperCase();

    switch (code) {

        case "USD":
            return new Currency("USD", 83);

        case "EUR":
            return new Currency("EUR", 90);

        case "GBP":
            return new Currency("GBP", 105);

        default:
            return null;
    }
}

}

public class CurrencyConverter {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int choice = -1;

    while (choice != 0) {

        try {

            System.out.println("\n==============================");
            System.out.println(" GLOBAL CURRENCY CONVERTER ");
            System.out.println("==============================");

            System.out.println("1. Show Supported Currencies");
            System.out.println("2. Convert Currency to INR");
            System.out.println("3. Convert INR to Currency");
            System.out.println("4. Convert Multiple Amounts");
            System.out.println("5. View History");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    ConverterEngine.showCurrencies();
                    break;

                case 2:

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    if (amount <= 0) {
                        System.out.println("Invalid amount.");
                        break;
                    }

                    System.out.print("Currency Code: ");
                    String code = sc.next();

                    Currency c =
                            ConverterEngine.getCurrency(code);

                    if (c == null) {
                        System.out.println("Invalid Currency");
                        break;
                    }

                    double result =
                            ConverterEngine.convert(amount, c);

                    String output =
                            amount + " " +
                            c.getCode() +
                            " = Rs." +
                            result;

                    System.out.println(output);

                    ConverterEngine.saveHistory(output);

                    break;

                case 3:

                    System.out.print("INR Amount: ");

                    double inr = sc.nextDouble();

                    System.out.print("Currency Code: ");

                    String target = sc.next();

                    Currency curr =
                            ConverterEngine.getCurrency(target);

                    if (curr == null) {
                        System.out.println("Invalid Currency");
                        break;
                    }

                    double foreign =
                            ConverterEngine.convertToForeign(
                                    inr,
                                    curr
                            );

                    String reverse =
                            "Rs." +
                            inr +
                            " = " +
                            foreign +
                            " " +
                            curr.getCode();

                    System.out.println(reverse);

                    ConverterEngine.saveHistory(reverse);

                    break;

                case 4:

                    System.out.print("Currency Code: ");

                    String multi = sc.next();

                    Currency multiCurr =
                            ConverterEngine.getCurrency(multi);

                    if (multiCurr == null) {
                        System.out.println("Invalid Currency");
                        break;
                    }

                    System.out.print("Number of amounts: ");

                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {

                        System.out.print(
                                "Amount " + i + ": "
                        );

                        double a = sc.nextDouble();

                        double r =
                                ConverterEngine.convert(
                                        a,
                                        multiCurr
                                );

                        String record =
                                a +
                                " " +
                                multi +
                                " = Rs." +
                                r;

                        System.out.println(record);

                        ConverterEngine.saveHistory(record);
                    }

                    break;

                case 5:

                    ConverterEngine.showHistory();
                    break;

                case 0:

                    System.out.println(
                            "Thank You"
                    );

                    break;

                default:

                    System.out.println(
                            "Enter valid choice"
                    );
            }

        } catch (Exception e) {

            System.out.println(
                    "Invalid Input"
            );

            sc.nextLine();
        }
    }

    sc.close();
}

}
