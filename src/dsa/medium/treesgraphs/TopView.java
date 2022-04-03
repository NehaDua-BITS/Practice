package dsa.medium.treesgraphs;

import dsa.easy.trees.TreeNode;

import java.util.*;

public class TopView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        new TopView().printTopView(root);
    }

    private void printTopView(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, TreeNode> map = getNodesByHorizontalDist(root);
        for (TreeNode node : map.values()) {
            System.out.println(node);
        }
    }

    private TreeMap<Integer, TreeNode> getNodesByHorizontalDist(TreeNode root) {

        TreeMap<Integer, TreeNode> treeMap = new TreeMap<>();

        Queue<NodeWithHD> queue = new LinkedList<>();
        queue.add(new NodeWithHD(root, 0));

        while (!queue.isEmpty()) {

            NodeWithHD currNode = queue.remove();

            //add curr node to TreeMap for printing vertical order
            TreeNode mapValue = treeMap.get(currNode.hd);
            if (mapValue == null) {
                treeMap.put(currNode.hd, currNode.node);
            }

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

    private class NodeWithHD {
        private TreeNode node;
        private int hd;

        NodeWithHD(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

}
