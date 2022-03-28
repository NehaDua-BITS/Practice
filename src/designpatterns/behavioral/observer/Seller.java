package designpatterns.behavioral.observer;

public class Seller implements Observer {

    private String location;

    @Override
    public void updateLocation(String location) {
        this.location = location;
        showNotification();
    }

    public void showNotification() {
        System.out.println("Seller Notification: Updated location => " + location);
    }
}
