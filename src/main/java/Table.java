import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    public static Map<String, Integer> order(Order order) {

        HashMap<String, Integer> mainMeal = new HashMap<>();

        mainMeal.put("Fish", 0);
        mainMeal.put("Meat", 1);

        return mainMeal;
    }

    public static Map<String, Integer> order(List<Order> orders) {

        HashMap<String, Integer> mainMeal = new HashMap<>();

        mainMeal.put("Fish", 1);
        mainMeal.put("Meat", 1);

        return mainMeal;
    }
}
