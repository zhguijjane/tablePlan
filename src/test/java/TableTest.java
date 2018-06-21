import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {

    @Test
    public void should_return_1_meat_and_0_fish() {
        Order order = new Order("Salad", "Meat", "Dessert");

        HashMap<String, Integer> mainMeals = new HashMap<>();
        mainMeals.put("Meat", 1);
        mainMeals.put("Fish", 0);

        assertThat(Table.order(order)).isEqualTo(mainMeals);
    }

    @Test
    public void should_return_1_meat_and_1_fish() {
        Order firstOrder = new Order("Salad", "Meat", "Dessert");
        Order secondOrder = new Order("Salad", "Fish", "Dessert");

        List<Order> orders = Arrays.asList(firstOrder, secondOrder);

        HashMap<String, Integer> mainMeals = new HashMap<>();
        mainMeals.put("Meat", 1);
        mainMeals.put("Fish", 1);

        assertThat(Table.order(orders)).isEqualTo(mainMeals);
    }
}