package designpatterns.creational.singleton;

public class SingletonThreadSafeMethod {

    private static SingletonThreadSafeMethod instance;

    private SingletonThreadSafeMethod() {}

    public synchronized static SingletonThreadSafeMethod getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafeMethod();
        }
        return instance;
    }

}
