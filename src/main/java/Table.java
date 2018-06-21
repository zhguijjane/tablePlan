import java.util.*;
import java.util.stream.Collectors;

public class Table {

    public static Map<MainMeal, Integer> order(Order order) {

        List<Order> orders = Collections.singletonList(order);

        return orders.stream().collect(Collectors.groupingBy(Order::getMainMealChoice, Collectors.summingInt(x -> 1)));
    }

    public static Map<MainMeal, Integer> order(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::getMainMealChoice, Collectors.summingInt(x -> 1)));
    }
}
