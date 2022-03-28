package dsa.easy.trees;

import java.util.Stack;

public class MirrorTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        root.printInorder();

        System.out.println("Is Mirror using Recursion = " + new MirrorTree().isMirror(root));

        System.out.println("Is Mirror using Iteration = " + new MirrorTree().isMirrorIterative(root));
    }

    public boolean isMirror(TreeNode root) {
        if (root == null) {
            return true;
        }
        return areMirror(root.left, root.right);
    }

    private boolean areMirror(TreeNode leftTree, TreeNode rightTree) {

        if (leftTree == null && rightTree == null) {
            return true;
        }

        if (leftTree == null || rightTree == null || (leftTree.val != rightTree.val)) {
            return false;
        }

        return areMirror(leftTree.left, rightTree.right) &&
                areMirror(leftTree.right, rightTree.left);
    }

    private boolean isMirrorIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirrorIterative(root.left, root.right);
    }

    private boolean isMirrorIterative(TreeNode leftTree, TreeNode rightTree) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

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

            TreeNode lNode = stack1.pop();
            TreeNode rNode = stack2.pop();
            if (lNode.val != rNode.val) {
                return false;
            }

            leftTree = lNode.right;
            rightTree = rNode.left;
        }
    }
}
