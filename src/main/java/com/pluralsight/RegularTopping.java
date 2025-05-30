package com.pluralsight;

public enum RegularTopping implements Displayable{
    LETTUCE("Lettuce"),
    PEPPERS("Peppers"),
    ONIONS("Onions"),
    TOMATOES("Tomatoes"),
    JALAPENOS("Jalapeños"),
    CUCUMBERS("Cucumbers"),
    PICKLES("Pickles"),
    GUACAMOLE("Guacamole"),
    MUSHROOMS("Mushrooms");

    private final String display;

    //---Constructor------------------------------------
    RegularTopping(String display) {
        this.display = display;
    }

    //---Getter--------------------------------------------
    public String getDisplay() {
        return display;
    }
}

