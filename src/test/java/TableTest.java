import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}