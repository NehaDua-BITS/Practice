package dsa.easy.trees;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printInorder() {
        printInorder(this);
    }

    public void printPreorder() {
        printPreorder(this);
    }

    private void printPreorder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            printPreorder(treeNode.left);
            printPreorder(treeNode.right);
        }
    }

    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.val);
            printInorder(root.right);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}


