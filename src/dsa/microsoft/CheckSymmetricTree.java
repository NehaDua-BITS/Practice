package dsa.microsoft;

import java.util.Stack;

public class CheckSymmetricTree {

    public static void main(String[] args) {
        CheckSymmetricTree obj = new CheckSymmetricTree();
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.right.right = new Node(1);

        System.out.println("Are symmetric = " + obj.isSymmetric(root));
    }

    private boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return areEqual(root.left, root.right);
    }

    private boolean areEqual(Node leftTree, Node rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }

        if (leftTree == null || rightTree == null) {
            return false;
        }

        return (leftTree.value == rightTree.value)
                && areEqual(leftTree.left, rightTree.right)
                && areEqual(leftTree.right, rightTree.left);
    }

    private boolean isMirrorIterative(Node leftTree, Node rightTree) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while (true) {

            while (leftTree != null && rightTree != null) {
                stack1.push(leftTree);
                stack2.push(rightTree);
                leftTree = leftTree.left;
                rightTree = rightTree.right;
            }

            if (!(leftTree == null && rightTree == null)) {
                return false;
            }

            if (stack1.empty() && stack2.empty()) {
                return true;
            }
            if (stack1.empty() || stack2.empty()) {
                return false;
            }

            Node lNode = stack1.pop();
            Node rNode = stack2.pop();
            if (lNode.value != rNode.value) {
                return false;
            }

            leftTree = lNode.right;
            rightTree = rNode.left;
        }
    }
}

