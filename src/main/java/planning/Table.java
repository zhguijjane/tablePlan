package planning;

import lombok.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Value
public class Table {

    private static final int MAX_ORDER_PER_TABLE = 10;
    private List<Order> orders;

    public Map<MainMeal, Integer> countMainMeals() {

        if (orders.size() > MAX_ORDER_PER_TABLE) {
            throw new IllegalArgumentException("You cannot have more than 10 orders for 1 table.");
        }

        return orders.stream().collect(Collectors.groupingBy(Order::getMainMealChoice, Collectors.summingInt(x -> 1)));
    }

}
