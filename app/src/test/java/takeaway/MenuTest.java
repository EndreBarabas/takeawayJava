package takeaway;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    @Test
    void testMenuIsCreatedWithTheCorrectAmountOfInitialElements() {
        List<MenuItem> menu = Menu.getMenu();

        assertEquals(8, menu.size());

        MenuItem item = menu.get(0);

        assertNotNull(item);
        assertNotNull(item.getItemName());
    }

    @Test
    void testMenuCanBeSearchedByName() {
        MenuItem pizza = Menu.getMenuItemByName("Pizza");

        assertNotNull(pizza);
        assertEquals(1, pizza.getItemId());
        assertEquals(10, pizza.getPrice());
    }

    @Test
    void testMenuSearchReturnsNullForNonExistingItem() {
        MenuItem item = Menu.getMenuItemByName("NONEXISTING");
        MenuItem itemById = Menu.getMenuItemById(1000000000);

        assertNull(item);
        assertNull(itemById);
    }

    @Test
    void testMenuCanBeSearchedById() {
        MenuItem pizza = Menu.getMenuItemById(1);

        assertNotNull(pizza);
        assertEquals(1, pizza.getItemId());
        assertEquals(10, pizza.getPrice());
        assertEquals("Pizza", pizza.getItemName());
    }

    @Test
    void testValidItemCanBeAddedToAndRemovedFromMenu() {

        // Add new item
        Menu.addMenuItem("NewItem", 100);

        // Check it was actually added
        List<MenuItem> newMenu = Menu.getMenu();
        assertEquals(9, newMenu.size());

        // check if removal returned true
        assertTrue(Menu.removeMenuItem("NewItem"));

        // check if it was actually removed
        List<MenuItem> oldMenu = Menu.getMenu();
        assertEquals(8, oldMenu.size());
    }

    @Test
    void testAlreadyExistingItemCannotBeAddedToMenu() {
        assertThrows(IllegalArgumentException.class, () -> Menu.addMenuItem("Pizza", 100));
    }

    @Test
    void testNullOrEmptyNamedItemCannotBeAddedToMenu() {
        assertThrows(IllegalArgumentException.class, () -> Menu.addMenuItem("", 100));
        assertThrows(IllegalArgumentException.class, () -> Menu.addMenuItem("    ", 100));
        assertThrows(IllegalArgumentException.class, () -> Menu.addMenuItem(null, 100));
    }

    @Test
    void testNegativePricedItemCannotBeAddedToMenu() {
        assertThrows(IllegalArgumentException.class, () -> Menu.addMenuItem("NewItem", -10000));
    }
}
