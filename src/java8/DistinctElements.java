package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DistinctElements {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,1,4,10};
        nums = Arrays.stream(nums).distinct().toArray();
        System.out.println("Array Distinct Elements = " + Arrays.toString(nums));

        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,4,2,1,4,10));
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println("List Distinct Elements = " + Arrays.toString(list.toArray()));

        System.out.println("Distinct Objects => ");
        new DistinctElements().distinctObjects();
    }

    private void distinctObjects() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "neha", 22));
        students.add(new Student(2, "parth", 21));
        students.add(new Student(1, new String("neha"), 22));
        students.add(new Student(3, "ashu", 21));

        System.out.println("Original Students List : " + Arrays.toString(students.toArray()));
        List<Student> uniqueStudents = students.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique Students List : " + Arrays.toString(uniqueStudents.toArray()));
    }
}

class Student {
    private int rollNo;
    private String name;
    private int age;

    public Student(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo && age == student.age && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, name, age);
    }
}
