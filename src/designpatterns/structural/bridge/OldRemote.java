package designpatterns.structural.bridge;

public class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.print("Old Remote On : ");
    }

    @Override
    public void off() {
        System.out.print("Old Remote Off : ");
    }
}
