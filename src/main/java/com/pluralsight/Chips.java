package com.pluralsight;

enum Chips {
    RH_Reaper("Red Hot Reaper "),
    DINAMITA("Doritos Dinamita"),
    ANDY_HF("Andy Capp's Hot Fries"),
    SALT_AND_VINEGAR("LAY'S Salt & Vinegar"),
    TAKIS("Takis Fuego"),
    KETCHUP("LAY'S Ketchup");

    private final String display;
    private static final double chipPrice = 1.50;

    Chips(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public double getPrice() {
        return chipPrice;
    }

    @Override
    public String toString() {
        return display;
    }
}