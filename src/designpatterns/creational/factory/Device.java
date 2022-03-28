package designpatterns.creational.factory;

public abstract class Device {
    protected String id;

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id;
    }
}


