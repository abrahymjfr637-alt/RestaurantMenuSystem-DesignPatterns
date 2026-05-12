import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface MenuComponent {
    void display(String indent);
    double getPrice();
}

class MenuCategory implements MenuComponent {
    private String name;
    private List<MenuComponent> components;

    public MenuCategory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void add(MenuComponent component) {
        components.add(component);
    }

    public void remove(MenuComponent component) {
        components.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "[Category] " + name);

        for (MenuComponent component : components) {
            component.display(indent + "   ");
        }
    }

    @Override
    public double getPrice() {
        double total = 0;

        for (MenuComponent component : components) {
            total += component.getPrice();
        }

        return total;
    }
}

class MenuItemFlyweight {
    private String name;
    private String description;
    private String imagePath;

    public MenuItemFlyweight(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
}

class MenuItemFactory {
    private static Map<String, MenuItemFlyweight> items = new HashMap<>();

    public static MenuItemFlyweight getMenuItem(String name, String description, String imagePath) {
        String key = name + "-" + description + "-" + imagePath;

        if (!items.containsKey(key)) {
            items.put(key, new MenuItemFlyweight(name, description, imagePath));
            System.out.println("Creating new shared item: " + name);
        } else {
            System.out.println("Reusing existing shared item: " + name);
        }

        return items.get(key);
    }

    public static int getTotalFlyweights() {
        return items.size();
    }
}

class MenuItem implements MenuComponent {
    private MenuItemFlyweight flyweight;
    private double price;

    public MenuItem(MenuItemFlyweight flyweight, double price) {
        this.flyweight = flyweight;
        this.price = price;
    }

    @Override
    public void display(String indent) {
        System.out.println(
                indent +
                "- Item: " + flyweight.getName() +
                " | Description: " + flyweight.getDescription() +
                " | Price: " + price + " JD" +
                " | Image: " + flyweight.getImagePath()
        );
    }

    @Override
    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        MenuCategory mainMenu = new MenuCategory("Restaurant Main Menu");

        MenuCategory shawarmaCategory = new MenuCategory("Shawarma");
        MenuCategory broastedCategory = new MenuCategory("Broasted");
        MenuCategory drinksCategory = new MenuCategory("Drinks");

        MenuItemFlyweight smallShawarmaInfo = MenuItemFactory.getMenuItem(
                "Small Chicken Shawarma",
                "Chicken shawarma sandwich with garlic sauce and pickles",
                "images/small_shawarma.png"
        );

        MenuItemFlyweight largeShawarmaInfo = MenuItemFactory.getMenuItem(
                "Large Chicken Shawarma",
                "Large chicken shawarma sandwich with garlic sauce and pickles",
                "images/large_shawarma.png"
        );

        MenuItemFlyweight broastedInfo = MenuItemFactory.getMenuItem(
                "Broasted Meal",
                "Crispy chicken meal with fries, garlic sauce, and pickles",
                "images/broasted.png"
        );

        MenuItemFlyweight colaInfo = MenuItemFactory.getMenuItem(
                "Cola",
                "Cold soft drink",
                "images/cola.png"
        );

        MenuItem smallShawarmaBranch1 = new MenuItem(smallShawarmaInfo, 0.60);
        MenuItem smallShawarmaBranch2 = new MenuItem(smallShawarmaInfo, 0.75);
        MenuItem largeShawarma = new MenuItem(largeShawarmaInfo, 1.20);
        MenuItem broastedMeal = new MenuItem(broastedInfo, 3.50);
        MenuItem cola = new MenuItem(colaInfo, 0.35);

        shawarmaCategory.add(smallShawarmaBranch1);
        shawarmaCategory.add(smallShawarmaBranch2);
        shawarmaCategory.add(largeShawarma);

        broastedCategory.add(broastedMeal);
        drinksCategory.add(cola);

        mainMenu.add(shawarmaCategory);
        mainMenu.add(broastedCategory);
        mainMenu.add(drinksCategory);

        System.out.println("========== Restaurant Menu ==========");
        mainMenu.display("");

        System.out.println();
  System.out.printf("Total Menu Price: %.2f JD%n", mainMenu.getPrice());
        System.out.println("Total Shared Flyweight Objects: " + MenuItemFactory.getTotalFlyweights());
    }
}
