package com.pluralsight;

public enum BreadType implements Displayable{
    WHITE("White Bread"),
    WHEAT("Wheat Bread"),
    RYE("Rye Bread"),
    WRAP("Wrap");

    private final String display;

    //---Constructor------------------------------------
    BreadType(String display) {
        this.display = display;
    }

    //---Getter--------------------------------------------
    public String getDisplay() {
        return display;
    }
}

