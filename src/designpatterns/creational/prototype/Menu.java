package designpatterns.creational.prototype;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menu implements Cloneable {

    private String restaurantName;
    private String type;
    private List<String> beverages;
    private List<String> food;

    public Menu(String type, String restaurantName) {
        this.type = type;
        this.restaurantName = restaurantName;
    }

    @Override
    public Menu clone() {
        Menu temp = new Menu(this.type, this.restaurantName);
        temp.beverages = this.beverages.stream().collect(Collectors.toList());
        return temp;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "restaurantName='" + restaurantName + '\'' +
                ", type='" + type + '\'' +
                ", beverages=" + Arrays.toString(beverages.toArray()) +
                ", food=" + (food != null ? Arrays.toString(food.toArray()) : null) +
                '}';
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<String> beverages) {
        this.beverages = beverages;
    }

    public List<String> getFood() {
        return food;
    }

    public void setFood(List<String> food) {
        this.food = food;
    }
}
