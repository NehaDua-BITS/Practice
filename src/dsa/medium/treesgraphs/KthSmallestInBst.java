package dsa.medium.treesgraphs;

import dsa.easy.trees.TreeNode;

import java.util.ArrayList;

public class KthSmallestInBst {

    public static void main(String[] args) {
        KthSmallestInBst obj = new KthSmallestInBst();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 4;
        int smallestElement = obj.kthSmallest(root, k);
//        int smallestElement = obj.kthSmallestUsingInorderAndCount(root, k);
        System.out.println(k + "th smallest element = " + smallestElement);
    }

    private int kthSmallest(TreeNode root, int k) {
        return kthSmallestUsingInorderTraversal(root, k, new ArrayList<>());
    }


    private int kthSmallestUsingInorderTraversal(TreeNode root, int k, ArrayList<Integer> numbers) {
        if (root == null) return -1;

        int result = kthSmallestUsingInorderTraversal(root.left, k, numbers);
        if (result != -1) return result;

        numbers.add(root.val);
        if (numbers.size() == k) {
            return root.val;
        }

        return kthSmallestUsingInorderTraversal(root.right, k, numbers);
    }

    //count is a static variable
//    private int kthSmallestUsingInorderAndCount(TreeNode root, int k) {
//        if (root == null) return -1;
//
//        int result = kthSmallestUsingInorderAndCount(root.left, k);
//        if (result != -1) return result;
//
//        count++;
//        if ( k == count) {
//            return root.val;
//        }
//
//        return kthSmallestUsingInorderAndCount(root.right, k);
//    }

}
