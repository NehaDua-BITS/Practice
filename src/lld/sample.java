package lld;

import java.util.LinkedList;
import java.util.Queue;

public class sample {

    public static void main(String[] args) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1));
        queue.add(new Node(2));
        Node node = queue.remove();
        System.out.println(queue.peek());
    }

}

class Node {
    int val;
    Node(int val) {
        this.val = val;
    }
}
