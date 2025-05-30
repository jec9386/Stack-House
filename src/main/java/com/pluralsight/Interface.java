package com.pluralsight;

public class Interface {
    private static Order currentOrder = null;

    public void run() {
        System.out.println("Welcome to Stack House!");

        while (true) {
            showMainMenu();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Stack House!");

        while (true) {
            showMainMenu();
        }
    }

    // MAIN MENU------------------------------------------------------------------------------------
    private static void showMainMenu() {
        System.out.println("\n==================================");
        System.out.println("        STACK HOUSE                 ");
        System.out.println("==================================");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.println("==================================");

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

    // START NEW ORDER---------------------------------------------------------------------------------------------
    private static void startNewOrder() {
        System.out.println("\n=== NEW ORDER ===");
        String customerName = Console.promptForString("Enter customer name: ");
        currentOrder = new Order(customerName);

        System.out.println("Order started for " + customerName);

        // Show order menu
        while (currentOrder != null) {
            showOrderMenu();
        }
    }

    // ORDER MENU--------------------------------------------------------------------------------------------------------
    private static void showOrderMenu() {
        System.out.println("\n==================================");
        System.out.println("       ORDER FOR: " + currentOrder.getCustomerName());
        System.out.println("==================================");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Signature Sandwich");
        System.out.println("3) Add Drink");
        System.out.println("4) Add Chips");
        System.out.println("5) View Current Order");
        System.out.println("6) Checkout");
        System.out.println("0) Cancel Order");
        System.out.println("==================================");

        int choice = Console.promptForChoice("Please select an option: ", 6);

        switch (choice) {
            case 1:
                addSandwich();
                break;
            case 2:
                addSignatureSandwich();
                break;
            case 3:
                addDrink();
                break;
            case 4:
                addChips();
                break;
            case 5:
                viewCurrentOrder();
                break;
            case 6:
                checkout();
                break;
            case 0:
                cancelOrder();
                break;
        }
    }

    // ADD SIGNATURE SANDWICH----------------------------------------------------------------------------------------------
    private static void addSignatureSandwich() {
        System.out.println("\n=== SIGNATURE SANDWICHES ===");
        System.out.println("Choose from our popular combinations:");

        System.out.println("1) BLT Classic - Bacon, lettuce, tomato on toasted bread");
        System.out.println("2) Philly Cheesesteak - Steak, cheese, peppers, onions");
        System.out.println("3) Veggielicious - Fresh vegetables with cheese");
        System.out.println("0) Back to order menu");

        int choice = Console.promptForChoice("Choose signature sandwich: ", 3);
        if (choice == 0) return; // User chose to go back

        SignatureSandwich signatureSandwich = null;

        switch (choice) {
            case 1:
                signatureSandwich = new BLTSandwich();
                break;
            case 2:
                signatureSandwich = new PhillyCheeseSteak();
                break;
            case 3:
                signatureSandwich = new VeggieSandwich();
                break;
        }

        if (signatureSandwich != null) {
            // Show what comes with it
            System.out.println("\n" + signatureSandwich.getSignatureName());
            System.out.println("Description: " + signatureSandwich.getDescription());
            System.out.println("Current toppings: " + signatureSandwich.getDetailedDescription());

            // Ask if they want to customize
            boolean customize = Console.promptForYesNo("Would you like to customize this sandwich?");
            if (customize) {
                customizeSignatureSandwich(signatureSandwich);
            }

            // Ask about toasted (some signatures have defaults)
            boolean toasted = Console.promptForYesNo("Would you like this sandwich toasted?");
            signatureSandwich.setToasted(toasted);

            // Add to order
            currentOrder.addSandwich(signatureSandwich);
            System.out.println("\n" + signatureSandwich.getSignatureName() + " added to order!");
            System.out.println(signatureSandwich.getDetailedDescription());
        }
    }

    // ADD SANDWICH----------------------------------------------------------------------------------------------------
    private static void addSandwich() {
        System.out.println("\n=== ADD SANDWICH ===");

        // Select bread tpye
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



        //create the sanwich based off of above input
        Sandwich sandwich = new Sandwich(size, breadType);

        // Add toppings
        addToppingsToSandwich(sandwich);

        // prompt for toasted or not
        boolean toasted = Console.promptForYesNo("Would you like the sandwich toasted?");
        sandwich.setToasted(toasted);

        // Add to order
        currentOrder.addSandwich(sandwich);
        System.out.println("\nSandwich added to order!");
        System.out.println(sandwich.getDescription());
    }

    // customize signature sandwich, ability to add or remove-------------------------------------------------------
    private static void customizeSignatureSandwich(Sandwich sandwich) {
        System.out.println("\n=== CUSTOMIZE SIGNATURE SANDWICH ===");

        boolean customizing = true;
        while (customizing) {
            System.out.println("\nCurrent sandwich: " + sandwich.getDetailedDescription());
            System.out.println("\nCustomization Options:");
            System.out.println("1) Add more toppings");
            System.out.println("2) Remove existing toppings");
            System.out.println("3) Change bread type");
            System.out.println("4) Change sandwich size");
            System.out.println("0) Done customizing");

            int choice = Console.promptForChoice("Choose customization option: ", 4);

            switch (choice) {
                case 1:
                    addToppingsToSandwich(sandwich);
                    break;
                case 2:
                    removeToppingsFromSandwich(sandwich);
                    break;
                case 3:
                    changeBreadType(sandwich);
                    break;
                case 4:
                    changeSandwichSize(sandwich);
                    break;
                case 0:
                    customizing = false;
                    System.out.println("Customization complete!");
                    break;
            }
        }
    }

    // Remove topping---------------------------
    private static void removeToppingsFromSandwich(Sandwich sandwich) {
        System.out.println("\n=== REMOVE TOPPINGS ===");

        boolean removing = true;
        while (removing) {
            System.out.println("\nWhat would you like to remove?");
            System.out.println("1) Remove meat");
            System.out.println("2) Remove cheese");
            System.out.println("3) Remove vegetables/toppings");
            System.out.println("4) Remove sauces");
            System.out.println("0) Done removing");

            int choice = Console.promptForChoice("Choose what to remove: ", 4);

            switch (choice) {
                case 1:
                    removeMeats(sandwich);
                    break;
                case 2:
                    removeCheeses(sandwich);
                    break;
                case 3:
                    removeRegularToppings(sandwich);
                    break;
                case 4:
                    removeSauces(sandwich);
                    break;
                case 0:
                    removing = false;
                    break;
            }
        }
    }

    // Remove meats--------------------------------------
    private static void removeMeats(Sandwich sandwich) {
        if (sandwich.getMeats().isEmpty() && sandwich.getExtraMeats().isEmpty()) {
            System.out.println("No meats to remove.");
            return;
        }

        System.out.println("\nCurrent meats:");

        for (int i = 0; i < sandwich.getMeats().size(); i++) {
            System.out.println((i + 1) + ") " + sandwich.getMeats().get(i).getDisplay());
        }

        // extra meat
        for (int i = 0; i < sandwich.getExtraMeats().size(); i++) {
            System.out.println((sandwich.getMeats().size() + i + 1) + ") Extra " +
                    sandwich.getExtraMeats().get(i).getDisplay());
        }

        System.out.println("0) Back");

        int totalMeats = sandwich.getMeats().size() + sandwich.getExtraMeats().size();
        int choice = Console.promptForChoice("Choose meat to remove: ", totalMeats);

        if (choice > 0) {
            if (choice <= sandwich.getMeats().size()) {
                // Remove regular meat
                Meat meatToRemove = sandwich.getMeats().get(choice - 1);
                sandwich.removeMeat(meatToRemove);
                System.out.println(meatToRemove.getDisplay() + " removed!");
            } else {
                // Remove extra meat
                int extraIndex = choice - sandwich.getMeats().size() - 1;
                Meat extraMeatToRemove = sandwich.getExtraMeats().get(extraIndex);
                sandwich.removeExtraMeat(extraMeatToRemove);
                System.out.println("Extra " + extraMeatToRemove.getDisplay() + " removed!");
            }
        }
    }

    // Remove Cheese
    private static void removeCheeses(Sandwich sandwich) {
        if (sandwich.getCheeses().isEmpty() && sandwich.getExtraCheeses().isEmpty()) {
            System.out.println("No cheese to remove.");
            return;
        }

        System.out.println("\nCurrent cheeses:");

        // Show regular cheeses
        for (int i = 0; i < sandwich.getCheeses().size(); i++) {
            System.out.println((i + 1) + ") " + sandwich.getCheeses().get(i).getDisplay());
        }

        // Show extra cheeses
        for (int i = 0; i < sandwich.getExtraCheeses().size(); i++) {
            System.out.println((sandwich.getCheeses().size() + i + 1) + ") Extra " +
                    sandwich.getExtraCheeses().get(i).getDisplay());
        }

        System.out.println("0) Back");

        int totalCheeses = sandwich.getCheeses().size() + sandwich.getExtraCheeses().size();
        int choice = Console.promptForChoice("Choose cheese to remove: ", totalCheeses);

        if (choice > 0) {
            if (choice <= sandwich.getCheeses().size()) {
                // Remove regular cheese
                Cheese cheeseToRemove = sandwich.getCheeses().get(choice - 1);
                sandwich.removeCheese(cheeseToRemove);
                System.out.println(cheeseToRemove.getDisplay() + " removed!");
            } else {
                // Remove extra cheese
                int extraIndex = choice - sandwich.getCheeses().size() - 1;
                Cheese extraCheeseToRemove = sandwich.getExtraCheeses().get(extraIndex);
                sandwich.removeExtraCheese(extraCheeseToRemove);
                System.out.println("Extra " + extraCheeseToRemove.getDisplay() + " removed!");
            }
        }
    }

    // Remove regular topping
    private static void removeRegularToppings(Sandwich sandwich) {
        if (sandwich.getRegularToppings().isEmpty()) {
            System.out.println("No vegetables/toppings to remove.");
            return;
        }

        System.out.println("\nCurrent vegetables/toppings:");
        for (int i = 0; i < sandwich.getRegularToppings().size(); i++) {
            System.out.println((i + 1) + ") " + sandwich.getRegularToppings().get(i).getDisplay());
        }
        System.out.println("0) Back");

        int choice = Console.promptForChoice("Choose topping to remove: ", sandwich.getRegularToppings().size());

        if (choice > 0) {
            RegularTopping toppingToRemove = sandwich.getRegularToppings().get(choice - 1);
            sandwich.removeRegularTopping(toppingToRemove);
            System.out.println(toppingToRemove.getDisplay() + " removed!");
        }
    }

    // Remove Sauce
    private static void removeSauces(Sandwich sandwich) {
        if (sandwich.getSauces().isEmpty()) {
            System.out.println("No sauces to remove.");
            return;
        }

        System.out.println("\nCurrent sauces:");
        for (int i = 0; i < sandwich.getSauces().size(); i++) {
            System.out.println((i + 1) + ") " + sandwich.getSauces().get(i).getDisplay());
        }
        System.out.println("0) Back");

        int choice = Console.promptForChoice("Choose sauce to remove: ", sandwich.getSauces().size());

        if (choice > 0) {
            Sauce sauceToRemove = sandwich.getSauces().get(choice - 1);
            sandwich.removeSauce(sauceToRemove);
            System.out.println(sauceToRemove.getDisplay() + " removed!");
        }
    }

    // Change bread
    private static void changeBreadType(Sandwich sandwich) {
        System.out.println("\nSelect new bread type:");
        BreadType[] breads = BreadType.values();
        for (int i = 0; i < breads.length; i++) {
            System.out.println((i + 1) + ") " + breads[i].getDisplay());
        }
        System.out.println("0) Keep current bread");

        int choice = Console.promptForChoice("Choose new bread: ", breads.length);
        if (choice > 0) {
            BreadType newBread = breads[choice - 1];
            sandwich.setBreadType(newBread);
            System.out.println("Bread changed to " + newBread.getDisplay());
        }
    }

    // Change size
    private static void changeSandwichSize(Sandwich sandwich) {
        System.out.println("\nSelect new sandwich size:");
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i].getDisplay());
        }
        System.out.println("0) Keep current size");

        int choice = Console.promptForChoice("Choose new size: ", sizes.length);
        if (choice > 0) {
            SandwichSize newSize = sizes[choice - 1];
            sandwich.setSize(newSize);
            System.out.println("Size changed to " + newSize.getDisplay());
        }
    }

    // Add toppings
    private static void addToppingsToSandwich(Sandwich sandwich) {
        System.out.println("\n=== ADD TOPPINGS ===");

        // Add meats
        System.out.println("Would you like to add meat?");
        if (Console.promptForYesNo("Add meat?")) {
            System.out.println("Select meat:");
            Meat[] meats = Meat.values();
            for (int i = 0; i < meats.length; i++) {
                System.out.println((i + 1) + ") " + meats[i].getDisplay());
            }

            int meatChoice = Console.promptForChoice("Choose meat: ", meats.length);
            if (meatChoice > 0) {
                Meat meat = meats[meatChoice - 1];
                sandwich.addMeat(meat);

                // Prompt if they would like extra meat
                if (Console.promptForYesNo("Would you like extra meat?")) {
                    sandwich.addExtraMeat(meat);
                }
            }
        }

        // Add cheese
        if (Console.promptForYesNo("Add cheese?")) {
            System.out.println("Select cheese:");
            Cheese[] cheeses = Cheese.values();
            for (int i = 0; i < cheeses.length; i++) {
                System.out.println((i + 1) + ") " + cheeses[i].getDisplay());
            }

            int cheeseChoice = Console.promptForChoice("Choose cheese: ", cheeses.length);
            if (cheeseChoice > 0) {
                Cheese cheese = cheeses[cheeseChoice - 1];
                sandwich.addCheese(cheese);

                // Ask for extra cheese
                if (Console.promptForYesNo("Would you like extra cheese?")) {
                    sandwich.addExtraCheese(cheese);
                }
            }
        }

        // Add regular toppings
        if (Console.promptForYesNo("Add vegetables/toppings?")) {
            System.out.println("Select toppings (you can add multiple):");
            RegularTopping[] toppings = RegularTopping.values();

            boolean addingToppings = true;
            while (addingToppings) {
                for (int i = 0; i < toppings.length; i++) {
                    System.out.println((i + 1) + ") " + toppings[i].getDisplay());
                }
                System.out.println("0) Done adding toppings");

                int toppingChoice = Console.promptForChoice("Choose topping (0 when done): ", toppings.length);
                if (toppingChoice == 0) {
                    addingToppings = false;
                } else {
                    RegularTopping topping = toppings[toppingChoice - 1];
                    sandwich.addRegularTopping(topping);
                    System.out.println(topping.getDisplay() + " added!");
                }
            }
        }

        // Add sauces
        if (Console.promptForYesNo("Add sauces?")) {
            System.out.println("Select sauces (you can add multiple):");
            Sauce[] sauces = Sauce.values();

            boolean addingSauces = true;
            while (addingSauces) {
                for (int i = 0; i < sauces.length; i++) {
                    System.out.println((i + 1) + ") " + sauces[i].getDisplay());
                }
                System.out.println("0) Done adding sauces");

                int sauceChoice = Console.promptForChoice("Choose sauce (0 when done): ", sauces.length);
                if (sauceChoice == 0) {
                    addingSauces = false;
                } else {
                    Sauce sauce = sauces[sauceChoice - 1];
                    sandwich.addSauce(sauce);
                    System.out.println(sauce.getDisplay() + " added!");
                }
            }
        }
    }

    // Add drink
    private static void addDrink() {
        System.out.println("\n=== ADD DRINK ===");

        // Select size
        System.out.println("Select drink size:");
        DrinkSize[] sizes = DrinkSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i].getDisplay());
        }
        System.out.println("0) Back to order menu");

        int sizeChoice = Console.promptForChoice("Choose size: ", sizes.length);
        if (sizeChoice == 0) return;
        DrinkSize size = sizes[sizeChoice - 1];

        // Select flavor
        System.out.println("\nSelect drink flavor:");
        DrinkType[] flavors = DrinkType.values();
        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i].getDisplay());
        }
        System.out.println("0) Back to order menu");

        int flavorChoice = Console.promptForChoice("Choose flavor: ", flavors.length);
        if (flavorChoice == 0) return;
        DrinkType flavor = flavors[flavorChoice - 1];

        // Create and add drink
        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);
        System.out.println("\nDrink added to order!");
        System.out.println(drink.getDescription());
    }

    // Add chips
    private static void addChips() {
        System.out.println("\n=== ADD CHIPS ===");

        // Select chips type
        System.out.println("Select chips type:");
        Chips[] types = Chips.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") " + types[i].getDisplay());
        }
        System.out.println("0) Back to order menu");

        int typeChoice = Console.promptForChoice("Choose chips type: ", types.length);
        if (typeChoice == 0) return;
        Chips chipsType = types[typeChoice - 1];

        currentOrder.addChips(chipsType);
        System.out.println("\nChips added to order!");
        System.out.println(chipsType.getDescription());
    }

    // view current order
    private static void viewCurrentOrder() {
        System.out.println("\n=== CURRENT ORDER ===");
        System.out.println(currentOrder.getDetailedReceipt());
    }


    // Checkout
    private static void checkout() {


        for (int i = 0; i < currentOrder.getSandwiches().size(); i++) {
            Sandwich sandwich = currentOrder.getSandwiches().get(i);
            System.out.println((i + 1) + ". " + sandwich.getDetailedDescription());
            System.out.println("   Price: $" + String.format("%.2f", sandwich.getPrice()));
            System.out.println();
        }

        for (int i = 0; i < currentOrder.getDrinks().size(); i++) {
            Drink drink = currentOrder.getDrinks().get(i);
            System.out.println((i + 1) + ". " + drink.getDescription());
            System.out.println("   Price: $" + String.format("%.2f", drink.getPrice()));
            System.out.println();
        }

        for (int i = 0; i < currentOrder.getChips().size(); i++) {
            Chips chips = currentOrder.getChips().get(i);
            System.out.println((i + 1) + ". " + chips.getDescription());
            System.out.println("   Price: $" + String.format("%.2f", chips.getPrice()));
            System.out.println();
        }

        System.out.println("==========================================");
        System.out.println("TOTAL: $" + String.format("%.2f", currentOrder.getTotalPrice()));
        System.out.println("==========================================");

        boolean confirm = Console.promptForYesNo("Confirm order?");

        if (confirm) {
            // Save receipt to file
            String receiptFile = ReceiptManager.saveReceipt(currentOrder);

            if (receiptFile != null) {
                System.out.println("\nReceipt created! Thank you for choosing Stack House!");
            } else {
                System.out.println("\nOrder completed, but receipt could not be saved.");
            }

            // Reset for next customer
            currentOrder = null;
        } else {
            System.out.println("Order cancelled.");
            currentOrder = null;
        }
    }

    // Cancel order
    private static void cancelOrder() {
        System.out.println("\nOrder cancelled.");
        currentOrder = null;
    }
}