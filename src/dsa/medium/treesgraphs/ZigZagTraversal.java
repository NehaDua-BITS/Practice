package dsa.medium.treesgraphs;

import dsa.easy.trees.TreeNode;

import java.util.*;

public class ZigZagTraversal {

    public static void main(String[] args) {
        ZigZagTraversal obj = new ZigZagTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("Zig-Zag Level Order Traversal = " + Arrays.toString(obj.zigzagLevelOrder(root).toArray()));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelItems = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove();
                levelItems.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (level % 2 == 0) {
                reverseList(levelItems);
            }
            result.add(levelItems);
            level++;
        }

        return result;
    }

    private void reverseList(List<Integer> list) {
        for (int i = 0, j = list.size()-1; i < j; i++, j--) {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}
