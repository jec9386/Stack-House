public enum Sauce {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLANDS("Thousand Islands"),
    VINAIGRETTE("Vinaigrette"),
    AUJUS("Au Jus");

    private final String display;

    Sauce(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

}