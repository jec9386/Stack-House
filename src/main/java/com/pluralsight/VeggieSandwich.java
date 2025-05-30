package com.pluralsight;

public class VeggieSandwich extends SignatureSandwich {

    public VeggieSandwich() {
        super("Veggielicious", "Fresh vegetables with cheese");
    }

    @Override
    protected void addDefaultToppings() {
        // Veggie sandwich toppings (no meat)
        addCheese(Cheese.PROVOLONE);
        addCheese(Cheese.SWISS);
        addRegularTopping(RegularTopping.LETTUCE);
        addRegularTopping(RegularTopping.TOMATOES);
        addRegularTopping(RegularTopping.CUCUMBERS);
        addRegularTopping(RegularTopping.PEPPERS);
        addRegularTopping(RegularTopping.ONIONS);
        addSauce(Sauce.VINAIGRETTE);
        setToasted(false); // Fresh, not toasted
    }
}

