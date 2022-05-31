package dsa.microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSiblings {

    public static void main(String[] args) {
        ConnectSiblings obj = new ConnectSiblings();

        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(200);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right.right = new Node(300);
        root.right.right.right = new Node(350);

        System.out.println("Preorder traversal : ");
        obj.preorderTraversal(root);

//        obj.connectSiblingsUsingQueue(root);
//        obj.connectSiblings(root);
        obj.connectSiblingsIterative(root);

        System.out.println("The siblings are : ");
        obj.printSiblings(root);
    }

    private void printSiblings(Node root) {
        if(root != null) {
            System.out.println(root.value + " -> " + (root.next != null ? root.next.value : null));
            printSiblings(root.left);
            printSiblings(root.right);
        }
    }

    private void connectSiblingsUsingQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node prev = null;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                Node currNode = queue.poll();
                if (prev != null) {
                    prev.next = currNode;
                }
                prev = currNode;
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }
    }

    private void connectSiblings(Node root) {
        if (root == null) return;

        //connect siblings of next node first at same level
        if (root.next != null) {
            connectSiblings(root.next);
        }

        //set next for left child
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
                root.right.next = getNextLeftMostNode(root);
            } else {
                root.left.next = getNextLeftMostNode(root);
            }
            connectSiblings(root.left);
        }
        //set next for right child if left child is null
        else if (root.right != null) {
            root.right.next = getNextLeftMostNode(root);
            connectSiblings(root.right);
        } else {
            connectSiblings(getNextLeftMostNode(root));
        }
    }

    private Node getNextLeftMostNode(Node root) {
        Node currRoot = root.next;
        while(currRoot != null) {
            if (currRoot.left != null) {
                return currRoot.left;
            }
            if (currRoot.right != null) {
                return currRoot.right;
            }
            currRoot = currRoot.next;
        }
        return null;
    }

    private void preorderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    private void connectSiblingsIterative(Node root) {

        Node parent = root;
        while (parent != null) {
            root = parent;
            while (root != null) {
                //level by level traversal
                if (root.left != null) {
                    if (root.right != null) {
                        root.left.next = root.right;
                    } else {
                        root.left.next = getNextLeftMostNode(root);
                    }
                }

                if (root.right != null) {
                    root.right.next = getNextLeftMostNode(root);
                }

                root = root.next;
            }

            if (parent.left != null) {
                parent = parent.left;
            } else if (parent.right != null) {
                parent = parent.right;
            } else {
                parent = getNextLeftMostNode(parent);
            }
        }

    }

}


class Node {
    int value;
    Node left;
    Node right;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
