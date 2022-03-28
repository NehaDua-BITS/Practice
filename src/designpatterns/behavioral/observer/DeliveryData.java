package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class DeliveryData implements Subject {

    private String location;

    private List<Observer> observerList;

    public DeliveryData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.updateLocation(location);
        }
    }

    public void updateLocation(String location) {
        this.location = location;
        notifyObservers();
    }
}
