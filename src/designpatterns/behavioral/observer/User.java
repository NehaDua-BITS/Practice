package designpatterns.behavioral.observer;

public class User implements Observer {

    private String location;

    /**
     * Location update is informed via email, SMS or whatsapp
     * @param location
     */
    @Override
    public void updateLocation(String location) {
        this.location = location;
        showNotification();
    }

    public void showNotification() {
        System.out.println("User Notification : Updated Location => " + location);
    }
}
