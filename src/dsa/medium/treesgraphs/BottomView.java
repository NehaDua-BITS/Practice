package dsa.medium.treesgraphs;

import dsa.easy.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.right = new TreeNode(25);

        BottomView obj = new BottomView();
        System.out.println("Bottom View using Level Order traversal and TreeMap :");
        obj.printBottomViewUsingLevelOrder(root);

        System.out.println("Bottom View using Preorder traversal and TreeMap");
        obj.printBottomViewUsingPreorder(root);
    }

    //using Level order traversal and TreeMap
    private void printBottomViewUsingLevelOrder(TreeNode root) {
        TreeMap<Integer, TreeNode> map = getNodesByHorzontalDist(root);
        //print map
        for (TreeNode node : map.values()) {
            System.out.println(node);
        }
    }

    private TreeMap<Integer, TreeNode> getNodesByHorzontalDist(TreeNode root) {
        TreeMap<Integer, TreeNode> treeMap = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList();
        queue.add(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.remove();
            //overwriting existing entry to get last in level order traversal
            treeMap.put(queueNode.hd, queueNode.node);

            if (queueNode.node.left != null) {
                queue.add(new QueueNode(queueNode.node.left, queueNode.hd-1));
            }
            if (queueNode.node.right != null) {
                queue.add(new QueueNode(queueNode.node.right, queueNode.hd+1));
            }
        }

        return treeMap;
    }

    //using Pre-order traversal and TreeMap
    private void printBottomViewUsingPreorder(TreeNode root) {
        TreeMap<Integer, DistPair> treeMap = new TreeMap<>();
        preorderTraversal(root, 0, 1, treeMap);

        //print map
        for (DistPair pair : treeMap.values()) {
            System.out.println(pair.node);
        }
    }

    private void preorderTraversal(TreeNode root, int hd, int depth, TreeMap<Integer, DistPair> treeMap) {
        if (root != null) {
             DistPair pair = treeMap.get(hd);
             if (pair == null || pair.depth < depth) {
                 treeMap.put(hd, new DistPair(root, depth));
             }

             preorderTraversal(root.left, hd-1, depth+1, treeMap);
             preorderTraversal(root.right, hd+1, depth+1, treeMap);
        }
    }

    class DistPair {
        int depth;
        TreeNode node;

        DistPair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    private class QueueNode {
        TreeNode node;
        int hd;

        QueueNode(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
