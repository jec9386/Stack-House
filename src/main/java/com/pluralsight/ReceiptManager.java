

package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    // Simple method to save a receipt to a file
    public static String saveReceipt(Order order) {
        try {
            // Create a unique filename using date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String timestamp = now.format(formatter);
            String filename ="receipts/receipt_"+ timestamp + ".txt";

            // Create the receipt content
            String receiptContent = createReceiptContent(order);

            // Write to file
            FileWriter writer = new FileWriter(filename);
            writer.write(receiptContent);
            writer.close();


            System.out.println("Receipt saved as: " + filename);
            return filename;

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
            return null;
        }
    }


    // Create the receipt content as a string
    private static String createReceiptContent(Order order) {
        StringBuilder receipt = new StringBuilder();

        // Header
        receipt.append("=====================================\n");
        receipt.append("           STACK HOUSE\n");
        receipt.append("         Fresh Sandwiches\n");
        receipt.append("=====================================\n\n");

        // Date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy  hh:mm a");
        receipt.append("Date: ").append(now.format(formatter)).append("\n");

        // Customer info
        receipt.append("Customer: ").append(order.getCustomerName()).append("\n\n");

        // Order details
        receipt.append("ORDER DETAILS:\n");
        receipt.append("-------------------------------------\n");

        // Add sandwiches
        for (int i = 0; i < order.getSandwiches().size(); i++) {
            Sandwich sandwich = order.getSandwiches().get(i);
            receipt.append((i + 1)).append(". ").append(sandwich.getDetailedDescription()).append("\n");
            receipt.append("   Price: $").append(String.format("%.2f", sandwich.getPrice())).append("\n\n");
        }

        // Add drinks
        for (int i = 0; i < order.getDrinks().size(); i++) {
            Drink drink = order.getDrinks().get(i);
            receipt.append((order.getSandwiches().size() + i + 1)).append(". ");
            receipt.append(drink.getDescription()).append("\n");
            receipt.append("   Price: $").append(String.format("%.2f", drink.getPrice())).append("\n\n");
        }

        // Add chips
        for (int i = 0; i < order.getChips().size(); i++) {
            Chips chips = order.getChips().get(i);
            receipt.append((order.getSandwiches().size() + order.getDrinks().size() + i + 1)).append(". ");
            receipt.append(chips.getDescription()).append("\n");
            receipt.append("   Price: $").append(String.format("%.2f", chips.getPrice())).append("\n\n");
        }

        // Totals
        receipt.append("-------------------------------------\n");
        double totalPrice = order.getTotalPrice();
        receipt.append("TOTAL:    $").append(String.format("%.2f", totalPrice)).append("\n\n");

        // Footer
        receipt.append("=====================================\n");
        receipt.append("      Thank you for visiting!\n");
        receipt.append("        Stack House \n");
        receipt.append("=====================================\n");

        return receipt.toString();
    }
}
