package takeaway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class OrderBuilderTest {

    private static final MenuItem DUMMY_ITEM = new MenuItem("Item", 100);
    private static final MenuItem DUMMY_ITEM2 = new MenuItem("Item2", 111);

    @Test
    public void testItemCanBeAddedToOrder() {
        OrderBuilder ob = new OrderBuilder();
        ob.addItem(DUMMY_ITEM);

        List<MenuItem> currentOrder = ob.currentOrder();

        assertEquals(1, currentOrder.size());
    }

    @Test
    public void testOrderSummaryCalculatedProperly() {
        OrderBuilder ob = new OrderBuilder();
        ob.addItem(DUMMY_ITEM);
        ob.addItem(DUMMY_ITEM2);

        List<MenuItem> currentOrder = ob.currentOrder();

        assertEquals(2, currentOrder.size());
        assertEquals(211, ob.summarizeOrderAmount());
    }
}
