package dsa.easy.trees;

import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal obj = new InorderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println("Recursive Inorder Traversal : ");
        obj.inorderRecursive(root);

        System.out.println("\nIterative Inorder Traversal : ");
        obj.inorderIterative(root);
    }

    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }

    private void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //when root is null pop from stack
            if (stack.empty()) break;

            root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;
        }

    }

}
