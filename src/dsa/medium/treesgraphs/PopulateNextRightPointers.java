package dsa.medium.treesgraphs;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulateNextRightPointers {

    public static void main(String[] args) {

        PopulateNextRightPointers obj = new PopulateNextRightPointers();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The original tree is : ");
        obj.printTree(root);

        root = obj.connect(root);
//        root = obj.connectRecursive(root);
        System.out.println("\nThe updated tree is : ");
        obj.printTree(root);
    }

    private void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.val + " : Next = " + (root.next != null ? root.next.val : null));
            printTree(root.right);
        }
    }

    private Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            Node prev = null;
            for (int i = 0; i < count; i++) {
                Node currNode = queue.remove();
                currNode.next = null;
                if (prev != null) {
                    prev.next = currNode;
                }
                prev = currNode;

                //push children
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return root;
    }

    private Node connectRecursive(Node node) {

        if (node == null) return null;

        //first set right of other nodes at same level
        if (node.next != null) {
            connectRecursive(node.next);
        }

        //set next of left and right children
        if (node.left != null) {
            if (node.right != null) {
                node.left.next = node.right;
                node.right.next = getNextRight(node);
            } else {
                node.left.next = getNextRight(node);
            }
            connectRecursive(node.left);
        }
        else if (node.right != null) {
            node.right.next = getNextRight(node);
            connectRecursive(node.right);
        }
        else {
            connectRecursive(getNextRight(node));
        }

        return node;
    }

    private Node getNextRight(Node node) {
        Node temp = node.next;
        while(temp != null) {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.next;
        }

        return null;
    }

}
