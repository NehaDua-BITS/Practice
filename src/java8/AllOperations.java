package java8;

import java.util.*;

public class AllOperations {

    public static void main(String[] args) {
        AllOperations obj = new AllOperations();
        obj.listOperations();
    }

    private void listOperations() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(10,12,2,4,3,18,17,13,1));

        //count elements
        long count = nums.stream().count();
        System.out.println("Number of elements => Using Stream Count = " + count + " ; List Size = " + nums.size());

        //find max
        Optional<Integer> maxOptional = nums.stream().max((o1, o2) -> o1 - o2); //this will sort in ascending order
        Integer max = maxOptional.isPresent() ? maxOptional.get() : Integer.MAX_VALUE;
        System.out.println("Max Value = " + max);
        //using sorted() method with comparator
        System.out.println(nums.stream().sorted((o1, o2) -> o2-o1).findFirst().get()); //this will sort in descending order

        //find min
        Optional<Integer> minOptional = nums.stream().min((o1, o2) -> o1 - o2);
        Integer min = minOptional.isPresent() ? minOptional.get() : Integer.MIN_VALUE;
        System.out.println("Min Value = " + min);
        //min using sorted() method
        System.out.println(nums.stream().sorted().findFirst().get());

        //Any element
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ") Any Element: " + nums.stream().findAny().get());
        }

        boolean allMatch = nums.stream().allMatch(n -> n%2==0);
        System.out.println("All match even condition = " + allMatch);

        boolean anyMatch = nums.stream().anyMatch(n -> n%2==0);
        System.out.println("Any match even condition = " + anyMatch);

        allMatch = nums.stream().allMatch(n -> n > 2);
        System.out.println("All match > 2 condition = " + allMatch);

        anyMatch = nums.stream().anyMatch(n -> n > 2);
        System.out.println("Any match > 2 condition = " + anyMatch);

    }

}
