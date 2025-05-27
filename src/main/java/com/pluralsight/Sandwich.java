package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private BreadType breadType;
    private boolean toasted ;

    private List<Meat> meats;
    private List<Meat> extraMeats;
    private List<Cheese> cheeses;
    private List<Cheese> extraCheeses;
    private List<RegularTopping> regularToppings;
    private List<Sauce> sauces;

//---Constructor----------------------------------------------------

    public Sandwich(SandwichSize size, BreadType breadType) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = false;
        this.meats = new ArrayList<>();
        this.extraMeats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.extraCheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();

    }


    //----Methods to add topping---------------------------------------------------------------
    public void addMeat(Meat meat) {
        meats.add(meat);
    }

    public void addExtraMeat(Meat meat) {
        extraMeats.add(meat);
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public void addExtraCheese(Cheese cheese) {
        extraCheeses.add(cheese);
    }

    public void addRegularTopping(RegularTopping topping) {
        regularToppings.add(topping);
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    //---Method to calculate total price of add ons-----------------------------------------------------------------
    private double calculateTotalPrice() {
        double[] basePrices = {5.50, 7.00, 8.50}; // 4", 8", 12"
        double total = basePrices[size.getPriceIndex()];

        for (Meat meat : meats) {
            total += meat.getPrice(size);
        }

        for (Meat extraMeat : extraMeats) {
            total += extraMeat.getExtraPrice(size);
        }

        for (Cheese cheese : cheeses) {
            total += cheese.getPrice(size);
        }

        for (Cheese extraCheese : extraCheeses) {
            total += extraCheese.getExtraPrice(size);
        }

        return total;

    }

    //---Getter-------------------------------------------------------------
    public SandwichSize getSize() { return size; }
    public BreadType getBreadType() { return breadType; }
    public boolean isToasted() { return toasted; }
    public double getPrice() { return calculateTotalPrice(); }

    //---Method to get description for sandwich---------------------------------------------

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append(size.getDisplay()).append(" ");
        description.append(breadType.getDisplay()).append(" sandwich");

        if (toasted) {
            description.append(" (Toasted)");
        }

        return description.toString();
    }

    //---Detailed Description with all the toppings---------------------------------------
    public String getDetailedDescription() {
        StringBuilder detailedDescrip = new StringBuilder();
        detailedDescrip.append(getDescription()).append("\n");

        // Add meats
        if (!meats.isEmpty()) {
            detailedDescrip.append("Meats: ");
            for (int i = 0; i < meats.size(); i++) {
                detailedDescrip.append(meats.get(i).getDisplay());
                if (i < meats.size() - 1) detailedDescrip.append(", ");
            }
            detailedDescrip.append("\n");
        }

        // Add extra meats
        if (!extraMeats.isEmpty()) {
            detailedDescrip.append("Extra Meats: ");
            for (int i = 0; i < extraMeats.size(); i++) {
                detailedDescrip.append(extraMeats.get(i).getDisplay());
                if (i < extraMeats.size() - 1) detailedDescrip.append(", ");
            }
            detailedDescrip.append("\n");
        }

        // Add cheeses
        if (!cheeses.isEmpty()) {
            detailedDescrip.append("Cheese: ");
            for (int i = 0; i < cheeses.size(); i++) {
                detailedDescrip.append(cheeses.get(i).getDisplay());
                if (i < cheeses.size() - 1) detailedDescrip.append(", ");
            }
            detailedDescrip.append("\n");
        }

        // Add extra cheeses
        if (!extraCheeses.isEmpty()) {
            detailedDescrip.append("Extra Cheese: ");
            for (int i = 0; i < extraCheeses.size(); i++) {
                detailedDescrip.append(extraCheeses.get(i).getDisplay());
                if (i < extraCheeses.size() - 1) detailedDescrip.append(", ");
            }
            detailedDescrip.append("\n");
        }

        // Add regular toppings
        if (!regularToppings.isEmpty()) {
            detailedDescrip.append("Toppings: ");
            for (int i = 0; i < regularToppings.size(); i++) {
                detailedDescrip.append(regularToppings.get(i).getDisplay());
                if (i < regularToppings.size() - 1) detailedDescrip.append(", ");
            }
            detailedDescrip.append("\n");
        }

        // Add sauces
        if (!sauces.isEmpty()) {
            detailedDescrip.append("Sauces: ");
            for (int i = 0; i < sauces.size(); i++) {
                detailedDescrip.append(sauces.get(i).getDisplay());
                if (i < sauces.size() - 1) detailedDescrip.append(", ");
            }
            detailedDescrip.append("\n");
        }

        return detailedDescrip.toString();
    }

    @Override
    public String toString() {
        return getDescription() + " - $" + String.format("%.2f", getPrice());
    }

}
