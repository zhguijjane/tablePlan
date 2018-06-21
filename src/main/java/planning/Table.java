package planning;

import java.util.*;
import java.util.stream.Collectors;

public class Table {

    public static Map<MainMeal, Integer> order(Order order) {
        List<Order> orders = Collections.singletonList(order);
        return orders.stream().collect(Collectors.groupingBy(Order::getMainMealChoice, Collectors.summingInt(x -> 1)));
    }

    public static Map<MainMeal, Integer> order(List<Order> orders) {

        if (orders.size() > 10) throw new IllegalArgumentException("You cannot have more than 10 orders for 1 table.");
        return orders.stream().collect(Collectors.groupingBy(Order::getMainMealChoice, Collectors.summingInt(x -> 1)));
    }
}
