package designpatterns.structural.facade.example1;

public class Customer {

    public static void main(String[] args) {
        WaiterFacade waiter = new WaiterFacade();
        System.out.println(waiter.deliverFood(FoodType.PASTA));
        System.out.println(waiter.deliverFood(FoodType.PIZZA));
        System.out.println(waiter.deliverFood(FoodType.INVALID));
    }

}
