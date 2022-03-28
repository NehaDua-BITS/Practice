package dsa.microsoft;

import dsa.easy.trees.TreeNode;

//Same as count good nodes
public class CountVisibleNodes {

    public static void main(String[] args) {
        CountVisibleNodes obj = new CountVisibleNodes();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(13);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(21);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(20);

//        TreeNode root = new TreeNode(-10);
//        root.right = new TreeNode(-15);
//        root.right.right = new TreeNode(-1);

        int count = obj.countVisibleNodes(root);
        System.out.println("Number of visible nodes = " + count);
    }

    private int countVisibleNodes(TreeNode root) {
        return countVisibleNodes(root, Integer.MIN_VALUE);
    }

    private int countVisibleNodes(TreeNode node, int max) {

        if (node == null) return 0;

        max = Math.max(node.val, max);
        return ((node.val >= max) ? 1 : 0)
                + countVisibleNodes(node.left, max)
                + countVisibleNodes(node.right, max);
    }
}
