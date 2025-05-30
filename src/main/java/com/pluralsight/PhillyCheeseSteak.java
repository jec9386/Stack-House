package com.pluralsight;

public class PhillyCheeseSteak extends SignatureSandwich {

    public PhillyCheeseSteak() {
        super("Philly Cheese Steak", "Authentic steak and cheese sandwich");
    }

    @Override
    protected void addDefaultToppings() {
        // Philly Cheese Steak default toppings
        addMeat(Meat.STEAK);
        addCheese(Cheese.AMERICAN);
        addRegularTopping(RegularTopping.PEPPERS);
        addSauce(Sauce.MAYO);
        setToasted(true);
    }
}
