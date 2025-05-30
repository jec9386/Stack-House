# Stack House - Sandwich Ordering System

A Java console application that simulates a sandwich shop's- point-of-sale system. Customers can build custom sandwiches with multiple toppings, select chips and drinks, and receive detailed receipts with calculated totals.

## Table of Contents
- [Features](#features)
- [System Architecture](#system-architecture)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Development Process](#development-process)
- [Code Structure](#code-structure)


## Features

### Sandwich Customization
- **3 sizes:** 4", 8", 12" with size-based pricing
- **4 bread types:** White, Wheat, Rye, Wrap
- **Premium meats:** Steak, Ham, Salami, Chicken, Bacon with size-specific pricing
- **Cheese options:** American, Provolone, Cheddar, Swiss
- **Free toppings:** Lettuce, tomatoes, onions, pickles, and more
- **Sauces:** Mayo, mustard, ketchup, ranch, and others
- **Toasted option** available

### Chips Selection
- Custom varieties: Red Hot Reaper, Takis Fuego, Doritos, and more
- Fixed pricing across all varieties

### Beverages
- **3 sizes:** Small ($2.00), Medium ($2.50), Large ($3.00)
- **drink types:** Water, fresh milk, almond milk, and more
- Size-based pricing system

### Order Management
- Add multiple items of each type
- Remove items from order
- Real-time price calculations
- Detailed receipt generation
- Order summary and breakdown by category

### Interactive Interface
- Menu-driven command-line interface
- Input validation and error handling
- Step-by-step item customization
- Professional receipt formatting

## Structure

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Sandwich      │    │     Chips       │    │     Drink       │
│   System        │    │    System       │    │    System       │
│                 │    │                 │    │                 │
│ • SandwichSize  │    │ • Chips enum    │    │ • DrinkSize     │
│ • BreadType     │    │ • Fixed pricing │    │ • DrinkType     │
│ • Meat enum     │    │                 │    │ • Drink class   │
│ • Cheese enum   │    │                 │    │                 │
│ • Toppings      │    │                 │    │                 │
│ • Sandwich class│    │                 │    │                 │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                    ┌─────────────────┐
                    │ CompleteOrder   │
                    │    System       │
                    │                 │
                    │ • Order manage  │
                    │ • Price calc    │
                    │ • Receipt gen   │
                    └─────────────────┘
                                 │
                    ┌─────────────────┐
                    │   DeliApp       │
                    │ User Interface  │
                    │                 │
                    │ • Menu system   │
                    │ • Input validation│
                    │ • User interaction│
                    └─────────────────┘
```

## Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)




## Creating an Order

![Order Creation](images/Screenshot%202025-05-30%20060852.png)

### 1. Start New Order
Enter customer name to begin the ordering process.

![Sandwich Building](images/Screenshot%202025-05-30%20060956.png)

### 2. Build Sandwich
Choose size, bread, and toppings with guided prompts through our intuitive interface.

![Sandwich Building](images/Screenshot%202025-05-30%20061009.png)

![Sandwich Building](images/Screenshot%202025-05-30%20061023.png)

![Sandwich Building](images/Screenshot%202025-05-30%20061038.png)


### 3. Review Order
View detailed receipt with itemized pricing and order summary.

### 4. Checkout
Complete the order and generate receipt file.

## Sample Receipt
![Sample Receipt](images/Screenshot%202025-05-30%20061104.png)

## Development Process(DIAGRAM)
![Development Diagram](images/Screenshot%202025-05-30%20060736.png)


## Code Structure

```
src/
├── enums/
│   ├── SandwichSize.java
│   ├── BreadType.java
│   ├── Meat.java
│   ├── Cheese.java
│   ├── RegularTopping.java
│   ├── Sauce.java
│   ├── Chips.java
│   ├── DrinkSize.java
│   └── DrinkType.java
├── classes/
│   ├── Sandwich.java
│   ├── BLTSandwich.java
│   ├── PhillyCheeseSteak.java
│   ├── VeggieSandwich.java
│   ├── SignatureSandwich.java
│   ├── SignatureSandwichManager.java
│   ├── Drink.java
│   ├── Order.java
│   ├── ReceiptManager.java
│   └── Interface.java
└── ui/
    └── Interface.java
```

## Interesting piece of code

![Interesting Code](images/Screenshot%202025-05-30%20073407.png)


The most interesting aspect of this application is the **SignatureSandwich inheritance hierarchy**, which demonstrates strategic use of abstract classes and polymorphism. The `SignatureSandwich` abstract class extends the base `Sandwich` class, creating a specialized framework for predefined sandwich recipes like `BLTSandwich`, `PhillyCheeseSteak`, and `VeggieSandwich`. This inheritance structure allows each signature sandwich to automatically inherit core functionality (pricing calculations, topping management, size handling) from the parent `Sandwich` class while adding their own unique identity through `signatureName` and `description` fields.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
