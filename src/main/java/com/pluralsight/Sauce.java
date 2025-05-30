package com.pluralsight;

public enum Sauce implements Displayable{
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLANDS("Thousand Islands"),
    VINAIGRETTE("Italian Vinaigrette"),
    AUJUS("Au Jus");

    private final String display;


    //---Constructor------------------------------------
    Sauce(String display) {
        this.display = display;
    }


    //---Getter--------------------------------------------
    public String getDisplay() {
        return display;
    }

}