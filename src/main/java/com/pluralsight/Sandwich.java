package com.pluralsight;


import java.util.ArrayList;
import java.util.List;

public class Sandwich  {
    private SandwichSize size;
    private BreadType breadType;
    private boolean toasted;

    //create List field- have ability to hold more than one selection.
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
        this.meats = new ArrayList<>();//create empty arrays in preparation to hold selections
        this.extraMeats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.extraCheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }
    //---Getter-------------------------------------------------------------
    public SandwichSize getSize() { return size; }
    public BreadType getBreadType() { return breadType; }
    public boolean isToasted() { return toasted; }
    public double getPrice() { return calculateTotalPrice(); }// gets return value of calculateTotalPrice()


    //----Methods to modify/add topping to the Sandwich---------------------------------------------------------------
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

    //---Getter to return copy of added topping for viewing and receipt printing---------------------------------------------------------------

    public List<Meat> getMeats() {
        return new ArrayList<>(meats);
    }

    public List<Meat> getExtraMeats() {
        return new ArrayList<>(extraMeats);
    }

    public List<Cheese> getCheeses() {
        return new ArrayList<>(cheeses);
    }

    public List<Cheese> getExtraCheeses() {
        return new ArrayList<>(extraCheeses);
    }

    public List<RegularTopping> getRegularToppings() {
        return new ArrayList<>(regularToppings);
    }

    public List<Sauce> getSauces() {
        return new ArrayList<>(sauces);
    }
    //---Setter methods for customization---------------------------------------------------------------
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    //---Methods to remove toppings---------------------------------------------------------------

    public void removeMeat(Meat meat) {
        meats.remove(meat);
    }

    public void removeExtraMeat(Meat meat) {
        extraMeats.remove(meat);
    }

    public void removeCheese(Cheese cheese) {
        cheeses.remove(cheese);
    }

    public void removeExtraCheese(Cheese cheese) {
        extraCheeses.remove(cheese);
    }

    public void removeRegularTopping(RegularTopping topping) {
        regularToppings.remove(topping);
    }

    public void removeSauce(Sauce sauce) {
        sauces.remove(sauce);
    }


//-------CALCULATIONS-----------------------------------------------------------------------------------------------
    //---Method to calculate total price of add ons-----------------------------------------------------------------
    private double calculateTotalPrice() {
        double[] basePrices = {5.50, 7.00, 8.50}; // 4", 8", 12"
        double total = basePrices[size.getPriceIndex()];//start with initial value- cost of size chosen.

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



    //---Method to get description for sandwich-------------------------------------------------------------------------

    public String getDescription() {
        return Formatter.getBasicDescription(this);
    }

    public String getDetailedDescription() {
        return Formatter.getDetailedDescription(this);
    }

    @Override
    public String toString() {
        return getDescription() + " - $" + String.format("%.2f", getPrice());
    }
}