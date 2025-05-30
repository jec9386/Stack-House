package com.pluralsight;

public class Veggielicious extends SignatureSandwich {

    public Veggielicious() {
        super("Veggie Deluxe", "Fresh local bought vegetables with fresh cheese");
        // Change to wheat bread for healthier option
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

