package dsa.easy.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal obj = new LevelOrderTraversal();
        List<List<Integer>> result = obj.levelOrder(root);
        System.out.println("Traversal is : " + Arrays.toString(result.toArray()));
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) return resultList;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            ArrayList<Integer> valueList = new ArrayList<>();
            int count = queue.size();

            while (count > 0) {

                TreeNode currNode = queue.remove();
                valueList.add(currNode.val);

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

                count--;
            }
            resultList.add(valueList);
        }

        return resultList;
    }

}
