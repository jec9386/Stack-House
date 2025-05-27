public enum DrinkSize {
    SMALL("Small", 2.00),
    MEDIUM("Medium", 2.50),
    LARGE("Large", 3.00);

    private final String display;
    private final double price;

    DrinkSize(String display, double price) {
        this.display = display;
        this.price = price;
    }

    public String getDisplay() {
        return display;
    }

    public double getPrice() {
        return price;
    }
}

