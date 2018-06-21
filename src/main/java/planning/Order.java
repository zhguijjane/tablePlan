package planning;

import lombok.Value;

@Value
class Order {
    private final String salad;
    private final MainMeal mainMealChoice;
    private final String dessert;

    public Order(String salad, MainMeal mainMealChoice, String dessert) {
        this.salad = salad;
        this.mainMealChoice = mainMealChoice;
        this.dessert = dessert;
    }
}
