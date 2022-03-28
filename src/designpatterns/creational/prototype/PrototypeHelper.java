package designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Creational design pattern
 * Used when there is need to create multiple copies of same object
 * which are then modified independently
 * Avoids creating new instances of same object
 * Uses clone method for deep copy
 */
public class PrototypeHelper {

    public static void main(String[] args) {
        //Menu for breakfast
        Menu breakfastMenu = new Menu("buffet", "Karims");
        breakfastMenu.setBeverages(new ArrayList<>(Arrays.asList("coffee", "tea", "latte", "lime soda")));
        breakfastMenu.setFood(new ArrayList<>(Arrays.asList("Toast", "Omlette", "Pancake", "Stuffed Bread")));
        System.out.println("Breakfast Menu : " + breakfastMenu);

        //created copy of existing object using clone()
        Menu lunchMenu = breakfastMenu.clone();
        System.out.println("Initial lunch menu : " + lunchMenu);
        lunchMenu.setFood(new ArrayList<>(Arrays.asList("Pasta", "Pizza", "Cake", "Omlette")));
        //modifying copy object shouldn't modify source object
        lunchMenu.getBeverages().add("hot chocolate");
        lunchMenu.getBeverages().remove("latte");
        System.out.println("\nFinal lunch menu : " + lunchMenu);
        System.out.println("Final Breakfast Menu : " + breakfastMenu);
    }

}
