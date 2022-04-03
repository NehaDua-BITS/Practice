package dsa.medium.treesgraphs;

import dsa.easy.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    private static int maxLevel;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        LeftView obj = new LeftView();
        System.out.println("Left View using Level Order traversal and queue : ");
        obj.printLeftView(root);

        System.out.println("Left View using Preorder traversal and maxLevel variable : ");
        obj.printLeftViewUsingNoQueue(root);
    }

    private void printLeftView(TreeNode root) {
        if (root == null) {
            return;
        }

        //use level order traversal and print only 1st element in each level
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int numOfNodes = queue.size();
            for (int i = 0; i < numOfNodes; i++) {
                TreeNode currNode = queue.remove();
                if (i == 0) {
                    System.out.println(currNode.val);
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

    private void printLeftViewUsingNoQueue(TreeNode root) {
        printLeftViewUsingNoQueue(root, 1);
    }

    //pre order traversal with level info
    private void printLeftViewUsingNoQueue(TreeNode root, int currLevel) {
        if (root != null) {
            if (currLevel > maxLevel) {
                System.out.println(root.val);
                maxLevel = currLevel;
            }

            printLeftViewUsingNoQueue(root.left, currLevel+1);
            printLeftViewUsingNoQueue(root.right, currLevel+1);
        }
    }

}
