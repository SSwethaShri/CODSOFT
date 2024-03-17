/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package currencyconverter;

/**
 *
 * @author sswet
 */



import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Step 1: Currency Selection
        try (Scanner scanner = new Scanner(System.in)) {
            // Step 1: Currency Selection
            System.out.println("Select base currency (e.g., USD, EUR, GBP):");
            String baseCurrency = scanner.nextLine().toUpperCase();
            
            System.out.println("Select target currency (e.g., USD, EUR, GBP):");
            String targetCurrency = scanner.nextLine().toUpperCase();
            
            // Step 2: Currency Rates
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            
            // Step 3: Amount Input
            System.out.println("Enter the amount to convert:");
            double amount = scanner.nextDouble();
            
            // Step 4: Currency Conversion
            double convertedAmount = amount * exchangeRate;
            
            // Step 5: Display Result
            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        }
    }

    // Method to fetch exchange rates from an API
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");
            return rates.getDouble(targetCurrency);
        } catch (IOException e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
            return 0.0;
        }
    }
}
