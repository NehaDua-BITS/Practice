package designpatterns.creational.singleton;

public class SingletonThreadSafeBlock {
    private static SingletonThreadSafeBlock instance;

    private SingletonThreadSafeBlock() {}

    public static SingletonThreadSafeBlock getInstance() {
        if (instance == null) { //no lock on read
            synchronized (SingletonThreadSafeBlock.class) { //lock only on write
                if (instance == null) {
                    instance = new SingletonThreadSafeBlock();
                }
            }
        }
        return instance;
    }
}
