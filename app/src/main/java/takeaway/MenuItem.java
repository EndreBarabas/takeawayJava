package takeaway;

import java.util.Objects;

/**
 * Simple data class to represent a menu item, contains an integer ID,  a String name
 * and the price of the item.
 *
 * This is an immutable class, once it is created its content (itemId, itemName, price)
 * cannot be modified. This is generally a good practice to avoid concurrency and other issues.
 */
public class MenuItem {
    private final int itemId;
    private final String itemName;
    private final int price;

    // We maintain a static counter so the item ID is always automatically generated so
    // the caller does not have to provide it.
    private static int currentId = 0;

    public MenuItem(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
        this.itemId = ++currentId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return itemId == menuItem.itemId && Objects.equals(itemName, menuItem.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName);
    }
}
