package dsa.medium.treesgraphs;

import dsa.easy.trees.TreeNode;

public class DiameterOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(10);
        root.right.left.right.right = new TreeNode(11);
        root.right.left.right.right.right = new TreeNode(12);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        DiameterOfTree obj = new DiameterOfTree();
        System.out.println("Non-Optimised: Diameter of tree  = " + obj.diameter(root));
        System.out.println("Optimised: Diameter of tree = " + obj.diameterOptimised(root));
    }

    //calculate height in same iteration as diameter O(n)
    private int diameterOptimised(TreeNode root) {
        return diameterOptimised(root, new Height());
    }

    private int diameterOptimised(TreeNode root, Height height) {
        if (root == null) {
            height.value = 0;
            return 0;
        }

        //find diameter and height of left subtree
        Height lh = new Height();
        int leftDiameter = diameterOptimised(root.left, lh);

        //find diameter and height of right subtree
        Height rh = new Height();
        int rightDiameter = diameterOptimised(root.right, rh);

        //set height of current node
        height.value = 1 + Math.max(lh.value, rh.value);

        //return diameter of current node
        return Math.max(1 + lh.value + rh.value, Math.max(leftDiameter, rightDiameter));
    }

    class Height {
        int value;

        void setHeight(int value) {
            this.value = value;
        }
    }

    //height is calculated separately O(n^2)
    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiamter = diameter(root.right);

        return Math.max(1 + lHeight + rHeight, Math.max(leftDiameter, rightDiamter));
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

}
