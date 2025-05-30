package com.pluralsight;

import java.util.List;

public class Formater {

    // 1- create 1 line description
    public static String getBasicDescription(Sandwich sandwich) {
        StringBuilder description = new StringBuilder();//able to continue to add String onto this

        description.append("Custom- ");

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


}
