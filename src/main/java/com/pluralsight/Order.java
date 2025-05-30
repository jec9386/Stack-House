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

    // Get items in list
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

    // Calculate total prices for each List
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

    // Customer methods
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isEmpty() {//determines if there are items
        return getTotalItemCount() == 0;
    }

    public void clearOrder() {//for start over or cancel item- deletes items in the List
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

    public String getOrderSummary() {
        return Formatter.getOrderSummary(this);
    }

    // Order confirmation
    public String getOrderConfirmation() {
        if (isEmpty()) {
            return "Your cart is empty.";
        }

        StringBuilder confirmation = new StringBuilder();
        confirmation.append("========== ORDER CONFIRMATION ==========\n");
        confirmation.append("Customer: ").append(customerName).append("\n\n");

        // Show detailed breakdown of each item type
        if (!sandwiches.isEmpty()) {
            confirmation.append("SANDWICHES:\n");
            for (int i = 0; i < sandwiches.size(); i++) {
                confirmation.append("  ").append(i + 1).append(". ");
                confirmation.append(sandwiches.get(i).getDetailedDescription()); // Full sandwich details
                confirmation.append("     Price: $").append(String.format("%.2f", sandwiches.get(i).getPrice()));
                confirmation.append("\n\n");
            }
            confirmation.append("Sandwiches subtotal: $").append(String.format("%.2f", getSandwichTotal())).append("\n\n");
        }

        if (!chips.isEmpty()) {
            confirmation.append("CHIPS:\n");
            for (int i = 0; i < chips.size(); i++) {
                confirmation.append("  ").append(i + 1).append(". ");
                confirmation.append(chips.get(i).getDescription());
                confirmation.append(" - $").append(String.format("%.2f", chips.get(i).getPrice()));
                confirmation.append("\n");
            }
            confirmation.append("Chips subtotal: $").append(String.format("%.2f", getChipsTotal())).append("\n\n");
        }

        if (!drinks.isEmpty()) {
            confirmation.append("DRINKS:\n");
            for (int i = 0; i < drinks.size(); i++) {
                confirmation.append("  ").append(i + 1).append(". ");
                confirmation.append(drinks.get(i).getDescription());
                confirmation.append(" - $").append(String.format("%.2f", drinks.get(i).getPrice()));
                confirmation.append("\n");
            }
            confirmation.append("Drinks subtotal: $").append(String.format("%.2f", getDrinksTotal())).append("\n\n");
        }

        confirmation.append("==========================================\n");
        confirmation.append("TOTAL ORDER: $").append(String.format("%.2f", getTotalPrice())).append("\n");
        confirmation.append("==========================================\n");
        confirmation.append("\nDoes this look correct? (Y/N)");

        return confirmation.toString();
    }

    // Formatter integration method (simplified)
    public String getDescription() {
        return Formatter.getDescription(this);
    }

    // DETAILED RECEIPT METHOD
    public String getDetailedReceipt() {
        return Formatter.getDetailedReceipt(this);
    }

    @Override
    public String toString() {
        return getOrderSummary();
    }
}

