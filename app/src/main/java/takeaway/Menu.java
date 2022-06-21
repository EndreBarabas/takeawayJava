package takeaway;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

// This class is basically a "static" class because we don't want to
// create an instance of this class just to get the menu, we can easily
// have just one single instance of the dish and drink storage throughout
// the lifecycle of the program
public class Menu {

    // It's easier to store the menu as a list rather than a map
    // This way we can associate an ID with the item and will be easier
    // to fetch it later on. List.of will create an unmodifiable list so
    // we need to wrap it in an ArrayList.
    private static final List<MenuItem> menu = new ArrayList<>(
            List.of(
                new MenuItem("Pizza", 10),
                new MenuItem("Pasta", 11),
                new MenuItem("Burger", 9),
                new MenuItem("Steak", 13),
                new MenuItem("Meatballs", 10),
                new MenuItem("Fish", 10),
                new MenuItem("Rice", 4),
                new MenuItem("Fries", 4)
            )
    );

    // It's generally a good idea to copy the collection before
    // returning to avoid manipulation of the original object
    public static List<MenuItem> getMenu() {
        return new ArrayList<>(menu);
    }

    public static MenuItem getMenuItemById(int index) {
        return menu.stream()
                .filter(e -> e.getItemId() == index)
                .findFirst()
                .orElse(null);

        /*
        Without Java 8 streams:
        for (MenuItem item : menu) {
            if (item.getItemId() == index)
                return item;
        }
        return null;
        */
    }

    public static MenuItem getMenuItemByName(String name) {
        return menu.stream()
                .filter(e -> e.getItemName().equals(name))
                .findFirst()
                .orElse(null);
        /*
        for (MenuItem item : menu) {
            if (item.getItemName().equals(name))
                return item;
        }
        return null;
         */
    }

    public static void addMenuItem(String itemName, int price) {
        validateAndStoreItem(itemName, price);
    }

    public static boolean removeMenuItem(String itemName) {
        return menu.removeIf(e -> e.getItemName().equals(itemName));
    }

    // Since both drink and dish adding is very similar we can hide the logic
    // behind a common private function that we can use for both functionality
    private static void validateAndStoreItem(String itemName, int price) {

        /* // Do we want to allow replacing existing items?
        if (storage.containsKey(itemName)) {
            throw new IllegalArgumentException("This item is already on the menu.");
        }
        */

        if (StringUtils.isBlank(itemName)) {
            throw new IllegalArgumentException("Cannot store item if it's empty or null.");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative.");
        }

        if (menu.stream().anyMatch(e -> e.getItemName().equals(itemName))) {
            throw new IllegalArgumentException(
                    "Item with name " + itemName + " is already on the menu."
            );
        }

        menu.add(new MenuItem(itemName, price));
    }
}
