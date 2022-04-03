package dsa.adobe;

import java.util.*;

public class PriorityQueueDemo {
    
    public static void main(String[] args) {
        PriorityQueueDemo obj = new PriorityQueueDemo();
        obj.queueWithNaturalOrdering();
        obj.queueWithComparator();
    }

    private void queueWithNaturalOrdering() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(15);
        priorityQueue.add(2);
        priorityQueue.add(19);
        priorityQueue.add(10);


        //not sorted order
//        Iterator iterator = priorityQueue.stream().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("Queue size = " + priorityQueue.size());

        System.out.println("Using natural ordering : ");
        //gives in sorted order
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.poll());
        }
    }

    private void queueWithComparator() {
        Comparator<Integer> descComparator = (o1, o2) -> (o2-o1);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(descComparator);
        priorityQueue.add(15);
        priorityQueue.add(2);
        priorityQueue.add(19);
        priorityQueue.add(10);

        System.out.println("Using comparator : ");
        //gives in sorted order
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.poll());
        }
    }

    private void otherQueue() {

    }
}
