public enum Meat {
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

    public double getPrice(SandwichSize size) {
        double[] prices = {1.00, 2.00, 3.00}; // 4", 8", 12"
        return prices[size.getPriceIndex()];
    }

    public double getExtraPrice(SandwichSize size) {
        double[] extraPrices = {0.50, 1.00, 1.50}; // 4", 8", 12"
        return extraPrices[size.getPriceIndex()];
    }
}
