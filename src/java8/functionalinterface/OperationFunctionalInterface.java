package java8.functionalinterface;

/**
 * Introduced in Java 8
 * Instances can be created with lambda expressions, method references, or constructor references.
 * Constraints:
 * 1. Should have exactly one abstract method
 * 2. Can have any number of static and default methods
 * 3. Use in only interface type allowed
 *
 * Ex: Runnable, Comparator, Callable, ActionListener
 *
 * Also called SAM interfaces (single abstract method)
 *
 * Annotation is optional but helps in checking at compiler level
 */
@FunctionalInterface
public interface OperationFunctionalInterface {

    int a = 90;
    int b = 10;

    //can have exactly one abstract method
    void print(int x);

    //can have any number of static and default methods

    static int sum() {
        return a+b;
    }

    default void operation() {
        System.out.println("a * b = " + a * b);
    }

}
