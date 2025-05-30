package com.pluralsight;

enum DrinkSize implements Displayable {
    SMALL("Small", 0),
    MEDIUM("Medium", 1),
    LARGE("Large", 2);

    private final String display;
    private final int priceIndex;


    //---Constructor------------------------------------
    DrinkSize(String display, int priceIndex) {
        this.display = display;
        this.priceIndex = priceIndex;
    }


    //---Getter--------------------------------------------
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
