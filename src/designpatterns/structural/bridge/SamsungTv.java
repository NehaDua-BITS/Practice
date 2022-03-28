package designpatterns.structural.bridge;

public class SamsungTv extends TV {

    private Remote remote;

    public SamsungTv(Remote remote) {
        super(remote);
        this.remote = remote;
    }

    @Override
    public void on() {
        remote.on();
        System.out.println("Samsung TV On");
    }

    @Override
    public void off() {
        remote.off();
        System.out.println("Samsung TV Off");
    }
}
