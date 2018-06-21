import org.junit.Test;

import java.util.HashMap;

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
}