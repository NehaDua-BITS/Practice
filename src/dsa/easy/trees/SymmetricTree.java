package dsa.easy.trees;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        root.printInorder();

        System.out.println("Is Symmetric = " + new SymmetricTree().isSymmetric(root));
    }

    private boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && isSymmetric(left.left, right.left)
                && isSymmetric(left.right, right.right);
    }

}
