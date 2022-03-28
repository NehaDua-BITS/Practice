package dsa.easy.trees;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidateBST {

    TreeNode prev ;

    public static void main(String[] args) {
        ValidateBST obj = new ValidateBST();
        
        TreeNode root = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);

        System.out.println("Tree is : ");
        root.printInorder();

        System.out.println("Is Valid BST = " + obj.isValidBST(root));

        System.out.println("Is Valid BST using min max = " + obj.isValidBSTUsingMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println("Is Valid BST using prev = " + obj.isValidBSTUsingPrev(root));
    }

    private boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root, list);
        System.out.println("Sorted list of items is = " + Arrays.toString(list.toArray()));

        int size = list.size();
        for (int i = 1; i < size; i++) {
            if (list.get(i) <= list.get(i-1)) {
                return false;
            }
        }

        return true;
    }

    //issue when values are integer min / max in tree
    private boolean isValidBSTUsingMinMax(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return isValidBSTUsingMinMax(root.left, min, root.val-1)
                && isValidBSTUsingMinMax(root.right, root.val+1, max);
    }

    private void traverse(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            traverse(root.left, list);
            list.add(root.val);
            traverse(root.right, list);
        }
    }

    private boolean isValidBSTUsingPrev(TreeNode root) {
        if (root == null) return true;

        if (!isValidBSTUsingPrev(root.left)) return false;

        if (prev != null && (root.val <= prev.val)) return false;

        prev = root;

        return isValidBSTUsingPrev(root.right);
    }
}
