package designpatterns.creational.singleton;

public class SingletonEager {

    //eager initialization
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager() {}

    public static SingletonEager getInstance() {
        return instance;
    }

}
