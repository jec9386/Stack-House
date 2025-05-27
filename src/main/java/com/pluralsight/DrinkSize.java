package com.pluralsight;

enum DrinkSize {
    SMALL("Small", 0),
    MEDIUM("Medium", 1),
    LARGE("Large", 2);

    private final String display;
    private final int priceIndex;

    DrinkSize(String display, int priceIndex) {
        this.display = display;
        this.priceIndex = priceIndex;
    }

    public String getDisplay() {
        return display;
    }

    public int getPriceIndex() {
        return priceIndex;
    }

    @Override
    public String toString() {
        return display;
    }
}
