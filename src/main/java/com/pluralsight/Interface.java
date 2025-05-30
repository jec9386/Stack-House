package com.pluralsight;

public class Interface {
    private static Order currentOrder = null;

    public static void main(String[] args) {
        System.out.println("Welcome to Stack House!");

        // Main application loop
        while (true) {
            if (currentOrder == null) {
                showHomeScreen();
            } else {
                showOrderScreen();
            }
        }
    }

    // HOME SCREEN
    private static void showHomeScreen() {
        System.out.println("\n========== HOME SCREEN ==========");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.println("================================");

        int choice = Console.promptForChoice("Please select an option: ", 1);

        switch (choice) {
            case 1:
                startNewOrder();
                break;
            case 0:
                System.out.println("Thank you for visiting Stack House!");
                System.exit(0);
                break;
        }
    }

    // ORDER SCREEN
    private static void showOrderScreen() {
        System.out.println("\n========== ORDER SCREEN ==========");
        System.out.println("Customer: " + currentOrder.getCustomerName());


        int sandwichCount = currentOrder.getSandwiches().size();
        int drinkCount = currentOrder.getDrinks().size();
        int chipsCount = currentOrder.getChips().size();
        int totalItems = sandwichCount + drinkCount + chipsCount;

        if (totalItems == 0) {
            System.out.println("Order is empty");
        } else {
            System.out.println("Items in order: " + totalItems);
        }

        System.out.printf("Current total: $%.2f%n", currentOrder.getTotalPrice());
        System.out.println("\n1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) View Current Order");
        System.out.println("5) Checkout");
        System.out.println("0) Cancel Order");
        System.out.println("==================================");

        int choice = Console.promptForChoice("Please select an option: ", 5);

        switch (choice) {
            case 1:
                addSandwich();
                break;
            case 2:
                addDrink();
                break;
            case 3:
                addChips();
                break;
            case 4:
                viewCurrentOrder();
                break;
            case 5:
                checkout();
                break;
            case 0:
                cancelOrder();
                break;
        }
    }
//------Methods-------------------------------------------------------------------------------------------
    // START NEW ORDER
    private static void startNewOrder() {
        String customerName = Console.promptForString("Enter customer name: ");
        currentOrder = new Order(customerName);
        System.out.println("New order started for " + customerName + "!");
    }

    // ADD SANDWICH
    private static void addSandwich() {
        System.out.println("\n=== ADD SANDWICH ===");

        // Select bread
        System.out.println("Select your bread:");
        BreadType[] breads = BreadType.values();
        for (int i = 0; i < breads.length; i++) {
            System.out.println((i + 1) + ") " + breads[i].getDisplay());
        }
        System.out.println("0) Back to order menu");

        int breadChoice = Console.promptForChoice("Choose bread type: ", breads.length);
        if (breadChoice == 0) return; // User chose to go back
        BreadType breadType = breads[breadChoice - 1];

        // Select size
        System.out.println("\nSandwich size:");
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i].getDisplay());
        }
        System.out.println("0) Back to order menu");

        int sizeChoice = Console.promptForChoice("Choose size: ", sizes.length);
        if (sizeChoice == 0) return; // User chose to go back
        SandwichSize size = sizes[sizeChoice - 1];

        // Create sandwich
        Sandwich sandwich = new Sandwich(size, breadType);

        // Add toppings
        addToppingsToSandwich(sandwich);

        // Toasted?
        boolean toasted = Console.promptForYesNo("Would you like the sandwich toasted?");
        sandwich.setToasted(toasted);

        // Add to order
        currentOrder.addSandwich(sandwich);
        System.out.println("\nSandwich added to order!");
        System.out.println(sandwich.getDescription());
    }

    // ADD TOPPINGS TO SANDWICH
    private static void addToppingsToSandwich(Sandwich sandwich) {
        // Meat toppings
        System.out.println("\nMeat:");
        Meat[] meats = Meat.values();
        for (int i = 0; i < meats.length; i++) {
            System.out.printf("%d) %s (+$%.2f)%n", (i + 1), meats[i].getDisplay(), meats[i].getPrice(sandwich.getSize()));
        }

        while (true) {
            int meatChoice = Console.promptForChoiceWithSkip("Add meat (0 to continue): ", meats.length);
            if (meatChoice == 0) break;
            sandwich.addMeat(meats[meatChoice - 1]);
            System.out.println("Added " + meats[meatChoice - 1].getDisplay());

            // Ask for extra
            boolean extraMeat = Console.promptForYesNo("Would you like extra " + meats[meatChoice - 1].getDisplay() + "?");
            if (extraMeat) {
                sandwich.addExtraMeat(meats[meatChoice - 1]);
                System.out.println("Added extra " + meats[meatChoice - 1].getDisplay());
            }
        }

        // Cheese toppings
        System.out.println("\nCheese:");
        Cheese[] cheeses = Cheese.values();
        for (int i = 0; i < cheeses.length; i++) {
            System.out.printf("%d) %s (+$%.2f)%n", (i + 1), cheeses[i].getDisplay(), cheeses[i].getPrice(sandwich.getSize()));
        }

        while (true) {
            int cheeseChoice = Console.promptForChoiceWithSkip("Add cheese (0 to continue): ", cheeses.length);
            if (cheeseChoice == 0) break;
            sandwich.addCheese(cheeses[cheeseChoice - 1]);
            System.out.println("Added " + cheeses[cheeseChoice - 1].getDisplay());

            // Ask for extra
            boolean extraCheese = Console.promptForYesNo("Would you like extra " + cheeses[cheeseChoice - 1].getDisplay() + "?");
            if (extraCheese) {
                sandwich.addExtraCheese(cheeses[cheeseChoice - 1]);
                System.out.println("Added extra " + cheeses[cheeseChoice - 1].getDisplay());
            }
        }

        // Other toppings (regular toppings)
        System.out.println("\nOther toppings:");
        RegularTopping[] toppings = RegularTopping.values();
        for (int i = 0; i < toppings.length; i++) {
            System.out.println((i + 1) + ") " + toppings[i].getDisplay() + " (FREE)");
        }

        while (true) {
            int toppingChoice = Console.promptForChoiceWithSkip("Add topping (0 to continue): ", toppings.length);
            if (toppingChoice == 0) break;
            sandwich.addRegularTopping(toppings[toppingChoice - 1]);
            System.out.println("Added " + toppings[toppingChoice - 1].getDisplay());
        }

        // Select sauces
        System.out.println("\nSelect sauces:");
        Sauce[] sauces = Sauce.values();
        for (int i = 0; i < sauces.length; i++) {
            System.out.println((i + 1) + ") " + sauces[i].getDisplay() + " (FREE)");
        }

        while (true) {
            int sauceChoice = Console.promptForChoiceWithSkip("Add sauce (0 to continue): ", sauces.length);
            if (sauceChoice == 0) break;
            sandwich.addSauce(sauces[sauceChoice - 1]);
            System.out.println("Added " + sauces[sauceChoice - 1].getDisplay());
        }
    }

    // ADD DRINK
    private static void addDrink() {
        System.out.println("\n=== ADD DRINK ===");

        // Select drink type/flavor
        System.out.println("Select drink flavor:");
        DrinkType[] types = DrinkType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") " + types[i].getDisplay());
        }
        System.out.println("0) Back to order menu");

        int typeChoice = Console.promptForChoice("Choose drink flavor: ", types.length);
        if (typeChoice == 0) return;
        DrinkType drinkType = types[typeChoice - 1];

        // Select drink size
        System.out.println("\nSelect drink size:");
        DrinkSize[] sizes = DrinkSize.values();
        for (int i = 0; i < sizes.length; i++) {
            // Show pricing for each size
            Drink tempDrink = new Drink(sizes[i], drinkType);
            System.out.printf("%d) %s - $%.2f%n", (i + 1), sizes[i].getDisplay(), tempDrink.getPrice());
        }
        System.out.println("0) Back to order menu");

        int sizeChoice = Console.promptForChoice("Choose drink size: ", sizes.length);
        if (sizeChoice == 0) return;
        DrinkSize drinkSize = sizes[sizeChoice - 1];

        // Create and add drink
        Drink drink = new Drink(drinkSize, drinkType);
        currentOrder.addDrink(drink);
        System.out.println("\nDrink added to order!");
        System.out.println(drink.getDescription());
    }

    // ADD CHIPS
    private static void addChips() {
        System.out.println("\n=== ADD CHIPS ===");

        // Select chip type
        System.out.println("Select chip type:");
        Chips[] chipTypes = Chips.values();
        for (int i = 0; i < chipTypes.length; i++) {
            System.out.printf("%d) %s - $%.2f%n", (i + 1), chipTypes[i].getDisplay(), chipTypes[i].getPrice());
        }

        int chipChoice = Console.promptForChoice("Choose chip type: ", chipTypes.length);
        if (chipChoice == 0) return;

        Chips selectedChips = chipTypes[chipChoice - 1];
        currentOrder.addChips(selectedChips);
        System.out.println("\nChips added to order!");
        System.out.println(selectedChips.getDescription());
    }

    // VIEW CURRENT ORDER
    private static void viewCurrentOrder() {
        System.out.println("\n=== CURRENT ORDER ===");
        System.out.println(currentOrder.getOrderSummary());

        System.out.println("\nPress Enter to continue...");
        Console.promptForString("");
    }

    // CHECKOUT
    private static void checkout() {
        System.out.println("\n=== CHECKOUT ===");

        System.out.println(currentOrder.getOrderConfirmation());

        boolean confirm = Console.promptForYesNo("Confirm order?");

        if (confirm) {
            // Create receipt file (TODO: implement ReceiptManager)
            System.out.println("\n" + currentOrder.getDetailedReceipt());
            System.out.println("\nReceipt created! Thank you for choosing Stack House!");

            // Reset for next customer
            currentOrder = null;
        } else {
            System.out.println("Order cancelled.");
            currentOrder = null;
        }
    }

    // CANCEL ORDER
    private static void cancelOrder() {
        boolean confirm = Console.promptForYesNo("Are you sure you want to cancel this order?");
        if (confirm) {
            System.out.println("Order cancelled.");
            currentOrder = null;
        }
    }
}