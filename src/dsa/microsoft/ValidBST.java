package dsa.microsoft;

import dsa.easy.trees.TreeNode;

public class ValidBST {

    private TreeNode prevNode;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidBST obj = new ValidBST();
        boolean result = obj.isValidBST(root);
        System.out.println("Is valid BST = " + result);
    }

    /**
     * perform inorder traversal and check validity
     * values should be accessed in ascending order
     * @param root
     * @return
     */
    private boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        if (prevNode != null && (root.val <= prevNode.val)) {
            return false;
        }

        return isValidBST(root.right);
    }
}
