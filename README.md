# Stack House - Sandwich Ordering System

A Java console application that simulates a sandwich shop's, point-of-sale system. Customers can build custom sandwiches with multiple toppings, select chips and drinks, and receive detailed receipts with calculated totals.

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
- **Premium meats:** Steak, Ham, Chicken, Bacon with size-specific pricing
- **Cheese options:** American, Provolone, Cheddar, Swiss
- **Free toppings:** Lettuce, tomatoes, onions, pickles, and more
- **Sauces:** Mayo, mustard, ketchup, ranch, and others
- **Toasted option** available

### Chips Selection
- Custom varieties: Red Hot Reaper, Takis Fuego, Doritos, and more
- Fixed pricing across all varieties

### Beverages
- **3 sizes:** Small ($2.00), Medium ($2.50), Large ($3.00)
- **8 drink types:** Water, Pepsi, fresh milk, almond milk, and more
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


=================================
  WELCOME TO JAVA DELI EXPRESS  
=================================

========== MAIN MENU ==========
1. Start New Order
2. Add Sandwich
3. Add Chips
4. Add Drink
5. View Current Order
6. Checkout
7. Exit
===============================
```

### Creating an Order
1. **Start New Order** - Enter customer name
2. **Build Sandwich** - Choose size, bread, and toppings with guided prompts
3. **Add Chips** - Select from available varieties
4. **Add Drink** - Choose type and size
5. **Review Order** - View detailed receipt
6. **Checkout** - Complete the order

### Sample Receipt
```
=== RECEIPT FOR JOHN SMITH ===

SANDWICHES:
  1. 8" Wheat sandwich (Toasted) - $12.50

CHIPS:
  1. Takis Fuego - $1.50

DRINKS:
  1. Large Fresh Milk - $3.00

========================================
TOTAL ORDER: $17.00
```

## Development Process

1. **Foundation** - Requirements analysis and OOP design
2. **Sandwich System** - Most complex component first
3. **Simple Items** - Chips and drinks with lessons learned
4. **Order Management** - Integration of all systems
5. **User Interface** - Interactive menu and user experience
6. **Testing and Polish** - End-to-end testing and refinement

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
│   ├── Drink.java
│   └── CompleteOrder.java
├── ui/
│   └── DeliApp.java
└── tests/
    ├── SandwichTest.java
    ├── CompleteOrderTest.java
    └── DeliAppTest.java
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
