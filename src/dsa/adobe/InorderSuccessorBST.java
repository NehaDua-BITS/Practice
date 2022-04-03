package dsa.adobe;

import dsa.easy.trees.TreeNode;

public class InorderSuccessorBST {

    private static TreeNode prevNode = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        TreeNode target = root.left.right.right;
        InorderSuccessorBST obj = new InorderSuccessorBST();
        TreeNode successor = obj.inorderSuccessor(root, target);
        System.out.println("Successor using inorder traversal = " + (successor != null ? successor.val : null));

        successor = obj.inorderSuccessorUsingPrevNode(root, target);
        System.out.println("Successor using prev node = " + (successor != null ? successor.val : null));
    }

    private TreeNode inorderSuccessor(TreeNode root, TreeNode target) {
        if (root != null) {

            TreeNode successor = inorderSuccessor(root.left, target);
            if (successor != null) {
                return successor;
            }

            //found first node with value greater than given node
            if (root.val > target.val) {
                return root;
            }

            return inorderSuccessor(root.right, target);
        }

        return null;
    }

    private TreeNode inorderSuccessorUsingPrevNode(TreeNode root, TreeNode target) {
        if (root != null) {

            TreeNode successor = inorderSuccessorUsingPrevNode(root.left, target);
            if (successor != null) {
                return successor;
            }

            //found node which has previous node as target
            if (prevNode != null && prevNode.val == target.val) {
                return root;
            }

            prevNode = root;

            return inorderSuccessorUsingPrevNode(root.right, target);
        }

        return null;
    }
}
