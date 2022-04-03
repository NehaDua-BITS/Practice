package dsa.medium.treesgraphs;

import dsa.easy.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class RightView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        RightView obj = new RightView();
        System.out.println("Right View using Level Order Traversal : ");
        obj.printRightViewUsingLevelOrder(root);

        System.out.println("Right View using Max Value : ");
        obj.printRightViewUsingMaxLevel(root);
    }

    private void printRightViewUsingLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.remove();
                if ( i == size-1) {
                    System.out.println(currNode);
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }

    private void printRightViewUsingMaxLevel(TreeNode root) {
        if(root == null) return;

        printRightView(root, 1, new MaxLevel(0));
    }

    private void printRightView(TreeNode root, int currLevel, MaxLevel maxLevel) {
        if (root != null) {
            if (currLevel > maxLevel.value) {
                System.out.println(root);
                maxLevel.setValue(currLevel);
            }

            printRightView(root.right, currLevel+1, maxLevel);
            printRightView(root.left, currLevel+1, maxLevel);
        }
    }

    class MaxLevel {
        int value;

        MaxLevel(int value) {
            this.value = value;
        }

        void setValue(int value) {
            this.value = value;
        }
    }
}
