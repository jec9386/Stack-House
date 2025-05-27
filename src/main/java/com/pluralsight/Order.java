package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Chips> chips;
    private List<Drink> drinks;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
        this.sandwiches = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    // Add items to order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // Remove items from order
    public boolean removeSandwich(Sandwich sandwich) {
        return sandwiches.remove(sandwich);
    }

    public boolean removeChips(Chips chips) {
        return this.chips.remove(chips);
    }

    public boolean removeDrink(Drink drink) {
        return drinks.remove(drink);
    }

    // Get counts
    public int getSandwichCount() {
        return sandwiches.size();
    }

    public int getChipsCount() {
        return chips.size();
    }

    public int getDrinkCount() {
        return drinks.size();
    }

    public int getTotalItemCount() {
        return getSandwichCount() + getChipsCount() + getDrinkCount();
    }

    // Calculate prices
    public double getSandwichTotal() {
        double total = 0.0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }
        return total;
    }

    public double getChipsTotal() {
        double total = 0.0;
        for (Chips chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }

    public double getDrinksTotal() {
        double total = 0.0;
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        return total;
    }

    public double getTotalPrice() {
        return getSandwichTotal() + getChipsTotal() + getDrinksTotal();
    }

    // Utility methods
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isEmpty() {
        return getTotalItemCount() == 0;
    }

    public void clearOrder() {
        sandwiches.clear();
        chips.clear();
        drinks.clear();
    }

    // Get copies of lists (protect original data)
    public List<Sandwich> getSandwiches() {
        return new ArrayList<>(sandwiches);
    }

    public List<Chips> getChips() {
        return new ArrayList<>(chips);
    }

    public List<Drink> getDrinks() {
        return new ArrayList<>(drinks);
    }

    // Order summary
    public String getOrderSummary() {
        if (isEmpty()) {
            return "No items in order.";
        }

        StringBuilder summary = new StringBuilder();
        summary.append("Order for: ").append(customerName).append("\n");
        summary.append("Items: ").append(getTotalItemCount()).append(" item(s) ");
        summary.append("(").append(getSandwichCount()).append(" sandwich(es), ");
        summary.append(getChipsCount()).append(" chips, ");
        summary.append(getDrinkCount()).append(" drink(s))").append("\n");
        summary.append("Total: $").append(String.format("%.2f", getTotalPrice()));

        return summary.toString();
    }

    // Detailed receipt
    public String getDetailedReceipt() {
        if (isEmpty()) {
            return "No items in order.";
        }

        StringBuilder receipt = new StringBuilder();
        receipt.append("=== RECEIPT FOR ").append(customerName.toUpperCase()).append(" ===\n\n");

        // Sandwiches section
        if (!sandwiches.isEmpty()) {
            receipt.append("SANDWICHES:\n");
            for (int i = 0; i < sandwiches.size(); i++) {
                receipt.append("  ").append(i + 1).append(". ");
                receipt.append(sandwiches.get(i).getDescription());
                receipt.append(" - $").append(String.format("%.2f", sandwiches.get(i).getPrice()));
                receipt.append("\n");
            }
            receipt.append("Sandwich subtotal: $").append(String.format("%.2f", getSandwichTotal())).append("\n\n");
        }

        // Chips section
        if (!chips.isEmpty()) {
            receipt.append("CHIPS:\n");
            for (int i = 0; i < chips.size(); i++) {
                receipt.append("  ").append(i + 1).append(". ");
                receipt.append(chips.get(i).getDisplay());
                receipt.append(" - $").append(String.format("%.2f", chips.get(i).getPrice()));
                receipt.append("\n");
            }
            receipt.append("Chips subtotal: $").append(String.format("%.2f", getChipsTotal())).append("\n\n");
        }

        // Drinks section
        if (!drinks.isEmpty()) {
            receipt.append("DRINKS:\n");
            for (int i = 0; i < drinks.size(); i++) {
                receipt.append("  ").append(i + 1).append(". ");
                receipt.append(drinks.get(i).getDisplay());
                receipt.append(" - $").append(String.format("%.2f", drinks.get(i).getPrice()));
                receipt.append("\n");
            }
            receipt.append("Drinks subtotal: $").append(String.format("%.2f", getDrinksTotal())).append("\n\n");
        }

        receipt.append("========================================\n");
        receipt.append("TOTAL ORDER: $").append(String.format("%.2f", getTotalPrice()));

        return receipt.toString();
    }

    @Override
    public String toString() {
        return getOrderSummary();
    }
}


