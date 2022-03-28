package designpatterns.creational.singleton;

public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy() {}

    //lazy initialization
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
