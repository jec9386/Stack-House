package com.pluralsight;

import java.util.List;

public class Formatter {

    // 1- create 1 line description
    public static String getBasicDescription(Sandwich sandwich) {
        StringBuilder description = new StringBuilder();//able to continue to add String onto this

        if (sandwich instanceof SignatureSandwich) {
            SignatureSandwich s = (SignatureSandwich) sandwich;
            description.append(s.getSignatureName());
            description.append(" - ");
        } else {
            description.append("Custom- ");
        }

        // Add sandwich size
        description.append(sandwich.getSize().getDisplay());
        description.append(" ");//add a space

        // Add bread type
        description.append(sandwich.getBreadType().getDisplay());
        description.append(" ");

        // Add "(Toasted)" if the sandwich is toasted
        if (sandwich.isToasted()) {
            description.append(" (Toasted)");
        }

        return description.toString();
    }

    // 2- Detailed Description
    public static String getDetailedDescription(Sandwich sandwich) {
        StringBuilder details = new StringBuilder();

        // Start with the basic description and add a new line
        details.append(getBasicDescription(sandwich));
        details.append("\n");

        // Use our "cookie cutter" method for each section
        addSection(details, "Meats", sandwich.getMeats());
        addSection(details, "Extra Meats", sandwich.getExtraMeats());
        addSection(details, "Cheese", sandwich.getCheeses());
        addSection(details, "Extra Cheese", sandwich.getExtraCheeses());
        addSection(details, "Toppings", sandwich.getRegularToppings());
        addSection(details, "Sauces", sandwich.getSauces());

        return details.toString();
    }

    // HELPER METHOD FOR getDetailedDescription()- use generic to reduce repetition
    private static <T extends Displayable> void addSection(//type needs to be able to display itself
            StringBuilder sb, String displayName, List<T> items) {//where to add text, display, items to list

        // Only add this section if there are items in the list
        if (!items.isEmpty()) {
            sb.append(displayName);
            sb.append(": ");

            // Add each item in the list, separated by commas
            for (int i = 0; i < items.size(); i++) {
                sb.append(items.get(i).getDisplay());

                // Add comma if this isn't the last item
                if (i < items.size() - 1) {
                    sb.append(", ");
                }
            }

            // Add a new line at the end of this section
            sb.append("\n");
        }
    }


    // 3-Chips
    public static String getDescription(Chips chips) {
        return chips.getDisplay();
    }

    // 4- Drinks
    public static String getDescription(Drink drink) {
        return drink.getDisplay();
    }

    // 5 - Order
    public static String getDescription(Order order) {
        return getOrderSummary(order);
    }

    public static String getOrderSummary(Order order) {
        if (order.isEmpty()) {
            return "No items in order.";
        }

        StringBuilder summary = new StringBuilder();
        summary.append("Order for: ").append(order.getCustomerName()).append("\n");
        summary.append("Items: ").append(order.getTotalItemCount()).append(" item(s) ");
        summary.append("(").append(order.getSandwichCount()).append(" sandwich(es), ");
        summary.append(order.getChipsCount()).append(" chips, ");
        summary.append(order.getDrinkCount()).append(" drink(s))").append("\n");
        summary.append("Total: $").append(String.format("%.2f", order.getTotalPrice()));

        return summary.toString();
    }

    // 6 - Receipt
    public static String getDetailedReceipt(Order order) {
        if (order.isEmpty()) {
            return "No items in order.";
        }

        StringBuilder receipt = new StringBuilder();
        receipt.append("=== RECEIPT FOR ").append(order.getCustomerName().toUpperCase()).append(" ===\n\n");

        if (!order.getSandwiches().isEmpty()) {
            receipt.append("SANDWICHES:\n");
            List<Sandwich> sandwiches = order.getSandwiches();
            for (int i = 0; i < sandwiches.size(); i++) {
                receipt.append("  ").append(i + 1).append(". ");
                receipt.append(sandwiches.get(i).getDescription());
                receipt.append(" - $").append(String.format("%.2f", sandwiches.get(i).getPrice()));
                receipt.append("\n");
            }
            receipt.append("Sandwich subtotal: $").append(String.format("%.2f", order.getSandwichTotal())).append("\n\n");
        }


        if (!order.getChips().isEmpty()) {
            receipt.append("CHIPS:\n");
            List<Chips> chips = order.getChips();
            for (int i = 0; i < chips.size(); i++) {
                receipt.append("  ").append(i + 1).append(". ");
                receipt.append(chips.get(i).getDescription());
                receipt.append(" - $").append(String.format("%.2f", chips.get(i).getPrice()));
                receipt.append("\n");
            }
            receipt.append("Chips subtotal: $").append(String.format("%.2f", order.getChipsTotal())).append("\n\n");
        }

        if (!order.getDrinks().isEmpty()) {
            receipt.append("DRINKS:\n");
            List<Drink> drinks = order.getDrinks();
            for (int i = 0; i < drinks.size(); i++) {
                receipt.append("  ").append(i + 1).append(". ");
                receipt.append(drinks.get(i).getDescription());
                receipt.append(" - $").append(String.format("%.2f", drinks.get(i).getPrice()));
                receipt.append("\n");
            }
            receipt.append("Drinks subtotal: $").append(String.format("%.2f", order.getDrinksTotal())).append("\n\n");
        }

        receipt.append("========================================\n");
        receipt.append("TOTAL ORDER: $").append(String.format("%.2f", order.getTotalPrice()));

        return receipt.toString();
    }
}


