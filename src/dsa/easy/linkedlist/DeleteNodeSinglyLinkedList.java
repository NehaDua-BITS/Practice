package dsa.easy.linkedlist;

public class DeleteNodeSinglyLinkedList {

    public static void main(String[] args) {
        DeleteNodeSinglyLinkedList obj = new DeleteNodeSinglyLinkedList();
        ListNode head = null;
        int n = 4;

        ListNode deleteNode = null;
        ListNode next = null;
        ListNode node = null;
        for (int i = 1; i <= 5; i++) {

            node = new ListNode(i, next);
            next = node;

            if (i == n) {
                deleteNode = node;
            }
        }
        head = node;

        System.out.println("Original List : " + head);
        obj.deleteNode(deleteNode);
        System.out.println("List after deletion : " + head);
    }

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode.next=null;
    }
}
