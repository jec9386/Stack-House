package com.pluralsight;

public enum SandwichSize implements Displayable {

    //create Finalized Constants
    //these are pre-made objects, automatically calls constructor behind the scene when called
    FOUR_INCH("4\"", 0),
    EIGHT_INCH("8\"", 1),
    TWELVE_INCH("12\"", 2);

    private final String display;
    private final int priceIndex;

   SandwichSize(String display, int priceIndex) {
        this.display = display;
        this.priceIndex = priceIndex;
    }

    public String getDisplay() {
        return display;
    }

    public int getPriceIndex() {
        return priceIndex;
    }

}