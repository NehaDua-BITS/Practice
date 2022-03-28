package designpatterns.structural.facade.example1;

import java.util.Arrays;
import java.util.List;

public class Pizza implements Food {

    private String food;

    @Override
    public void prepareFood(List<String> ingredients) {
        food = "Prepared Pizza using ingredients - " + Arrays.toString(ingredients.toArray());
    }

    @Override
    public String deliverFood() {
        return food;
    }
}
