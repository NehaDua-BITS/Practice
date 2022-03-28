package java8.functionalinterface;

public class ProductOperation implements OperationFunctionalInterface {

    @Override
    public void print(int x) {
        System.out.println(x);
    }

    @Override
    public void operation() {
        System.out.println("a/b = " + (a/b));
        OperationFunctionalInterface.super.operation();
        OperationFunctionalInterface.sum();
    }
}
