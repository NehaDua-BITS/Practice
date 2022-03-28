package designpatterns.creational.singleton;

//Creational design pattern
public class SingletonHelper {

    public static void main(String[] args) {
        SingletonHelper helper = new SingletonHelper();
        helper.eagerInit();
        helper.lazyInit();
        helper.threadSafeMethod();
        helper.threadSafeBlock();
    }

    private void eagerInit() {
        //Eager initialization demo
        System.out.println("Eager Initialization");

        SingletonEager obj1 = SingletonEager.getInstance();
        System.out.println("1. Singleton Object = " + obj1);

        SingletonEager obj2 = SingletonEager.getInstance();
        System.out.println("2. Singleton Object = " + obj2);

        System.out.println("Are Equal = " + (obj1 == obj2));
    }

    private void lazyInit() {
        //Lazy initialization demo
        System.out.println("\nLazy Initialization");

        SingletonLazy obj1 = SingletonLazy.getInstance();
        System.out.println("1. Singleton Object = " + obj1);

        SingletonLazy obj2 = SingletonLazy.getInstance();
        System.out.println("2. Singleton Object = " + obj2);

        System.out.println("Are Equal = " + (obj1 == obj2));
    }

    private void threadSafeMethod() {
        //Thread-safe method initialization demo
        System.out.println("\nThread-Safe Method Initialization");

        SingletonThreadSafeMethod obj1 = SingletonThreadSafeMethod.getInstance();
        System.out.println("1. Singleton Object = " + obj1);

        SingletonThreadSafeMethod obj2 = SingletonThreadSafeMethod.getInstance();
        System.out.println("2. Singleton Object = " + obj2);

        System.out.println("Are Equal = " + (obj1 == obj2));
    }

    private void threadSafeBlock() {
        //Thread-safe method initialization demo
        System.out.println("\nThread-Safe Block Initialization");

        SingletonThreadSafeBlock obj1 = SingletonThreadSafeBlock.getInstance();
        System.out.println("1. Singleton Object = " + obj1);

        SingletonThreadSafeBlock obj2 = SingletonThreadSafeBlock.getInstance();
        System.out.println("2. Singleton Object = " + obj2);

        System.out.println("Are Equal = " + (obj1 == obj2));
    }
}
