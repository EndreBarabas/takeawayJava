package takeaway;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    // String[] dishName = {"Pizza", "Burger", "Pasta", "Steak"};
    // Integer[] dishPrice = {10.99,8.99,12.49,14.39};
    Map<String, Integer> dishes = new HashMap<String, Integer>();
     public Menu(){
        dishes.put("Pizza", 11);
        dishes.put("Pasta", 12);
        dishes.put("Burger", 8);
        dishes.put("Steak", 14);
     }

    public Map<String, Integer> list(){
        return dishes;
    }
}
