package designpatterns.structural.bridge;

public abstract class TV {

    private Remote remote;

    public TV(Remote remote) {
        this.remote = remote;
    }

    public abstract void on();

    public abstract void off();

}
