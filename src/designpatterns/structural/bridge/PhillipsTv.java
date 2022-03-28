package designpatterns.structural.bridge;

public class PhillipsTv extends TV {

    private Remote remote;

    public PhillipsTv(Remote remote) {
        super(remote);
        this.remote = remote;
    }

    @Override
    public void on() {
        remote.on();
        System.out.println("Phillips TV On");
    }

    @Override
    public void off() {
        remote.off();
        System.out.println("Phillips TV Off");
    }
}
