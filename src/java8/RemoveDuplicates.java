package java8;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();

        List<String> list = new ArrayList<>();
        list.add("Neha");
        list.add("Ashu");
        list.add("Parth");
        list.add("Ashu");
        list.add("ashu");

        List uniqueElements = obj.removeUsingSet(list);
        System.out.println("Case Sensitive => Removed Duplicates using Set : " + Arrays.toString(uniqueElements.toArray()));

        uniqueElements = obj.removeUsingSetNoCase(list);
        System.out.println("Case Insensitive => Removed Duplicates using Set : " + Arrays.toString(uniqueElements.toArray()));

        uniqueElements = obj.removeUsingSetWithOrder(list);
        System.out.println("Case Sensitive => Removed Duplicates using LinkedHashSet : " + Arrays.toString(uniqueElements.toArray()));

        uniqueElements = obj.removeUsingSetWithOrderNoCase(list);
        System.out.println("Case Insensitive => Removed Duplicates using LinkedHashSet : " + Arrays.toString(uniqueElements.toArray()));


    }

    //Remove duplicates using Set - no order and case sensitive
    private List<String> removeUsingSet(List<String> list) {
        Set<String> set = new HashSet<>();
        set.addAll(list);
        return new ArrayList<>(set);
    }

    //no order and case insensitive
    private List<String> removeUsingSetNoCase(List<String> list) {
        Set<String> set = list.stream().map(str -> str.toLowerCase()).collect(Collectors.toSet());
        return new ArrayList<>(set);
    }

    //order and case insensitive
    private List<String> removeUsingSetWithOrder(List<String> list) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(list);
        return new ArrayList<>(set);
    }

    //no order and case insensitive
    private List<String> removeUsingSetWithOrderNoCase(List<String> list) {
        Set<String> set = list.stream().map(str -> str.toLowerCase()).collect(Collectors.toCollection(LinkedHashSet::new));
        return new ArrayList<>(set);
    }

}
