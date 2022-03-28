package designpatterns.structural.facade.example1;

public class WaiterFacade {

    public String deliverFood(FoodType foodType) {
        String food;
        Ingredients ingredients = new Ingredients();
        switch (foodType) {
            case PASTA:
                Pasta pasta = new Pasta();
                pasta.prepareFood(ingredients.getPastaIngredients());
                food = pasta.deliverFood();
                break;

            case PIZZA:
                Pizza pizza = new Pizza();
                pizza.prepareFood(ingredients.getPizzaIngredients());
                food = pizza.deliverFood();
                break;

            default:
                food = "Invalid food";
        }

        return food;
    }

}
