package com.pluralsight;
public abstract class SignatureSandwich extends Sandwich {
    private String signatureName;
    private String description;

    public SignatureSandwich(String signatureName, String description) {
        // All signature sandwiches are 8" by default (can be changed)
        super(SandwichSize.EIGHT_INCH, BreadType.WHITE);
        this.signatureName = signatureName;
        this.description = description;

        // Each signature sandwich will add its default toppings
        addDefaultToppings();
    }

    // Each signature sandwich defines its own default toppings
    protected abstract void addDefaultToppings();

    public String getSignatureName() {
        return signatureName;
    }

    public String getSignatureDescription() {
        return description;
    }

    // Allow customers to customize after creation
    public void customize() {
        System.out.println("\n=== CUSTOMIZING " + signatureName.toUpperCase() + " ===");
        System.out.println("Current toppings: " + super.getDescription());
        System.out.println("You can add more toppings or remove existing ones.");
    }
}

