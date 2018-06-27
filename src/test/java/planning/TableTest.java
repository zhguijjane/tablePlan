package planning;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class TableTest {


    @Test
    public void should_return_1_meat_and_0_fish() {
        Order firstOrder = new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN);
        List<Order> orders = Collections.singletonList(firstOrder);
        Table table = new Table(orders);


        Map<MainMeal, Integer> actualMainMeals = table.countMainMeals();


        Map<MainMeal, Integer> expectedMainMeals = new HashMap<>();
        expectedMainMeals.put(MainMeal.MEAT, 1);
        assertThat(actualMainMeals).isEqualTo(expectedMainMeals);
    }

    @Test
    public void should_return_1_meat_and_1_fish() {
        Order firstOrder = new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN);
        Order secondOrder = new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN);
        List<Order> orders = Arrays.asList(firstOrder, secondOrder);
        Table table = new Table(orders);


        Map<MainMeal, Integer> actualMainMeals = table.countMainMeals();


        Map<MainMeal, Integer> expectedMainMeals = new HashMap<>();
        expectedMainMeals.put(MainMeal.MEAT, 1);
        expectedMainMeals.put(MainMeal.FISH, 1);
        assertThat(actualMainMeals).isEqualTo(expectedMainMeals);
    }

    @Test
    public void should_return_3_meat_and_7_fish() {
        List<Order> orders = new ArrayList<>();
        Collections.addAll(orders, new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN));
        Table table = new Table(orders);


        Map<MainMeal, Integer> actualMainMeals = table.countMainMeals();


        Map<MainMeal, Integer> expectedMainMeals = new HashMap<>();
        expectedMainMeals.put(MainMeal.MEAT, 3);
        expectedMainMeals.put(MainMeal.FISH, 7);
        assertThat(actualMainMeals).isEqualTo(expectedMainMeals);
    }

    @Test
    public void should_return_exception_for_more_than_10_orders_per_table() {
        List<Order> orders = new ArrayList<>();
        Collections.addAll(orders,
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.FISH, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN),
                new Order(StarterMeal.SALAD, MainMeal.MEAT, DessertMeal.FLAN));
        Table table = new Table(orders);


        assertThatThrownBy(table::countMainMeals)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You cannot have more than 10 orders for 1 table.");
    }

    @Test
    public void should_return_no_meal_for_no_order() {
        List<Order> orders = Collections.emptyList();
        Table table = new Table(orders);


        Map<MainMeal, Integer> actualMainMeals = table.countMainMeals();


        Map<Object, Object> expectedMainMeals = Collections.emptyMap();
        assertThat(actualMainMeals).isEqualTo(expectedMainMeals);
    }
}