package planning;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class TableTest {

    @Test
    public void should_return_1_meat_and_0_fish() {
        Order order = new Order("Salad", MainMeal.MEAT, "Dessert");

        HashMap<MainMeal, Integer> mainMeals = new HashMap<>();
        mainMeals.put(MainMeal.MEAT, 1);

        assertThat(Table.order(order)).isEqualTo(mainMeals);
    }

    @Test
    public void should_return_1_meat_and_1_fish() {
        Order firstOrder = new Order("Salad", MainMeal.MEAT, "Dessert");
        Order secondOrder = new Order("Salad", MainMeal.FISH, "Dessert");

        List<Order> orders = Arrays.asList(firstOrder, secondOrder);

        HashMap<MainMeal, Integer> mainMeals = new HashMap<>();
        mainMeals.put(MainMeal.MEAT, 1);
        mainMeals.put(MainMeal.FISH, 1);

        assertThat(Table.order(orders)).isEqualTo(mainMeals);
    }

    @Test
    public void should_return_3_meat_and_7_fish() {

        List<Order> orders = new ArrayList<>();
        Collections.addAll(orders, new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"));

        HashMap<MainMeal, Integer> mainMeals = new HashMap<>();
        mainMeals.put(MainMeal.MEAT, 3);
        mainMeals.put(MainMeal.FISH, 7);

        assertThat(Table.order(orders)).isEqualTo(mainMeals);
    }

    @Test
    public void should_return_exception_for_more_than_10_orders_per_table() {

        List<Order> orders = new ArrayList<>();
        Collections.addAll(orders,
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.FISH, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"),
                new Order("Salad", MainMeal.MEAT, "Dessert"));

        assertThatThrownBy(() -> {
            Table.order(orders);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You cannot have more than 10 orders for 1 table.");
    }
}