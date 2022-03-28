package dsa.easy.trees;

public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth obj = new MaxDepth();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(23);

        System.out.println("Tree is : ");
        obj.printInfix(root);

        System.out.println("Max depth of tree = " + obj.maxDepth(root));
    }

    private void printInfix(TreeNode root) {
        if (root != null) {
            printInfix(root.left);
            System.out.println(root.val);
            printInfix(root.right);
        }
    }

    private int maxDepth(TreeNode root) {

        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
