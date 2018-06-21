package planning;

import java.util.*;
import java.util.stream.Collectors;

class Table {

    private static final int MAX_ORDER_PER_TABLE = 10;

    public Map<MainMeal, Integer> order(List<Order> orders) {

        if (orders.size() > MAX_ORDER_PER_TABLE)
            throw new IllegalArgumentException("You cannot have more than 10 orders for 1 table.");
        return orders.stream().collect(Collectors.groupingBy(Order::getMainMealChoice, Collectors.summingInt(x -> 1)));
    }
}
