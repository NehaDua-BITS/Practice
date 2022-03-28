package dsa.easy.linkedlist;

public class DeleteNthNode {

    public static void main(String[] args) {
        DeleteNthNode obj = new DeleteNthNode();
        int max = 5;
        ListNode next = null;
        ListNode node = null;
        for (int i = 1; i <= max; i++) {
            node = new ListNode(i, next);
            next = node;
        }
        ListNode head = node;

        System.out.println("Original List : " + head);

//        head = obj.removeNthFromEnd(head, 5);
//        System.out.println("List after deletion : " + head);

        head = obj.removeNthFromEndOptimised(head, 1);
        System.out.println("List after optimised deletion : " + head);
    }

    private ListNode removeNthFromEndOptimised(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n-1; i++) {
            if (fast.next == null) break;
            fast = fast.next;
        }

        ListNode prev = null;
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null) {
            head = slow.next;
        } else {
            prev.next = slow.next;
        }
        slow.next=null;

        return head;
    }


    private ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        for (ListNode currNode = head; currNode != null; currNode = currNode.next) {
            length++;
        }

        ListNode prev = null;
        ListNode node = head;
        for (int i = 0; i < length-n; i++) {
            prev = node;
            node = node.next;
        }

        if (prev == null) {
            head = node.next;
        } else {
            prev.next = node.next;
        }

        node.next = null;

        return head;
    }
}
