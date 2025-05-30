package com.pluralsight;

public class BLTSandwich extends SignatureSandwich {

    public BLTSandwich() {
        super("BLT", "Classic bacon, lettuce, and tomato sandwich");
    }

    @Override
    protected void addDefaultToppings() {
        // BLT default toppings
        addMeat(Meat.BACON);
        addCheese(Cheese.CHEDDAR);
        addRegularTopping(RegularTopping.LETTUCE);
        addRegularTopping(RegularTopping.TOMATOES);
        addSauce(Sauce.MAYO);
        setToasted(true);
    }
}