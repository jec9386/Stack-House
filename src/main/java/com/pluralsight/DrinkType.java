package com.pluralsight;

enum DrinkType {
    RAWMILK("Fresh Milk"),
    LACTAID("Lactaid- Whole Milk"),
    ALMOND("Almond Milk"),
    SOY("Soy Milk"),
    COCONUT("Coconut Milk"),
    OAT("Oat Milk"),
    SPRITE("Sprite"),
    WATER("Water");

    private final String display;

    //---Constructor------------------------------------
    DrinkType(String display) {
        this.display = display;
    }


    //---Getter--------------------------------------------
    public String getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return display;
    }
}
