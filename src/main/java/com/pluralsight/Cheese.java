package com.pluralsight;

public enum Cheese {
    AMERICAN("American"),
    PROVOLONE("Provolone"),
    CHEDDAR("Cheddar"),
    SWISS("Swiss");

    private final String display;

    Cheese(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public double getPrice(SandwichSize size) {
        double[] prices = {0.75, 1.50, 2.25}; // 4", 8", 12"
        return prices[size.getPriceIndex()];
    }

    public double getExtraPrice(SandwichSize size) {
        double[] extraPrices = {0.30, 0.60, 0.90}; // 4", 8", 12"
        return extraPrices[size.getPriceIndex()];
    }
}
