package takeaway;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private List<MenuItem> chosenItems = new ArrayList<>();

    public void addItem(MenuItem item) {
        chosenItems.add(item);
    }

    public int summarizeOrderAmount() {
        return chosenItems.stream().mapToInt(MenuItem::getPrice).sum();
    }

    public List<MenuItem> currentOrder() {
        return new ArrayList<>(chosenItems);
    }
}
