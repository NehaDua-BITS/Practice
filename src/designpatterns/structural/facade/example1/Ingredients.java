package designpatterns.structural.facade.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ingredients {

    public List<String> getPizzaIngredients() {
        return new ArrayList<>(Arrays.asList("dough", "cheese", "tomato", "sauce", "herbs", "olive oil"));
    }

    public List<String> getPastaIngredients() {
        return new ArrayList<>(Arrays.asList("pasta", "cheese", "veggies", "sauce", "olive oil"));
    }

}
