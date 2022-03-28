package designpatterns.behavioral.observer;

public class Warehouse implements Observer {

    private String location;

    @Override
    public void updateLocation(String location) {
        this.location = location;
        showNotification();
    }

    public void showNotification() {
        System.out.println("Warehouse Notification : Updated Location => " + location);
    }
}
