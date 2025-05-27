public class Sandwich {
    private SandwichSize size;
    private BreadType breadType;
    private double price;

    public Sandwich(SandwichSize size, BreadType breadType) {
        this.size = size;
        this.breadType = breadType;
        this.price = calculatePrice();
    }

    //---Constructor----------------------------------------------------

    private double calculatePrice() {
        // Base prices by size
        double[] basePrices = {5.50, 7.00, 8.50}; // 4", 8", 12"
        return basePrices[size.getPriceIndex()];
    }

    //---Getter-------------------------------------------------------------
    public SandwichSize getSize() {
        return size;
    }
    public BreadType getBreadType() {
        return breadType;
    }
    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return size.getDisplay() + " " + breadType.getDisplay() + " sandwich";
    }

    @Override
    public String toString() {
        return getDescription() + " - $" + String.format("%.2f", price);
    }

}
