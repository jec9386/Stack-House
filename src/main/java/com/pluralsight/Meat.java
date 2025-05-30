package com.pluralsight;

public enum Meat implements Displayable {
    STEAK("Steak"),
    HAM("Ham"),
    SALAMI("Salami"),
    ROAST_BEEF("Roast Beef"),
    CHICKEN("Chicken"),
    BACON("Bacon");

    private final String display;

    //---Constructor------------------------------------
    Meat(String display) {
        this.display = display;
    }

    //---Getter--------------------------------------------

    public String getDisplay() {
        return display;
    }

    //method to calculate price of meat based on sandwich size
    public double getPrice(SandwichSize size) {
        double[] prices = {1.00, 2.00, 3.00}; // 4", 8", 12"
        return prices[size.getPriceIndex()];//get price index of sandwich to match up with appropriate meat price.
    }

    public double getExtraPrice(SandwichSize size) {
        double[] extraPrices = {0.50, 1.00, 1.50}; // 4", 8", 12"
        return extraPrices[size.getPriceIndex()];
    }

    public void displayMeats(){

    }
}
