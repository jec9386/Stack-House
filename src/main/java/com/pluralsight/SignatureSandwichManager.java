package com.pluralsight;

public class SignatureSandwichManager {

    // Get all available signature sandwiches
    public static SignatureSandwich[] getAvailableSignatureSandwiches() {
        return new SignatureSandwich[] {
                new BLTSandwich(),
                new PhillyCheeseSteak(),
                new VeggieSandwich()
        };
    }

    // Display all signature sandwiches with prices
    public static void displaySignatureSandwiches() {
        System.out.println("\n=== SIGNATURE SANDWICHES ===");
        SignatureSandwich[] signatures = getAvailableSignatureSandwiches();

        for (int i = 0; i < signatures.length; i++) {
            SignatureSandwich sandwich = signatures[i];
            System.out.println((i + 1) + ". " + sandwich.getSignatureName() +
                    " - $" + String.format("%.2f", sandwich.getPrice()));
            System.out.println("   " + sandwich.getDescription());
            System.out.println();
        }
        System.out.println("===============================");
    }

    // Create a signature sandwich by index
    public static SignatureSandwich createSignatureSandwich(int index) {
        SignatureSandwich[] signatures = getAvailableSignatureSandwiches();

        if (index < 0 || index >= signatures.length) {
            return null;
        }

        // Return a fresh instance (not the display one)
        switch (index) {
            case 0: return new BLTSandwich();
            case 1: return new PhillyCheeseSteak();
            case 2: return new VeggieSandwich();
            default: return null;
        }
    }

    // Allow customer to customize a signature sandwich
    public static void customizeSignatureSandwich(SignatureSandwich sandwich, java.util.Scanner scanner) {
        sandwich.customize();

        while (true) {
            System.out.println("\nCustomization Options:");
            System.out.println("1. Add extra meat");
            System.out.println("2. Add extra cheese");
            System.out.println("3. Add regular toppings");
            System.out.println("4. Add sauces");
            System.out.println("5. Remove toppings");
            System.out.println("6. Change size");
            System.out.println("7. Change bread");
            System.out.println("8. Toggle toasted");
            System.out.println("0. Done customizing");

            System.out.print("Choose customization (0-8): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addExtraMeat(sandwich, scanner);
                        break;
                    case 2:
                        addExtraCheese(sandwich, scanner);
                        break;
                    case 3:
                        addRegularToppings(sandwich, scanner);
                        break;
                    case 4:
                        addSauces(sandwich, scanner);
                        break;
                    case 5:
                        removeToppings(sandwich, scanner);
                        break;
                    case 6:
                        changeSize(sandwich, scanner);
                        break;
                    case 7:
                        changeBread(sandwich, scanner);
                        break;
                    case 8:
                        sandwich.setToasted(!sandwich.isToasted());
                        System.out.println("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
                        break;
                    case 0:
                        System.out.println("Customization complete!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }

                // Show updated sandwich
                System.out.println("\nUpdated sandwich: " + sandwich.getDescription());
                System.out.println("New price: $" + String.format("%.2f", sandwich.getPrice()));

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void addExtraMeat(SignatureSandwich sandwich, java.util.Scanner scanner) {
        System.out.println("\nAvailable meats:");
        Meat[] meats = Meat.values();
        for (int i = 0; i < meats.length; i++) {
            System.out.println((i + 1) + ". " + meats[i].getDisplay() +
                    " (+$" + String.format("%.2f", meats[i].getPrice(sandwich.getSize())) + ")");
        }

        try {
            System.out.print("Add meat (1-" + meats.length + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < meats.length) {
                sandwich.addMeat(meats[choice]);
                System.out.println("Added " + meats[choice].getDisplay());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
        }
    }

    private static void addExtraCheese(SignatureSandwich sandwich, java.util.Scanner scanner) {
        System.out.println("\nAvailable cheese:");
        Cheese[] cheeses = Cheese.values();
        for (int i = 0; i < cheeses.length; i++) {
            System.out.println((i + 1) + ". " + cheeses[i].getDisplay() +
                    " (+$" + String.format("%.2f", cheeses[i].getPrice(sandwich.getSize())) + ")");
        }

        try {
            System.out.print("Add cheese (1-" + cheeses.length + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < cheeses.length) {
                sandwich.addCheese(cheeses[choice]);
                System.out.println("Added " + cheeses[choice].getDisplay());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
        }
    }

    private static void addRegularToppings(SignatureSandwich sandwich, java.util.Scanner scanner) {
        System.out.println("\nAvailable toppings (FREE):");
        RegularTopping[] toppings = RegularTopping.values();
        for (int i = 0; i < toppings.length; i++) {
            System.out.println((i + 1) + ". " + toppings[i].getDisplay());
        }

        try {
            System.out.print("Add topping (1-" + toppings.length + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < toppings.length) {
                sandwich.addRegularTopping(toppings[choice]);
                System.out.println("Added " + toppings[choice].getDisplay());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
        }
    }

    private static void addSauces(SignatureSandwich sandwich, java.util.Scanner scanner) {
        System.out.println("\nAvailable sauces (FREE):");
        Sauce[] sauces = Sauce.values();
        for (int i = 0; i < sauces.length; i++) {
            System.out.println((i + 1) + ". " + sauces[i].getDisplay());
        }

        try {
            System.out.print("Add sauce (1-" + sauces.length + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < sauces.length) {
                sandwich.addSauce(sauces[choice]);
                System.out.println("Added " + sauces[choice].getDisplay());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
        }
    }

    private static void removeToppings(SignatureSandwich sandwich, java.util.Scanner scanner) {
        System.out.println("\nRemove toppings feature would require modification to Sandwich class");
        System.out.println("(This would need removeMeat, removeCheese, etc. methods)");
        System.out.println("For now, you can only add toppings to signature sandwiches.");
    }

    private static void changeSize(SignatureSandwich sandwich, java.util.Scanner scanner) {
        System.out.println("\nAvailable sizes:");
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ". " + sizes[i].getDisplay());
        }

        try {
            System.out.print("Choose size (1-" + sizes.length + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < sizes.length) {
                sandwich.setSize(sizes[choice]);  // Changed from setSandwichSize
                System.out.println("Changed to " + sizes[choice].getDisplay());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
        }
    }

    private static void changeBread(SignatureSandwich sandwich, java.util.Scanner scanner) {
        System.out.println("\nAvailable bread:");
        BreadType[] breads = BreadType.values();
        for (int i = 0; i < breads.length; i++) {
            System.out.println((i + 1) + ". " + breads[i].getDisplay());
        }

        try {
            System.out.print("Choose bread (1-" + breads.length + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < breads.length) {
                sandwich.setBreadType(breads[choice]);  // Changed from setBreadType
                System.out.println("Changed to " + breads[choice].getDisplay());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
        }
    }
}
