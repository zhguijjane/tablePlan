package planning;

import lombok.Value;

@Value
class Order {
    private final StarterMeal starterMeal;
    private final MainMeal mainMealChoice;
    private final DessertMeal dessert;

    public Order(StarterMeal starterMeal, MainMeal mainMealChoice, DessertMeal dessert) {
        this.starterMeal = starterMeal;
        this.mainMealChoice = mainMealChoice;
        this.dessert = dessert;
    }
}
