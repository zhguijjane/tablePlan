import java.util.HashMap;
import java.util.Map;

public class Table {

    public static Map<String, Integer> order(Order order) {

        HashMap<String, Integer> mainMeal = new HashMap<>();

        mainMeal.put("Poisson", 0);
        mainMeal.put("Viande", 1);

        return mainMeal;
    }
}
