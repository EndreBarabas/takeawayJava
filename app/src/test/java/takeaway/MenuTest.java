package takeaway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test void testPrices() {
        Menu menu = new Menu();
        assertEquals(10, menu.dishes.get("Pizza"));
        assertEquals(9, menu.dishes.get("Burger"));
        assertEquals(11, menu.dishes.get("Pasta"));
        assertEquals(13, menu.dishes.get("Steak"));
        assertEquals(10, menu.dishes.get("Meatballs"));
        assertEquals(10, menu.dishes.get("Fish"));
        assertEquals(4, menu.dishes.get("Rice"));
        assertEquals(4, menu.dishes.get("Fries"));
    }
    @Test void testList() {
        //Menu menu = new Menu();
        //How to test hashmap?
    }
}
