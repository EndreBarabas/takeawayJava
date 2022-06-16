package takeaway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test void testList() {
        Menu menu = new Menu();
        assertEquals(11, menu.dishes.get("Pizza"));
        assertEquals(8, menu.dishes.get("Burger"));
        assertEquals(12, menu.dishes.get("Pasta"));
        assertEquals(14, menu.dishes.get("Steak"));
    }
}
