public enum BreadType {
    WHITE("White"),
    WHEAT("Wheat"),
    RYE("Rye"),
    WRAP("Wrap");

    private final String display;

    BreadType(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}

