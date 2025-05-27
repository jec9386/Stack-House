package com.pluralsight;

class Drink {
    private DrinkSize size;
    private DrinkType type;


    private static final double[] drinkPrices = {2.00, 2.50, 3.00};

    public Drink(DrinkSize size, DrinkType type) {
        this.size = size;
        this.type = type;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkType getType() {
        return type;
    }

    public double getPrice() {
        return drinkPrices[size.getPriceIndex()];
    }

    public String getDisplay() {
        return size.getDisplay() + " " + type.getDisplay();
    }

    @Override
    public String toString() {
        return getDisplay() + " - $" + String.format("%.2f", getPrice());
    }
}