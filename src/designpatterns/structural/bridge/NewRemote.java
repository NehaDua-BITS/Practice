package designpatterns.structural.bridge;

public class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.print("New Remote On : ");
    }

    @Override
    public void off() {
        System.out.print("New Remote Off : ");
    }
}
