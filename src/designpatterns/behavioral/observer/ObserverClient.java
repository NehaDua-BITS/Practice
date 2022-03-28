package designpatterns.behavioral.observer;

/**
 * Used when there are multiple observers/subscribers/consumers
 * of a single event/subject
 * Similar to Kafka Topic concept
 * Ex: Delivery notification system
 * Facebook notification system
 * Back in stock notification system, etc
 *
 * In this example: Seller, customer and warehouse => all are notified on
 * change in order location
 */
public class ObserverClient {

    public static void main(String[] args) {
        DeliveryData deliveryDataNotifier = new DeliveryData(); //this is equivalent to Topic
        deliveryDataNotifier.register(new Seller());
        deliveryDataNotifier.register(new Warehouse());
        deliveryDataNotifier.register(new User());

        deliveryDataNotifier.updateLocation("Delhi");
        System.out.println("\n");
        deliveryDataNotifier.updateLocation("Mumbai");
    }
}
