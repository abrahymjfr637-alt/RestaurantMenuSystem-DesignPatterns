# Restaurant Menu System

## Case 2 – Composite & Flyweight Design Patterns

This project is a simple Restaurant Menu System implemented in Java.

The project applies two design patterns:

1. Composite Pattern
2. Flyweight Pattern

---

## Project Idea

Restaurants usually have menus that contain many categories and items.

For example:

- Shawarma
- Broasted
- Drinks

Each category contains menu items, and some item information may be repeated many times.

This project solves the problem by organizing the menu using Composite Pattern and reducing duplicated item data using Flyweight Pattern.

---

## Composite Pattern

The Composite Pattern is used to organize the restaurant menu as a tree structure.

In this project:

- `MenuComponent` is the common interface.
- `MenuCategory` is the composite class.
- `MenuItem` is the leaf class.

This allows categories and items to be treated in the same way.

---

## Flyweight Pattern

The Flyweight Pattern is used to reduce memory usage by sharing repeated item information.

In this project:

- `MenuItemFlyweight` stores shared data such as name, description, and image path.
- `MenuItemFactory` creates and reuses shared objects.
- `MenuItem` stores unique data such as price.

---

## Files

- `Main.java`

The project code is written in one Java file for simple online execution and testing.

---

## How to Run

1. Open `Main.java` in any Java IDE or online Java compiler.
2. Run the `Main` class.
3. The program will display:
   - Restaurant menu
   - Menu categories
   - Menu items
   - Total menu price
   - Number of shared Flyweight objects

---

## Expected Output

The program displays a restaurant menu with categories such as Shawarma, Broasted, and Drinks.

It also calculates the total price and shows the number of shared Flyweight objects.

---

## My Role

My role in this project was:

**Code Implementation and GitHub Management**

I completed the following tasks:

- Implemented Composite Pattern.
- Implemented Flyweight Pattern.
- Created the Java demo code.
- Tested the code using an online Java compiler.
- Created the GitHub repository.
- Uploaded the source code.
- Managed the GitHub project files.

---

## Design Patterns Used

### Composite Pattern

Used for menu structure.

### Flyweight Pattern

Used for sharing repeated menu item data.

---

## Author

Ibrahim Al-Dawaymeh
