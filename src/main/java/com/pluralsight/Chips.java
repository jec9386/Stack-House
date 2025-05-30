package com.pluralsight;

enum Chips {
    RH_REAPER("Red Hot Reaper "),
    DINAMITA("Doritos Dinamita"),
    ANDY_HF("Andy Capp's Hot Fries"),
    SALT_AND_VINEGAR("LAY'S Salt & Vinegar"),
    TAKIS("Takis Fuego"),
    KETCHUP("LAY'S Ketchup");

    private final String display;
    private static final double chipPrice = 1.50;

    //---Constructor------------------------------------
    Chips(String display) {
        this.display = display;
    }

    //---Getter--------------------------------------------
    public String getDisplay() {
        return display;
    }

    public double getPrice() {
        return chipPrice;
    }

    public String getDescription() {
        return Formatter.getDescription(this);
    }




    @Override
    public String toString() {
        return display;
    }
}