package dsa.medium.treesgraphs;

import dsa.easy.trees.TreeNode;

import java.util.*;

public class VerticalOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        //root.printPreorder();
        new VerticalOrder().printVerticalOrder(root);
    }

    private void printVerticalOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, List<TreeNode>> map = groupNodesByHorizontalDist(root);
        for (List<TreeNode> list : map.values()) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private TreeMap<Integer, List<TreeNode>> groupNodesByHorizontalDist(TreeNode root) {

        TreeMap<Integer, List<TreeNode>> treeMap = new TreeMap<>();

        Queue<NodeWithHD> queue = new LinkedList<>();
        queue.add(new NodeWithHD(root, 0));

        while (!queue.isEmpty()) {

            NodeWithHD currNode = queue.remove();

            //add curr node to TreeMap for printing vertical order
            List<TreeNode> list = treeMap.getOrDefault(currNode.hd, new ArrayList<>());
            list.add(currNode.node);
            treeMap.put(currNode.hd, list);

            //add left child to queue with updated HD
            if (currNode.node.left != null) {
                queue.add(new NodeWithHD(currNode.node.left, currNode.hd-1));
            }

            //add right child to queue with updated HD
            if (currNode.node.right != null) {
                queue.add(new NodeWithHD(currNode.node.right, currNode.hd+1));
            }
        }

        return treeMap;
    }

    class NodeWithHD {
        private TreeNode node;
        private int hd;

        NodeWithHD(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

}
