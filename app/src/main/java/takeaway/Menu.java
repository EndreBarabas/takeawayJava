package takeaway;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    // String[] dishName = {"Pizza", "Burger", "Pasta", "Steak"};
    // Integer[] dishPrice = {10.99,8.99,12.49,14.39};
    Map<String, Integer> dishes = new HashMap<String, Integer>();
    Map<String, Integer> drinks = new HashMap<String, Integer>();
     public Menu(){
        dishes.put("Pizza", 10);
        dishes.put("Pasta", 11);
        dishes.put("Burger", 9);
        dishes.put("Steak", 13);
        dishes.put("Meatballs", 10);
        dishes.put("Fish", 10);
        dishes.put("Rice", 4);
        dishes.put("Fries", 4);
     }

    public Map<String, Integer> list(){
        return dishes;
    }
}
