package java8.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Helper {

    public static void main(String[] args) {
        ProductOperation productOperation = new ProductOperation();
        productOperation.print(10);
        productOperation.operation();

        Helper helper = new Helper();
        //using user-defined functional interface
        helper.accessUsingLambda();

        //using in-built functional interfaces
        helper.usingInBuiltFI();
    }

    private void accessUsingLambda() {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 10, 45,32, 21));

        //creating instance using lambda expression
        OperationFunctionalInterface operation = (x) -> System.out.println(x);
        list.stream().forEach(x -> operation.print(x));
    }

    private void usingInBuiltFI() {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 10, 45, 32, 21));

        //Predicate
        List<Integer> result = list.stream().filter((x) -> x%2 == 0).collect(Collectors.toList());
        System.out.println("Predicate Result (Even Numbers) => " + Arrays.toString(result.toArray()));

        //Consumer
        System.out.println("Consumer Result (Print) => ");
        list.stream().forEach(x -> System.out.println(x));

        //Function
        result = list.stream().map(x -> x+2).collect(Collectors.toList());
        System.out.println("Function Result (increment by 2) => " + Arrays.toString(result.toArray()));

        BiFunction<Integer, Integer, Double> biFunction = (x, y) -> (double)(x + y);
        Double value = biFunction.apply(3, 5);
        System.out.println("Bi-Function Result => " + value);

        result = list.stream().peek(x -> System.out.println(x+2)).collect(Collectors.toList());
        System.out.println("Peek() operation Result => " + Arrays.toString(result.toArray()));
    }
}
